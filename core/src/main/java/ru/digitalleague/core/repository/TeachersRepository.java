package ru.digitalleague.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.digitalleague.core.model.TeacherModel;

public interface TeachersRepository extends JpaRepository<TeacherModel, Long> {
}
