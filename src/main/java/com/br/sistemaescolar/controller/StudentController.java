package com.br.sistemaescolar.controller;

import com.br.sistemaescolar.DTO.request.StudentRequestDTO;
import com.br.sistemaescolar.DTO.response.StudentResponseDTO;
import com.br.sistemaescolar.controller.docs.StudentControllerDocs;
import com.br.sistemaescolar.service.StudentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@Tag(name = "Student", description = "Endpoints for the student class")
public class StudentController implements StudentControllerDocs {
    @Autowired
    private StudentService service;

    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_YAML_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_YAML_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    @Override
    public StudentResponseDTO createStudent(@RequestBody @Valid StudentRequestDTO student) {
        return service.createStudent(student);
    }

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_YAML_VALUE, MediaType.APPLICATION_XML_VALUE})
    @Override
    public StudentResponseDTO findStudentById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_YAML_VALUE, MediaType.APPLICATION_XML_VALUE})
    @Override
    public List<StudentResponseDTO> findAllStudents() {
        return service.findaAll();
    }

    @PutMapping(value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_YAML_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_YAML_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    @Override
    public StudentResponseDTO updateStudent(@PathVariable("id") Long id, @RequestBody @Valid StudentRequestDTO student) {
        return service.updateStudent(id, student);
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        service.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }
}

