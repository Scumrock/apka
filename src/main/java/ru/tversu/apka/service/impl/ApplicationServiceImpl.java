package ru.tversu.apka.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.tversu.apka.domain.Application;
import ru.tversu.apka.repository.ApplicationRepository;
import ru.tversu.apka.service.ApplicationService;
import ru.tversu.apka.service.dto.ApplicationDTO;
import ru.tversu.apka.service.mapper.ApplicationMapper;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationRepository applicationRepository;
    private final ApplicationMapper applicationMapper;


    @Override
    public Application saveApplication(ApplicationDTO applicationDTO) {
        return applicationRepository.save(applicationMapper.toEntity(applicationDTO));
    }

    @Override
    public Application updateApplication(ApplicationDTO applicationDTO, UUID id) {
        Application application = applicationMapper.toEntity(applicationDTO);
        if (applicationRepository.existsById(id)) {
            application.setId(id);
            Application app = applicationRepository.findById(id).get();
            application.setCreated(app.getCreated());
        }
        return applicationRepository.save(application);
    }

    @Override
    public List<Application> allApplications() {
        return applicationRepository.findAll();
    }

    @Override
    public Optional<Application> getApplication(UUID id) {
        return applicationRepository.findById(id);
    }

    @Override
    public void deleteApplication(UUID id) {
        try {
            applicationRepository.deleteById(id);
        }catch (Exception ignore){
            log.error("Failed to deleteApplication with id: {}", id);
        }
    }
}
