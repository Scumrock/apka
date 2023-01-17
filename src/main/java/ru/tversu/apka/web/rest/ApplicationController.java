package ru.tversu.apka.web.rest;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.tversu.apka.domain.Application;
import ru.tversu.apka.service.ApplicationService;
import ru.tversu.apka.service.CommentService;
import ru.tversu.apka.service.dto.ApplicationDTO;
import ru.tversu.apka.service.dto.CommentDTO;

@Slf4j
@RestController
@RequestMapping(value = "/api")
@RequiredArgsConstructor
public class ApplicationController {

  private final ApplicationService applicationService;
//  private final CommentService commentService;

  @PostMapping(path = "/applications/save", consumes = "application/json", produces = "application/json")
  public ResponseEntity<Application> createApplication(@RequestBody ApplicationDTO applicationDTO) {
    Application response = applicationService.saveApplication(applicationDTO);
    return ResponseEntity.ok(response);
  }

  @PutMapping(path = "/applications/update/{id}", produces = "application/json")
  public ResponseEntity<Application> updateApplication(@RequestBody ApplicationDTO applicationDTO, @PathVariable(name = "id") UUID id) {
    Application response = applicationService.updateApplication(applicationDTO, id);
    return ResponseEntity.ok(response);
  }

  @GetMapping(path = "/applications",
          produces = "application/json")
  public ResponseEntity<List<Application>> listAllApplications() {
    List<Application> applications = applicationService.allApplications();
    return ResponseEntity.ok(applications);
  }

  @GetMapping(path = "/applications/{id}",
          produces = "application/json")
  public ResponseEntity<Optional<Application>> getApplications(@PathVariable(name = "id") UUID id) {
    Optional<Application> application = applicationService.getApplication(id);
    return ResponseEntity.ok(application);
  }

  @DeleteMapping(path = "/applications/delete/{id}", produces = "application/json")
  void deleteApplication(@PathVariable(name = "id") UUID id) {
    applicationService.deleteApplication(id);
  }

//  @PostMapping(path = "/applications/{applicationId}/comments", consumes = "application/json", produces = "application/json")
//  public ResponseEntity<CommentDTO> createComment(
//      @PathVariable(name = "applicationId") UUID applicationId,
//      @RequestBody CommentDTO commentDTO) {
//    if (!Objects.equals(applicationId, commentDTO.getApplicationId())) {
//      throw new RuntimeException("applicationId and commentDTO.getApplicationId() mismatch");
//    }
//    CommentDTO response = commentService.create(commentDTO);
//    return ResponseEntity.ok(response);
//  }
//
//  @PutMapping(path = "/applications/{applicationId}/comments/{commentId}", consumes = "application/json", produces = "application/json")
//  public ResponseEntity<CommentDTO> updateComment(
//      @PathVariable(name = "applicationId") UUID applicationId,
//      @PathVariable(name = "commentId") Long commentId,
//      @RequestBody CommentDTO commentDTO) {
//    if (!Objects.equals(applicationId, commentDTO.getApplicationId())) {
//      throw new RuntimeException("applicationId and commentDTO.getApplicationId() mismatch");
//    }
//
//    if (!Objects.equals(commentId, commentDTO.getId())) {
//      throw new RuntimeException("commentId and commentDTO.getId() mismatch");
//    }
//
//    CommentDTO response = commentService.update(commentId, commentDTO);
//    return ResponseEntity.ok(response);
//  }
//
//  @PatchMapping(path = "/applications/{applicationId}/comments/{commentId}", consumes = "application/json", produces = "application/json")
//  public ResponseEntity<Optional<CommentDTO>> patchComment(
//      @PathVariable(name = "applicationId") UUID applicationId,
//      @PathVariable(name = "commentId") UUID commentId,
//      @RequestBody CommentDTO commentDTO) {
//    if (!Objects.equals(applicationId, commentDTO.getApplicationId())) {
//      throw new RuntimeException("applicationId and commentDTO.getApplicationId() mismatch");
//    }
//
//    if (!Objects.equals(commentId, commentDTO.getId())) {
//      throw new RuntimeException("commentId and commentDTO.getId() mismatch");
//    }
//
//    Optional<CommentDTO> response = commentService.patch(commentDTO);
//    return ResponseEntity.ok(response);
//  }
//
//  @GetMapping(path = "/applications/{applicationId}/comments", produces = "application/json")
//  public ResponseEntity<List<CommentDTO>> listAllComments(@PathVariable(name = "applicationId") UUID applicationId) {
//
//    List<CommentDTO> response = commentService.findAllByApplication(applicationId);
//    return ResponseEntity.ok(response);
//  }
//
//  @GetMapping(path = "/applications/{applicationId}/comments/{commentId}", produces = "application/json")
//  public ResponseEntity<Optional<CommentDTO>> listAllComments(
//      @PathVariable(name = "applicationId") UUID applicationId,
//      @PathVariable(name = "commentId") Long commentId) {
//
//    Optional<CommentDTO> response = commentService.findOne(commentId, applicationId);
//    return ResponseEntity.ok(response);
//  }
}
