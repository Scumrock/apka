package ru.tversu.apka.problem;

import java.net.URI;
import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

/**
 * UploadFileProblem rises when we can't upload file
 */
public class UploadFileProblem extends AbstractThrowableProblem {
  public UploadFileProblem(final URI type) {
    super(type, "Can't upload file", Status.BAD_REQUEST, "Can't upload file");
  }
}
