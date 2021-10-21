package ru.digitalleague.core.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.digitalleague.core.model.StudentModel;

import java.util.List;

public interface StudentsService {
    ResponseEntity<StudentModel> insert(StudentModel studentModel);

    ResponseEntity<StudentModel> selectById(Long id);

    ResponseEntity<StudentModel> updateById(Long id, StudentModel studentModel);

    ResponseEntity<HttpStatus> deleteById(Long id);

    ResponseEntity<List<StudentModel>> selectAll();
}
