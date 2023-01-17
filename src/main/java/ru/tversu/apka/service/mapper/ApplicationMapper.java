package ru.tversu.apka.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import ru.tversu.apka.domain.Application;
import ru.tversu.apka.service.dto.ApplicationDTO;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApplicationMapper extends EntityMapper<ApplicationDTO, Application>{

    @Mapping(target = "title", source = "title")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "icon", source = "icon")
    ApplicationDTO toDto(Application app);

    @Mapping(target = "title", source = "title")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "icon", source = "icon")
    Application toEntity(ApplicationDTO app);
}
