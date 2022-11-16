package ru.tversu.apka.problem;

import java.net.URI;
import java.util.UUID;
import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

/**
 * File not found problem rises when we can't find file record by uuid
 */
public class FileNotFoundProblem extends AbstractThrowableProblem {

  public FileNotFoundProblem(final UUID uuid, final URI type) {
    super(type, "Not found", Status.NOT_FOUND,
        String.format("File '%s' not found", uuid.toString()));
  }

  public FileNotFoundProblem(final String fileName, final URI type) {
    super(type, "Not found", Status.NOT_FOUND, String.format("File '%s' not found", fileName));
  }
}
