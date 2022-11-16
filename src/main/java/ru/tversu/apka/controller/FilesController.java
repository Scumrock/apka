package ru.tversu.apka.controller;

import static org.springframework.http.MediaType.APPLICATION_PROBLEM_JSON_VALUE;
import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;

import com.jlefebure.spring.boot.minio.MinioException;
import com.jlefebure.spring.boot.minio.MinioService;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import ru.tversu.apka.model.FileObject;
import ru.tversu.apka.service.FileObjectService;
import ru.tversu.apka.vm.UploadResponse;

@Slf4j
@RestController
@RequestMapping(value = "/api")
public class FilesController {

  private final MinioService minioService;
  private final FileObjectService fileObjectService;

  @Autowired
  public FilesController(MinioService minioService,
                         FileObjectService fileObjectService) {
    this.minioService = minioService;
    this.fileObjectService = fileObjectService;
  }

  @GetMapping(value = {"/files/{uuid:[a-z0-9-]+}"})
  public void download(@PathVariable(value = "uuid", required = false) String uuid,
                       HttpServletResponse response, HttpServletRequest request)
      throws MinioException, IOException {

    final FileObject fileObject = fileObjectService
        .findFileObjectByUuid(uuid, request);

    String contentType = MediaType.APPLICATION_OCTET_STREAM_VALUE;
    if (fileObject.getMimeType() != null) {
      contentType = fileObject.getMimeType();
    }

    InputStream inputStream = minioService.get(fileObjectService.getFilePath(fileObject));

    // Set the content type and attachment header.
    String encodedOriginalName = URLEncoder.encode(fileObject.getOriginalName(), Charset.forName("UTF-8"));
    response.addHeader(HttpHeaders.CONTENT_DISPOSITION,
        "attachment; filename*=UTF-8''" + encodedOriginalName);
    response.setContentType(contentType);
    response.setCharacterEncoding("UTF-8");
    response.setContentLength(Long.valueOf(fileObject.getLength()).intValue());

    // Copy the stream to the response's output stream.
    IOUtils.copy(inputStream, response.getOutputStream());
    response.flushBuffer();
  }

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping(path = "/files", consumes = {MULTIPART_FORM_DATA_VALUE},
      produces = {APPLICATION_PROBLEM_JSON_VALUE})
  public ResponseEntity<UploadResponse> upload(@RequestParam("file") MultipartFile multipartFile,
                                               HttpServletRequest request) throws Exception {
    final URI type = URI.create(request.getRequestURI());
    final FileObject fileItem = fileObjectService.saveFile(multipartFile);
    final UploadResponse response =
        UploadResponse.builder().withFileItem(fileItem).withType(type).build();
    return ResponseEntity.status(HttpStatus.CREATED).body(response);
  }

}
