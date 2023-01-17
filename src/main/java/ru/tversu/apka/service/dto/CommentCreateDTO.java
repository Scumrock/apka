package ru.tversu.apka.service.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;
import java.util.StringJoiner;
import java.util.UUID;

/**
 * A DTO for the {@link Comment} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
@Getter
@Setter
public class CommentCreateDTO {

  private String payload;

  private UUID applicationId;

}
