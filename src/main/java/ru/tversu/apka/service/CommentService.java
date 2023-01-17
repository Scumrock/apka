package ru.tversu.apka.service;

import ru.tversu.apka.domain.Comment;
import ru.tversu.apka.service.dto.CommentCreateDTO;
import ru.tversu.apka.service.dto.CommentDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CommentService {
    CommentDTO saveComment(CommentCreateDTO commentDTO);
    Comment updateComment(CommentDTO commentDTO, UUID id);
    List<CommentDTO> allComments(UUID applicationId);
    Optional<CommentDTO> getComment(UUID id);
    void deleteComment(UUID id);
}
