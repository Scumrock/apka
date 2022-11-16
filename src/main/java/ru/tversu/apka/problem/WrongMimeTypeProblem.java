package ru.tversu.apka.problem;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

public class WrongMimeTypeProblem extends AbstractThrowableProblem {

  public WrongMimeTypeProblem(final String extension) {
    super(null, "Not allowed mime-type", Status.FORBIDDEN,
        String.format("Mime-type for extension '%s' is not allowed", extension));
  }

}
