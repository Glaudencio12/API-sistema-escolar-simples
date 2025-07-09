package com.br.sistemaescolar.controller;

import com.br.sistemaescolar.DTO.StudentDTO;
import com.br.sistemaescolar.service.StudentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@Tag(name = "Student", description = "Endpoints for the student class")
public class StudentController implements com.br.sistemaescolar.controller.docs.StudentControllerDocs {
    @Autowired
    private StudentService service;

    @PostMapping(value = "/class/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_YAML_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_YAML_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    @Override
    public StudentDTO createStudent(@RequestBody StudentDTO student, @PathVariable("id") long id) {
        return service.createAluno(student, id);
    }

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_YAML_VALUE, MediaType.APPLICATION_XML_VALUE})
    @Override
    public StudentDTO findStudentById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_YAML_VALUE, MediaType.APPLICATION_XML_VALUE})
    @Override
    public List<StudentDTO> findAllStudents() {
        return service.findaAll();
    }

    @PutMapping(value = "/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_YAML_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_YAML_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    @Override
    public StudentDTO updateStudent(@PathVariable("id") Long id, @RequestBody StudentDTO student) {
        return service.updateStudent(id, student);
    }

    @PutMapping(value = "/class/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_YAML_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_YAML_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    @Override
    public StudentDTO updateStudentClass(@RequestBody StudentDTO student, @PathVariable("id") Long id) {
        return service.updateStudent(id, student);
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        service.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }
}

