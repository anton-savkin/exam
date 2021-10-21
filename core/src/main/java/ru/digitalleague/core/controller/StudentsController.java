package ru.digitalleague.core.controller;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.digitalleague.core.api.StudentsService;
import ru.digitalleague.core.model.StudentModel;

import java.util.List;

@RestController
@Slf4j
public class StudentsController {

    @Autowired
    StudentsService service;

    @PostMapping("/students/insert")
    @ApiOperation(value = "Контроллер для добавления студента")
    public ResponseEntity<StudentModel> insert(@RequestBody StudentModel studentModel) {

        log.info("Received message from postman: POST request to insert student: " + studentModel);

        return service.insert(studentModel);
    }

    @GetMapping("/students/select")
    @ApiOperation(value = "Контроллер для выбора студента по ID")
    public ResponseEntity<StudentModel> selectById(@RequestParam Long id) {

        log.info("Received message from postman: GET request to select student with ID: " + id);

        return service.selectById(id);
    }

    @GetMapping("/students/select-all")
    @ApiOperation(value = "Контроллер для выбора всех студентов")
    public ResponseEntity<List<StudentModel>> selectAll() {

        log.info("Received message from postman: GET request to select all students");

        return service.selectAll();
    }

    @PutMapping("/students/update")
    @ApiOperation(value = "Контроллер для обновления студента по ID")
    public ResponseEntity<StudentModel> updateById(@RequestParam Long id, @RequestBody StudentModel studentModel) {

        log.info("Received message from postman: PUT request to update student with ID: " + id);

        return service.updateById(id, studentModel);
    }

    @DeleteMapping("/students/delete")
    @ApiOperation(value = "Контроллер для удаления студента по ID")
    public ResponseEntity<HttpStatus> deleteById(@RequestParam Long id) {

        log.info("Received message from postman: PUT request to delete student with ID: " + id);

        return service.deleteById(id);
    }


}
