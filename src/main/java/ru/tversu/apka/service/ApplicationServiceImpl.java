package ru.tversu.apka.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.tversu.apka.domain.Application;
import ru.tversu.apka.repository.ApplicationRepository;
import ru.tversu.apka.service.dto.ApplicationDTO;
import ru.tversu.apka.service.mapper.ApplicationMapper;

//@Service
//@Transactional
//public class ApplicationServiceImpl implements ApplicationService {
//
//  private final ApplicationRepository applicationRepository;
//  private final ApplicationMapper applicationMapper;
//
//  @Autowired
//  public ApplicationServiceImpl(ApplicationRepository applicationRepository,
//                                ApplicationMapper applicationMapper) {
//    this.applicationRepository = applicationRepository;
//    this.applicationMapper = applicationMapper;
//  }
//
//  @Override
//  public ApplicationDTO create(ApplicationDTO applicationDTO) {
//    final Application application = applicationRepository.save(applicationMapper.toEntity(applicationDTO));
//    return applicationMapper.toDto(application);
//  }
//
//  @Override
//  public ApplicationDTO update(ApplicationDTO applicationDTO) {
//    if (!applicationRepository.existsById(applicationDTO.getId())) {
//      throw new EntityNotFoundException("Application with ID " + applicationDTO.getId() + " not found");
//    }
//    final Application application = applicationRepository.save(applicationMapper.toEntity(applicationDTO));
//    return applicationMapper.toDto(application);
//  }
//
//  @Override
//  public Optional<ApplicationDTO> patch(ApplicationDTO applicationDTO) {
//    return applicationRepository
//        .findById(applicationDTO.getId())
//        .map(existingApplication -> {
//          applicationMapper.partialUpdate(existingApplication, applicationDTO);
//
//          return existingApplication;
//        })
//        .map(applicationRepository::save)
//        .map(applicationMapper::toDto);
//  }
//
//  @Override
//  public void delete(UUID id) {
//    applicationRepository.deleteById(id);
//  }
//
//  @Override
//  public Optional<ApplicationDTO> findOne(UUID id) {
//    return applicationRepository.findById(id)
//        .map(applicationMapper::toDto);
//  }
//
//  @Override
//  public List<ApplicationDTO> listAll() {
//    return applicationRepository.findAll()
//        .stream().map(applicationMapper::toDto)
//        .toList();
//  }
//}
