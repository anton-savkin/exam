package ru.digitalleague.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.digitalleague.core.api.TeachersService;
import ru.digitalleague.core.model.StudentModel;
import ru.digitalleague.core.model.TeacherModel;
import ru.digitalleague.core.repository.StudentsRepository;
import ru.digitalleague.core.repository.TeachersRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TeachersServiceImpl implements TeachersService {

    @Autowired
    TeachersRepository repository;

    @Override
    public ResponseEntity<TeacherModel> insert(TeacherModel teacherModel) {

        try {

            repository.save(teacherModel);

            return new ResponseEntity<>(teacherModel, HttpStatus.CREATED);
        } catch (Exception e) {

            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<TeacherModel> selectById(Long id) {

        Optional<TeacherModel> teacher = repository.findById(id);

        return teacher.map(model -> new ResponseEntity<>(model, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Override
    public ResponseEntity<TeacherModel> updateById(Long id, TeacherModel teacherModel) {

        Optional<TeacherModel> teacher = repository.findById(id);

        if (teacher.isPresent()) {
            TeacherModel updTeacher = teacher.get();
            if (teacherModel.getFirstName() != null) {
                updTeacher.setFirstName(teacherModel.getFirstName());
            }
            if (teacherModel.getLastName() != null) {
                updTeacher.setLastName(teacherModel.getLastName());
            }
            if (teacherModel.getMiddleName() != null) {
                updTeacher.setMiddleName(teacherModel.getMiddleName());
            }
            if (teacherModel.getChairId() != null) {
                updTeacher.setChairId(teacherModel.getChairId());
            }

            return new ResponseEntity<>(repository.save(updTeacher), HttpStatus.OK);
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
    public ResponseEntity<List<TeacherModel>> selectAll() {

        List<TeacherModel> teachers = new ArrayList<>();
        repository.findAll().forEach(teachers::add);

        if (teachers.size()!=0) {
            return new ResponseEntity<>(teachers, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
