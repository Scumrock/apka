package ru.tversu.apka.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import ru.tversu.apka.domain.FileObject;
import ru.tversu.apka.service.dto.FileObjectDTO;

/**
 * Mapper for the entity {@link FileObject} and its DTO {@link FileObjectDTO}.
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface FileObjectMapper {
  @Mapping(target = "uuid", source = "objectId")
  @Mapping(target = "originalName", source = "originalName")
  @Mapping(target = "mimeType", source = "mimeType")
  FileObjectDTO toDto(FileObject s);
}
