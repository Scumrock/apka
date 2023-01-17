package ru.tversu.apka.web.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.tversu.apka.domain.Comment;
import ru.tversu.apka.service.CommentService;
import ru.tversu.apka.service.dto.CommentCreateDTO;
import ru.tversu.apka.service.dto.CommentDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.aspectj.weaver.tools.cache.SimpleCacheFactory.path;

@Slf4j
@RestController
@RequestMapping(value = "/api")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping(path = "/comments/save", consumes = "application/json", produces = "application/json")
    public ResponseEntity<CommentDTO> createComment(@RequestBody CommentCreateDTO commentDTO) {
        CommentDTO comment = commentService.saveComment(commentDTO);
        return ResponseEntity.ok(comment);
    }

    @PutMapping(path = "/comments/update/{id}", produces = "application/json")
    public ResponseEntity<Comment> updateComment(@RequestBody CommentDTO commentDTO, @PathVariable(name = "id") UUID id){
        Comment comment = commentService.updateComment(commentDTO, id);
        return ResponseEntity.ok(comment);
    }

    @GetMapping(path = "/comments/application/{applicationId}", produces = "application/json")
    public ResponseEntity<List<CommentDTO>> listAllComments(@PathVariable(name = "applicationId") UUID id){
        List<CommentDTO> comments = commentService.allComments(id);
        return ResponseEntity.ok(comments);
    }

    @GetMapping(path = "/comments/{id}", produces = "application/json")
    public ResponseEntity<Optional<CommentDTO>> getComment(@PathVariable(name = "id") UUID id){
        Optional<CommentDTO> comment = commentService.getComment(id);
        return ResponseEntity.ok(comment);
    }

    @DeleteMapping(path = "/comments/delete/{id}", produces = "application/json")
    void deleteComment(@PathVariable(name = "id") UUID id){
        commentService.deleteComment(id);
    }

}
