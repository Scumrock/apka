package ru.tversu.apka.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.tversu.apka.model.Application;
import ru.tversu.apka.repository.ApplicationRepository;

@Slf4j
@RestController
@RequestMapping(value = "/api")
public class ApplicationController {

  private final ApplicationRepository applicationRepository;

  @Autowired
  public ApplicationController(ApplicationRepository applicationRepository) {
    this.applicationRepository = applicationRepository;
  }

  @GetMapping(path = "/applications",
      produces = "application/json")
  public ResponseEntity<List<Application>> listAllApplications() {
    List<Application> applications = applicationRepository.findAll();
    return ResponseEntity.ok(applications);
  }

  @GetMapping(path = "/applications/{id}",
      produces = "application/json")
  public ResponseEntity<Optional<Application>> getApplications(@PathVariable(name = "id") UUID id) {
    Optional<Application> application = applicationRepository.findById(id);
    return ResponseEntity.ok(application);
  }
}
