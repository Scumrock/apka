package ru.tversu.apka.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.tversu.apka.domain.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

  Optional<Comment> findByIdAndApplicationId(Long id, UUID applicationId);

  @Query(value = "from Comment where application.id = :applicationId")
  List<Comment> findAllByApplicationId(@Param(value = "applicationId") UUID applicationId);
}
