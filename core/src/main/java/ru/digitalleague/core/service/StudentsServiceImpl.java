package ru.digitalleague.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.digitalleague.core.api.StudentsService;
import ru.digitalleague.core.model.StudentModel;
import ru.digitalleague.core.repository.StudentsRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentsServiceImpl implements StudentsService {

    @Autowired
    StudentsRepository repository;

    @Override
    public ResponseEntity<StudentModel> insert(StudentModel studentModel) {

        try {

            repository.save(studentModel);

            return new ResponseEntity<>(studentModel, HttpStatus.CREATED);
        } catch (Exception e) {

            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<StudentModel> selectById(Long id) {

        Optional<StudentModel> student = repository.findById(id);

        return student.map(model -> new ResponseEntity<>(model, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    @Override
    public ResponseEntity<StudentModel> updateById(Long id, StudentModel studentModel) {

        Optional<StudentModel> student = repository.findById(id);

        if (student.isPresent()) {
            StudentModel updStudent = student.get();
            if (studentModel.getFirstName() != null) {
                updStudent.setFirstName(studentModel.getFirstName());
            }
            if (studentModel.getLastName() != null) {
                updStudent.setLastName(studentModel.getLastName());
            }
            if (studentModel.getMiddleName() != null) {
                updStudent.setMiddleName(studentModel.getMiddleName());
            }
            if (studentModel.getSpecialityId() != null) {
                updStudent.setSpecialityId(studentModel.getSpecialityId());
            }
            if (studentModel.getCourse() != 0) {
                updStudent.setCourse(studentModel.getCourse());
            }

            return new ResponseEntity<>(repository.save(updStudent), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<HttpStatus> deleteById(Long id) {

        try {
            repository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<List<StudentModel>> selectAll() {

        List<StudentModel> students = new ArrayList<>();
        repository.findAll().forEach(students::add);

        if (students.size()!=0) {
            return new ResponseEntity<>(students, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
