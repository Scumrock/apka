package ru.tversu.apka.service.mapper;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.UUID;
import org.mapstruct.Qualifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.tversu.apka.domain.Application;
import ru.tversu.apka.repository.ApplicationRepository;

/**
 * Utility class for comment mapper.
 */
@Component
public class CommentMapperUtil {

  private final ApplicationRepository applicationRepository;

  /**
   * CommentMapperUtil constructor.
   *
   */
  @Autowired
  public CommentMapperUtil(ApplicationRepository applicationRepository) {
    this.applicationRepository = applicationRepository;
  }

  /**
   * Transform application id to Application.
   *
   * @param applicationId application id.
   * @return Application.
   */
  @ApplicationDTOByComment
  public Application findAttachmentsByComment(UUID applicationId) {
    return applicationRepository.getReferenceById(applicationId);
  }

  /**
   * Qualifier interface for transformation.
   */
  @Qualifier
  @Target(ElementType.METHOD)
  @Retention(RetentionPolicy.SOURCE)
  public @interface ApplicationDTOByComment {

  }
}
