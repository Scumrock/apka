package ru.tversu.apka.vm;

import java.net.URI;
import java.util.Optional;
import ru.tversu.apka.model.FileObject;
import ru.tversu.apka.problem.UploadFileProblem;

public class UploadResponseBuilder {
  private FileObject fileItem;
  private URI type;

  UploadResponseBuilder() {
  }

  public UploadResponseBuilder withFileItem(final FileObject fileItem) {
    this.fileItem = fileItem;
    return this;
  }

  public UploadResponseBuilder withType(final URI type) {
    this.type = type;
    return this;
  }

  public UploadResponse build() {
    return Optional.of(fileItem)
        .map(fi -> new UploadResponse(fi.getObjectId(), fi.getOriginalName(), fi.getMimeType()))
        .orElseThrow(() -> new UploadFileProblem(type));
  }
}
