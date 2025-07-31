package com.br.sistemaescolar.service;

import com.br.sistemaescolar.DTO.request.StudentRequestDTO;
import com.br.sistemaescolar.DTO.response.StudentResponseDTO;
import com.br.sistemaescolar.exception.ResourceNotFoundEception;
import com.br.sistemaescolar.mapper.ObjectMapper;
import com.br.sistemaescolar.model.ClassEntity;
import com.br.sistemaescolar.model.StudentEntity;
import com.br.sistemaescolar.repository.ClassRepository;
import com.br.sistemaescolar.repository.StudentRepository;
import com.br.sistemaescolar.utils.HateoasLinks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private static final Logger logger = LoggerFactory.getLogger(StudentService.class);

    private final StudentRepository repository;
    private final ClassRepository repositoryClass;
    private final HateoasLinks hateoasLinks;

    public StudentService(StudentRepository repository, ClassRepository repositoryClass, HateoasLinks hateoasLinks) {
        this.repository = repository;
        this.repositoryClass = repositoryClass;
        this.hateoasLinks = hateoasLinks;
    }

    public StudentResponseDTO createStudent(StudentRequestDTO student){
        logger.info("Creating a student");
        ClassEntity classEntity = repositoryClass.findById(student.getClassId()).orElseThrow(()-> new ResourceNotFoundEception("There is no such id in the database"));
        StudentEntity studentEntity = ObjectMapper.parseObject(student, StudentEntity.class);
        studentEntity.setClass_(classEntity);
        StudentEntity saved = repository.save(studentEntity);
        StudentResponseDTO dto = ObjectMapper.parseObject(saved, StudentResponseDTO.class);
        dto.setNameClass(saved.getClass_().getName());
        hateoasLinks.links(dto);
        return dto;
    }

    public StudentResponseDTO findById(Long id){
        logger.info("Finding a student!");
        StudentEntity entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundEception("There is no such id in the database!"));
        var dto = ObjectMapper.parseObject(entity, StudentResponseDTO.class);
        hateoasLinks.links(dto);
        return dto;
    }

    public List<StudentResponseDTO> findaAll(){
        logger.info("Finding all students!");
        var dtos = ObjectMapper.parseListObjects(repository.findAll(), StudentResponseDTO.class);
        dtos.forEach(hateoasLinks::links);
        return dtos;
    }

    public StudentResponseDTO updateStudent(Long id, StudentRequestDTO student){
        logger.info("Updating a student!");
        StudentEntity entityStudent = repository.findById(id).orElseThrow(()-> new ResourceNotFoundEception("There is no such id in database"));
        ClassEntity entityClass = repositoryClass.findById(student.getClassId()).orElseThrow(() -> new ResourceNotFoundEception("There is no such in database"));
        entityStudent.setName(student.getName());
        entityStudent.setEmail(student.getEmail());
        entityStudent.setClass_(entityClass);
        var dto = ObjectMapper.parseObject(repository.save(entityStudent), StudentResponseDTO.class);
        hateoasLinks.links(dto);
        return dto;
    }

    public void deleteStudent(Long id){
        logger.info("Delete a Student!");
        StudentEntity studentEntity = repository.findById(id).orElseThrow(()-> new ResourceNotFoundEception("There is no such id in database"));
        repository.delete(studentEntity);
    }
}
