package ru.tversu.apka.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.tversu.apka.model.FileObject;

public interface FileObjectRepository extends JpaRepository<FileObject, UUID> {
}
