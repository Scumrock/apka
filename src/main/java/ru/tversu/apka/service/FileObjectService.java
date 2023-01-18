package ru.tversu.apka.service;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;
import ru.tversu.apka.domain.FileObject;

public interface FileObjectService {

  List<String> IMAGE_MIMETYPES = Arrays.asList("image/jpeg", "image/png", "image/gif");

  FileObject saveFile(MultipartFile multipartFile, Long userId) throws Exception;

  Collection<FileObject> saveFiles(MultipartFile[] multipartFiles, Long userId) throws Exception;

//  FileObject saveFile(MultipartFile multipartFile, String oldFileName) throws Exception;

  Long getContentLengthByFileName(String folder, String filename) throws Exception;

  /**
   * Строит путь к объекту, сохраненному в объектном хранилище.
   *
   * @param fileObject метаданные файла
   * @return Путь к объекту в хранилище
   */
  Path getFilePath(FileObject fileObject);

  /**
   * Получает объект FileStorageItem из репозитория по его UUID (objectId) или по названию файла
   *
   * @param uuid    UUID запрашиваемого файла. Если пустой, пытаемся извлечь его из названия файла
   * @param request Реквест, нужный для формирования URI
   * @throws MalformedURLException Если в сигнатуре метода пустые и uuid и fileName
   */
  FileObject findFileObjectByUuid(String uuid, HttpServletRequest request)
      throws MalformedURLException;

  void deleteFileObjectByUuid(String uuid, HttpServletRequest request) throws MalformedURLException;
}
