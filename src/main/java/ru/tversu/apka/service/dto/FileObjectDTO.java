package ru.tversu.apka.service.dto;

import java.util.Objects;
import java.util.StringJoiner;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

/**
 * A DTO for the {@link FileObject} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
@Getter
@Setter
public class FileObjectDTO {
  private UUID uuid;
  private String originalName;
  private String mimeType;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FileObjectDTO that = (FileObjectDTO) o;
    return Objects.equals(uuid, that.uuid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(uuid);
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", FileObjectDTO.class.getSimpleName() + "[", "]")
        .add("uuid=" + uuid)
        .toString();
  }
}
