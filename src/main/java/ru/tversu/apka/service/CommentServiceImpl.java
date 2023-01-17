package ru.tversu.apka.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.tversu.apka.domain.Comment;
import ru.tversu.apka.repository.ApplicationRepository;
import ru.tversu.apka.repository.CommentRepository;
import ru.tversu.apka.service.dto.CommentDTO;
import ru.tversu.apka.service.mapper.CommentMapper;

//@Service
//@Transactional
//public class CommentServiceImpl implements CommentService {
//
//  private final ApplicationRepository applicationRepository;
//  private final CommentRepository commentRepository;
//  private final CommentMapper commentMapper;
//
//  @Autowired
//  public CommentServiceImpl(ApplicationRepository applicationRepository, CommentRepository commentRepository, CommentMapper commentMapper) {
//    this.applicationRepository = applicationRepository;
//    this.commentRepository = commentRepository;
//    this.commentMapper = commentMapper;
//  }
//
//  @Override
//  public CommentDTO create(CommentDTO commentDTO) {
//    final Comment comment = commentMapper.toEntity(commentDTO);
//    return commentMapper.toDto(commentRepository.save(comment));
//  }
//
//  @Override
//  public CommentDTO update(Long commentId, CommentDTO commentDTO) {
//    Comment comment = commentRepository.save(commentMapper.toEntity(commentDTO));
//    return commentMapper.toDto(comment);
//  }
//
//  @Override
//  public Optional<CommentDTO> patch(CommentDTO commentDTO) {
//
//    return commentRepository
//        .findById(commentDTO.getId())
//        .map(existingComment -> {
//          commentMapper.partialUpdate(existingComment, commentDTO);
//
//          return existingComment;
//        })
//        .map(commentRepository::save)
//        .map(commentMapper::toDto);
//  }
//
//  @Override
//  public Optional<CommentDTO> findOne(Long commentId, UUID applicationId) {
//
//    return commentRepository.findByIdAndApplicationId(commentId, applicationId)
//        .map(commentMapper::toDto);
//  }
//
//  @Override
//  public List<CommentDTO> findAllByApplication(UUID applicationId) {
//    return commentRepository
//        .findAllByApplicationId(applicationId)
//        .stream()
//        .map(commentMapper::toDto)
//        .toList();
//  }
//}
