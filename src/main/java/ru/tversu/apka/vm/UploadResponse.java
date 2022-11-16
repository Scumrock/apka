package ru.tversu.apka.vm;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.UUID;

/**
 * {
 * "uuid": "94550262-7f9c-434f-ad60-f7646c067c94",
 * "originalName": "фото.jpg",
 * "mimeType": "image/jpg"
 * }
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UploadResponse {
  private UUID uuid;
  private String originalName;
  private String mimeType;


  public UploadResponse(UUID uuid, String originalName, String mimeType) {
    this.uuid = uuid;
    this.originalName = originalName;
    this.mimeType = mimeType;
  }

  public static UploadResponseBuilder builder() {
    return new UploadResponseBuilder();
  }

  public UUID getUuid() {
    return uuid;
  }

  public String getOriginalName() {
    return originalName;
  }

  public String getMimeType() {
    return mimeType;
  }
}
