package ru.tversu.apka.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.tversu.apka.domain.FileObject;

public interface FileObjectRepository extends JpaRepository<FileObject, UUID> {
}
