package ru.tversu.apka.service.mapper;

/**
 * Mapper for the entity {@link ru.tversu.apka.domain.Application} and its DTO {@link ru.tversu.apka.service.dto.ApplicationDTO}.
 */

import static org.mapstruct.NullValueCheckStrategy.ALWAYS;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.tversu.apka.domain.Application;
import ru.tversu.apka.service.dto.ApplicationDTO;

@Mapper(unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE,
    componentModel = "spring")
public interface ApplicationMapper extends EntityMapper<ApplicationDTO, Application> {
  @Override
  @Mapping(source = "id", target = "id", nullValueCheckStrategy = ALWAYS)
  Application toEntity(ApplicationDTO dto);
}
