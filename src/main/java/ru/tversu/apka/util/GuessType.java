package ru.tversu.apka.util;

import java.io.BufferedInputStream;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.apache.tika.Tika;
import org.apache.tika.mime.MimeType;
import org.apache.tika.mime.MimeTypeException;
import org.apache.tika.mime.MimeTypes;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class GuessType {
  /**
   * Пробуем угадать mimeType у BufferedInputStream.
   * При неудаче вернём "application/octet-stream"
   *
   * @param bufferedInputStream BufferedInputStream
   * @return mimeType
   */
  public String guessMimeType(BufferedInputStream bufferedInputStream) {
    String mimeType = "application/octet-stream";
    try {
      bufferedInputStream.mark(0);
      Tika detector = new Tika();
      mimeType = detector.detect(bufferedInputStream);

      bufferedInputStream.reset();
    } catch (IOException e) {
      log.warn("Can't determine MimeType for stream: {}", bufferedInputStream);
    }
    return mimeType;
  }

  /**
   * Пробуем угадать расширение файла.
   * При неудаче вернём ""
   *
   * @param mimeType mimeType
   * @return расширение файла("jpg", "png")
   */
  public String guessExtension(String mimeType) {
    String extension = "";
    try {
      MimeTypes allTypes = MimeTypes.getDefaultMimeTypes();
      MimeType mimeTypeTemp = allTypes.forName(mimeType);
      extension = mimeTypeTemp.getExtension();
    } catch (MimeTypeException e) {
      log.warn("Can't determine extension for mimeType: {}", mimeType);
    }
    return extension.replace(".", "");
  }


}
