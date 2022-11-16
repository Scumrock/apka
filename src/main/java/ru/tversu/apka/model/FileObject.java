package ru.tversu.apka.model;

import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.StringJoiner;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "objects")
@Getter
@Setter
@Accessors(chain = true)
public class FileObject {
  @Id
  @Column(name = "object_id", updatable = false, nullable = false)
  private UUID objectId = UUID.randomUUID();

  @Column(name = "url", columnDefinition = "TEXT")
  private String url;

  @Column(name = "file_name", columnDefinition = "TEXT")
  private String fileName;

  @Column(name = "file_type")
  private String fileType;

  @Column(name = "mime_type")
  private String mimeType;

  @Column(name = "extension")
  private String extension;

  @Column(name = "original_name", columnDefinition = "TEXT")
  private String originalName;

  @Column(name = "length")
  private long length;

  @CreationTimestamp
  @Column(name = "created")
  private ZonedDateTime created;

  @UpdateTimestamp
  @Column(name = "updated")
  private ZonedDateTime updated;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof FileObject)) {
      return false;
    }
    FileObject token = (FileObject) o;
    return Objects.equals(getObjectId(), token.getObjectId());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getObjectId());
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", FileObject.class.getSimpleName() + "[", "]")
        .add("objectId=" + objectId)
        .toString();
  }
}

