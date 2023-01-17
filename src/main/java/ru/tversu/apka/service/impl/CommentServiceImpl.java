package ru.tversu.apka.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.tversu.apka.domain.Comment;
import ru.tversu.apka.repository.CommentRepository;
import ru.tversu.apka.service.CommentService;
import ru.tversu.apka.service.dto.CommentCreateDTO;
import ru.tversu.apka.service.dto.CommentDTO;
import ru.tversu.apka.service.mapper.CommentMapper;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;

    @Override
    public CommentDTO saveComment(CommentCreateDTO commentDTO) {
        Comment result = commentRepository.save(commentMapper.toEntityCreate(commentDTO));
        return commentMapper.toDto(result);
    }

    @Override
    public Comment updateComment(CommentDTO commentDTO, UUID id) {
        Comment comment = commentMapper.toEntity(commentDTO);
        comment.setId(id);
        return commentRepository.save(comment);
    }

    @Override
    public List<CommentDTO> allComments(UUID applicationId) {
        return commentRepository.findAllByApplicationId(applicationId).stream().map(commentMapper::toDto).toList();
    }

    @Override
    public Optional<CommentDTO> getComment(UUID id) {
        return commentRepository.findById(id).map(commentMapper::toDto);
    }

    @Override
    public void deleteComment(UUID id) {
        commentRepository.deleteById(id);
    }
}
