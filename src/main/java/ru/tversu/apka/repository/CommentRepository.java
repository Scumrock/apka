package ru.tversu.apka.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.tversu.apka.model.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, UUID> {
}
