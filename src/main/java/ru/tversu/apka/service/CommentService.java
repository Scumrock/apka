package ru.tversu.apka.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import ru.tversu.apka.service.dto.CommentDTO;

public interface CommentService {
  CommentDTO create(CommentDTO commentDTO);

  CommentDTO update(Long commentId, CommentDTO commentDTO);

  Optional<CommentDTO> patch(CommentDTO commentDTO);

  Optional<CommentDTO> findOne(Long commentId, UUID applicationId);

  List<CommentDTO> findAllByApplication(UUID applicationId);
}
