package com.br.sistemaescolar.controller;

import com.br.sistemaescolar.DTO.request.ClassRequestDTO;
import com.br.sistemaescolar.DTO.response.ClassResponseDTO;
import com.br.sistemaescolar.controller.docs.ClassControllerDocs;
import com.br.sistemaescolar.service.ClassService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/class")
@Tag(name = "Class", description = "Endpoint for the class class")
public class ClassController implements ClassControllerDocs {
    @Autowired
    private ClassService service;

    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_YAML_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_YAML_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    @Override
    public ClassResponseDTO create(@RequestBody @Valid ClassRequestDTO class_) {
        return service.createClass(class_);
    }

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_YAML_VALUE, MediaType.APPLICATION_XML_VALUE})
    @Override
    public ClassResponseDTO findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_YAML_VALUE, MediaType.APPLICATION_XML_VALUE})
    @Override
    public List<ClassResponseDTO> findAll() {
        return service.findAll();
    }

    @PutMapping(value = "/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_YAML_VALUE, MediaType.APPLICATION_XML_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_YAML_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    @Override
    public ClassResponseDTO update(@PathVariable("id") Long id, @RequestBody  @Valid ClassRequestDTO class_) {
        return service.updateClass(id, class_);
    }

    @DeleteMapping(value = "/{id}")
    @Override
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
