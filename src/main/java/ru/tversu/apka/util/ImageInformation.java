package ru.tversu.apka.util;

import com.drew.imaging.ImageMetadataReader;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.MetadataException;
import com.drew.metadata.exif.ExifIFD0Directory;
import java.io.InputStream;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Информация об изображении.
 * <p>
 * Для некоторых Exif следует менять местами ширину и высоту.
 */
public final class ImageInformation {

  private static final Logger logger = LoggerFactory.getLogger(ImageInformation.class);

  private final int orientation;

  private ImageInformation(int orientation) {
    this.orientation = orientation;
  }

  /**
   * Получение информации об изображении.
   *
   * @param image поток с изображением
   * @return информация об изображении
   */
  public static Optional<ImageInformation> readExifInformation(InputStream image) {
    Metadata metadata;
    try {
      metadata = ImageMetadataReader.readMetadata(image);
    } catch (Exception e) {
      logger.info("Failed to read image", e);
      return Optional.empty();
    }

    Directory directory = metadata.getFirstDirectoryOfType(ExifIFD0Directory.class);
    if (directory == null) {
      return Optional.empty();
    }

    int orientation;
    try {
      orientation = directory.getInt(ExifIFD0Directory.TAG_ORIENTATION);
    } catch (MetadataException me) {
      logger.info("Could not get orientation for image");
      return Optional.empty();
    }

    return Optional.of(new ImageInformation(orientation));
  }

  /**
   * Определяет нужно ли поменять местами высоту и ширину.
   *
   * @return нужно ли поменять
   */
  public boolean isResolutionFlipped() {
    return orientation >= 5;
  }
}
