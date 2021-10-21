package ru.digitalleague.core.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.digitalleague.core.model.StudentModel;
import ru.digitalleague.core.model.TeacherModel;

import java.util.List;

public interface TeachersService {
    ResponseEntity<TeacherModel> insert(TeacherModel teacherModel);

    ResponseEntity<TeacherModel> selectById(Long id);

    ResponseEntity<TeacherModel> updateById(Long id, TeacherModel teacherModel);

    ResponseEntity<HttpStatus> deleteById(Long id);

    ResponseEntity<List<TeacherModel>> selectAll();
}
