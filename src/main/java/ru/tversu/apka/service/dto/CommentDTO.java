package ru.tversu.apka.service.dto;

import java.util.Objects;
import java.util.StringJoiner;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

/**
 * A DTO for the {@link Comment} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
@Getter
@Setter
public class CommentDTO {

  private UUID id;

  private String payload;

  private UUID applicationId;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof CommentDTO)) {
      return false;
    }

    CommentDTO commentDTO = (CommentDTO) o;
    if (this.id == null) {
      return false;
    }
    return Objects.equals(this.id, commentDTO.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.id);
  }


  @Override
  public String toString() {
    return new StringJoiner(", ", CommentDTO.class.getSimpleName() + "[", "]")
        .add("id=" + id)
        .toString();
  }
}
