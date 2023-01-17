package ru.tversu.apka.service;

import ru.tversu.apka.domain.Application;
import ru.tversu.apka.service.dto.ApplicationDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ApplicationService {
    Application saveApplication(ApplicationDTO applicationDTO);
    Application updateApplication(ApplicationDTO applicationDTO, UUID id);
    List<Application> allApplications();
    Optional<Application> getApplication(UUID id);
    void deleteApplication(UUID id);





}
