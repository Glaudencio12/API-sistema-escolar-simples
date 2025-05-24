package com.br.sistemaescolar.controller;

import com.br.sistemaescolar.DTO.StudentDTO;
import com.br.sistemaescolar.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService service;

    @PostMapping(value = "/class/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_YAML_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_YAML_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public StudentDTO create(@RequestBody StudentDTO student, @PathVariable("id") long id) {
        return service.createAluno(student, id);
    }

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_YAML_VALUE, MediaType.APPLICATION_XML_VALUE})
    public StudentDTO findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_YAML_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<StudentDTO> findAll() {
        return service.findaAll();
    }

    @PutMapping(value = "/update", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_YAML_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_YAML_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public StudentDTO update(@RequestBody StudentDTO student) {
        return service.updateStudent(student);
    }

    @PutMapping(value = "/update/class/{idClass}", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_YAML_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_YAML_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public StudentDTO update(@RequestBody StudentDTO student, @PathVariable("idClass") Long idClass) {
        return service.updateStudent(student, idClass);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        service.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }
}

