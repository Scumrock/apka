package ru.tversu.apka.domain;

import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.StringJoiner;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "application")
@Getter
@Setter
@Accessors(chain = true)
public class Application {
  @Id
  @Column(name = "id", updatable = false, nullable = false)
  private UUID id = UUID.randomUUID();

  @Column(name = "title", columnDefinition = "varchar[1000]")
  private String title;

  @Column(name = "description", columnDefinition = "text")
  private String description;

  @Column(name = "size")
  private long size;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "file_object_id", referencedColumnName = "object_id",
      foreignKey = @ForeignKey(name = "fk_application_file_object_id"))
  private FileObject fileObject;

  @CreationTimestamp
  @Column(name = "created")
  private ZonedDateTime created;

  @UpdateTimestamp
  @Column(name = "updated")
  private ZonedDateTime updated;

  @Column(name = "icon", columnDefinition = "text")
  private String icon;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Application that = (Application) o;
    return Objects.equals(id, that.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", Application.class.getSimpleName() + "[", "]")
        .add("id=" + id)
        .toString();
  }
}
