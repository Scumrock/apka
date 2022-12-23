package ru.tversu.apka.web.rest;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.tversu.apka.service.ApplicationService;
import ru.tversu.apka.service.CommentService;
import ru.tversu.apka.service.dto.ApplicationDTO;
import ru.tversu.apka.service.dto.CommentDTO;

@Slf4j
@RestController
@RequestMapping(value = "/api")
public class ApplicationController {

  private final ApplicationService applicationService;
  private final CommentService commentService;

  @Autowired
  public ApplicationController(ApplicationService applicationService,
                               CommentService commentService) {
    this.applicationService = applicationService;
    this.commentService = commentService;
  }

  @GetMapping(path = "/applications",
      produces = "application/json")
  public ResponseEntity<List<ApplicationDTO>> listAllApplications() {
    List<ApplicationDTO> applications = applicationService.listAll();
    return ResponseEntity.ok(applications);
  }

  @GetMapping(path = "/applications/{id}",
      produces = "application/json")
  public ResponseEntity<Optional<ApplicationDTO>> getApplications(@PathVariable(name = "id") UUID id) {
    Optional<ApplicationDTO> application = applicationService.findOne(id);
    return ResponseEntity.ok(application);
  }

  @PostMapping(path = "/applications", consumes = "application/json", produces = "application/json")
  public ResponseEntity<ApplicationDTO> createApplication(@RequestBody ApplicationDTO application) {
    ApplicationDTO response = applicationService.create(application);
    return ResponseEntity.ok(response);
  }

  @PostMapping(path = "/applications/{applicationId}/comments", consumes = "application/json", produces = "application/json")
  public ResponseEntity<CommentDTO> createComment(
      @PathVariable(name = "applicationId") UUID applicationId,
      @RequestBody CommentDTO commentDTO) {
    if (!Objects.equals(applicationId, commentDTO.getApplicationId())) {
      throw new RuntimeException("applicationId and commentDTO.getApplicationId() mismatch");
    }
    CommentDTO response = commentService.create(commentDTO);
    return ResponseEntity.ok(response);
  }

  @PutMapping(path = "/applications/{applicationId}/comments/{commentId}", consumes = "application/json", produces = "application/json")
  public ResponseEntity<CommentDTO> updateComment(
      @PathVariable(name = "applicationId") UUID applicationId,
      @PathVariable(name = "commentId") Long commentId,
      @RequestBody CommentDTO commentDTO) {
    if (!Objects.equals(applicationId, commentDTO.getApplicationId())) {
      throw new RuntimeException("applicationId and commentDTO.getApplicationId() mismatch");
    }

    if (!Objects.equals(commentId, commentDTO.getId())) {
      throw new RuntimeException("commentId and commentDTO.getId() mismatch");
    }

    CommentDTO response = commentService.update(commentId, commentDTO);
    return ResponseEntity.ok(response);
  }

  @PatchMapping(path = "/applications/{applicationId}/comments/{commentId}", consumes = "application/json", produces = "application/json")
  public ResponseEntity<Optional<CommentDTO>> patchComment(
      @PathVariable(name = "applicationId") UUID applicationId,
      @PathVariable(name = "commentId") UUID commentId,
      @RequestBody CommentDTO commentDTO) {
    if (!Objects.equals(applicationId, commentDTO.getApplicationId())) {
      throw new RuntimeException("applicationId and commentDTO.getApplicationId() mismatch");
    }

    if (!Objects.equals(commentId, commentDTO.getId())) {
      throw new RuntimeException("commentId and commentDTO.getId() mismatch");
    }

    Optional<CommentDTO> response = commentService.patch(commentDTO);
    return ResponseEntity.ok(response);
  }

  @GetMapping(path = "/applications/{applicationId}/comments", produces = "application/json")
  public ResponseEntity<List<CommentDTO>> listAllComments(@PathVariable(name = "applicationId") UUID applicationId) {

    List<CommentDTO> response = commentService.findAllByApplication(applicationId);
    return ResponseEntity.ok(response);
  }

  @GetMapping(path = "/applications/{applicationId}/comments/{commentId}", produces = "application/json")
  public ResponseEntity<Optional<CommentDTO>> listAllComments(
      @PathVariable(name = "applicationId") UUID applicationId,
      @PathVariable(name = "commentId") Long commentId) {

    Optional<CommentDTO> response = commentService.findOne(commentId, applicationId);
    return ResponseEntity.ok(response);
  }
}
