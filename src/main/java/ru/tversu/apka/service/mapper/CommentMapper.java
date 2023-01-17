package ru.tversu.apka.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.tversu.apka.domain.Comment;
import ru.tversu.apka.service.dto.CommentCreateDTO;
import ru.tversu.apka.service.dto.CommentDTO;

/** Mapper for the entity {@link Comment} and its DTO {@link CommentDTO}. */
@Mapper(unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE,
    componentModel = "spring", uses = {CommentMapperUtil.class})
public interface CommentMapper extends EntityMapper<CommentDTO, Comment> {

  /**
   * Comment to DTO mapper.
   *
   * @param s comment object.
   * @return comment DTO.
   */
  @Override
  @Mapping(target = "id", source = "id")
  @Mapping(target = "payload", source = "payload")
  @Mapping(target = "applicationId", source = "s.application.id")
  CommentDTO toDto(Comment s);

  @Override
  @Mapping(target = "id", source = "id")
  @Mapping(target = "payload", source = "payload")
  @Mapping(target = "application", source = "applicationId", qualifiedBy = CommentMapperUtil.ApplicationDTOByComment.class)
  Comment toEntity(CommentDTO s);

  @Mapping(target = "payload", source = "payload")
  @Mapping(target = "application", source = "applicationId", qualifiedBy = CommentMapperUtil.ApplicationDTOByComment.class)
  Comment toEntityCreate(CommentCreateDTO s);
}
