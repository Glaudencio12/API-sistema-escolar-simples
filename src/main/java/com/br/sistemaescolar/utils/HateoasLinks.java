package com.br.sistemaescolar.utils;

import com.br.sistemaescolar.DTO.request.ClassRequestDTO;
import com.br.sistemaescolar.DTO.request.StudentRequestDTO;
import com.br.sistemaescolar.DTO.response.ClassResponseDTO;
import com.br.sistemaescolar.DTO.response.StudentResponseDTO;
import com.br.sistemaescolar.controller.ClassController;
import com.br.sistemaescolar.controller.StudentController;
import org.springframework.stereotype.Service;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class HateoasLinks {
    public void links(Object dto){
        if (dto instanceof ClassResponseDTO dto1) {
            dto1.add(linkTo(methodOn(ClassController.class).create(null)).withRel("createClass").withTitle("Creates a class").withType("POST"));
            dto1.add(linkTo(methodOn(ClassController.class).findById(dto1.getId())).withRel("findClassById").withTitle("Search a class by id").withType("GET"));
            dto1.add(linkTo(methodOn(ClassController.class).findAll()).withRel("findAllClass").withTitle("Search all classes").withType("GET"));
            dto1.add(linkTo(methodOn(ClassController.class).update(dto1.getId(), null)).withRel("updateClassById").withTitle("Updates a class by id").withType("PUT"));
            dto1.add(linkTo(methodOn(ClassController.class).delete(dto1.getId())).withRel("deleteClassById").withTitle("delete a class by id").withType("DELETE"));
        } else if (dto instanceof StudentResponseDTO dto2) {

            dto2.add(linkTo(methodOn(StudentController.class).createStudent(null)).withRel("createStudent").withTitle("Creates a Student").withType("POST"));
            dto2.add(linkTo(methodOn(StudentController.class).findStudentById(dto2.getId())).withRel("findStudentById").withTitle("Search a Student by id").withType("GET"));
            dto2.add(linkTo(methodOn(StudentController.class).findAllStudents()).withRel("findAllStudents").withTitle("Search all Students").withType("GET"));
            dto2.add(linkTo(methodOn(StudentController.class).updateStudent(dto2.getId(), null)).withRel("updateStudentById").withTitle("Updates a Student by id").withType("PUT"));
            dto2.add(linkTo(methodOn(StudentController.class).delete(dto2.getId())).withRel("deleteStudentById").withTitle("delete a Student by id").withType("DELETE"));
        }
    }
}
