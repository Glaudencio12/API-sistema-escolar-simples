package com.br.sistemaescolar.controller;

import com.br.sistemaescolar.DTO.ClassDTO;
import com.br.sistemaescolar.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/class")
public class ClassController {
    @Autowired
    private ClassService service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ClassDTO create(@RequestBody ClassDTO class_){
        return service.createClass(class_);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ClassDTO findById(@PathVariable("id") Long id){
        return service.findById(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ClassDTO> findAll(){
        return service.findAll();
    }

    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ClassDTO update(@RequestBody ClassDTO class_){
        return service.updateClass(class_);
    }

    @DeleteMapping(value = "/delete/{idClass}")
    public ResponseEntity<?> delete(@PathVariable("idClass") Long idClass){
        service.delete(idClass);
        return ResponseEntity.noContent().build();
    }
}
