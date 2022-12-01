package ru.tversu.apka.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import ru.tversu.apka.service.dto.ApplicationDTO;

public interface ApplicationService {
  ApplicationDTO create(ApplicationDTO applicationDTO);

  ApplicationDTO update(ApplicationDTO applicationDTO);

  Optional<ApplicationDTO> patch(ApplicationDTO applicationDTO);

  void delete(UUID id);

  Optional<ApplicationDTO> findOne(UUID id);

  List<ApplicationDTO> listAll();
}
