package ru.tversu.apka.trait;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.zalando.problem.spring.web.advice.ProblemHandling;

@ControllerAdvice
public class CommonExceptionHandler implements ProblemHandling {
  @Override
  public boolean isCausalChainsEnabled() {
    return false;
  }
}
