package ru.tversu.apka.service.dto;

import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApplicationDTO {

  private UUID id;

  private String title;

  private String description;
}
