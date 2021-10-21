package ru.digitalleague.core.controller;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.digitalleague.core.api.TeachersService;
import ru.digitalleague.core.model.StudentModel;
import ru.digitalleague.core.model.TeacherModel;

import java.util.List;

@RestController
@Slf4j
public class TeachersController {

    @Autowired
    TeachersService service;

    @PostMapping("/teachers/insert")
    @ApiOperation(value = "Контроллер для добавления преподавателя")
    public ResponseEntity<TeacherModel> insert(@RequestBody TeacherModel teacherModel) {

        log.info("Received message from postman: POST request to insert teacher: " + teacherModel);

        return service.insert(teacherModel);
    }

    @GetMapping("/teachers/select")
    @ApiOperation(value = "Контроллер для выбора преподавателя по ID")
    public ResponseEntity<TeacherModel> selectById(@RequestParam Long id) {

        log.info("Received message from postman: GET request to select teacher with ID: " + id);

        return service.selectById(id);
    }

    @GetMapping("/teachers/select-all")
    @ApiOperation(value = "Контроллер для выбора всех преподавателей")
    public ResponseEntity<List<TeacherModel>> selectAll() {

        log.info("Received message from postman: GET request to select all teachers");

        return service.selectAll();
    }

    @PutMapping("/teachers/update")
    @ApiOperation(value = "Контроллер для обновления преподавателя по ID")
    public ResponseEntity<TeacherModel> updateById(@RequestParam Long id, @RequestBody TeacherModel teacherModel) {

        log.info("Received message from postman: PUT request to update teacher with ID: " + id);

        return service.updateById(id, teacherModel);
    }

    @DeleteMapping("/teachers/delete")
    @ApiOperation(value = "Контроллер для удаления преподавателя по ID")
    public ResponseEntity<HttpStatus> deleteById(@RequestParam Long id) {

        log.info("Received message from postman: PUT request to delete teacher with ID: " + id);

        return service.deleteById(id);
    }
}
