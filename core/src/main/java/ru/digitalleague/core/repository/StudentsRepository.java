package ru.digitalleague.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.digitalleague.core.model.StudentModel;

public interface StudentsRepository extends JpaRepository<StudentModel, Long> {
}
