package com.br.sistemaescolar.service;

import com.br.sistemaescolar.DTO.StudentDTO;
import com.br.sistemaescolar.exception.ResourceNotFoundEception;
import com.br.sistemaescolar.mapper.ObjectMapper;
import com.br.sistemaescolar.model.ClassEntity;
import com.br.sistemaescolar.model.StudentEntity;
import com.br.sistemaescolar.repository.ClassRepository;
import com.br.sistemaescolar.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private static final Logger logger = LoggerFactory.getLogger(StudentService.class);
    @Autowired
    private StudentRepository repository;
    @Autowired
    private ClassRepository repositoryClass;

    public StudentDTO createAluno(StudentDTO student, Long id){
        logger.info("Creating a student");
        ClassEntity classEntity = repositoryClass.findById(id).orElseThrow(()-> new ResourceNotFoundEception("There is no such id in the database"));
        StudentEntity studentEntity = ObjectMapper.parseObject(student, StudentEntity.class);
        studentEntity.setClass_(classEntity);
        return ObjectMapper.parseObject(repository.save(studentEntity), StudentDTO.class);
    }

    public StudentDTO findById(Long id){
        logger.info("Finding a student!");
        StudentEntity entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundEception("There is no such id in the database!"));
        return ObjectMapper.parseObject(entity, StudentDTO.class);
    }

    public List<StudentDTO> findaAll(){
        logger.info("Finding all students!");
        return ObjectMapper.parseListObjects(repository.findAll(), StudentDTO.class);
    }

    public StudentDTO updateStudent(StudentDTO student){
        logger.info("Updating a student!");
        StudentEntity entity = repository.findById(student.getId()).orElseThrow(()-> new ResourceNotFoundEception("There is no such id in database"));
        entity.setName(student.getName());
        entity.setEmail(student.getEmail());
        return ObjectMapper.parseObject(repository.save(entity), StudentDTO.class);
    }

    public StudentDTO updateStudent(StudentDTO student, Long idClass){
        logger.info("transferring a class student!");
        StudentEntity studentEntity = repository.findById(student.getId()).orElseThrow(()-> new ResourceNotFoundEception("There is no such id in database"));
        ClassEntity classEntity = repositoryClass.findById(idClass).orElseThrow(()-> new ResourceNotFoundEception("There is no such id in database"));
        studentEntity.setClass_(classEntity);
        return ObjectMapper.parseObject(repository.save(studentEntity), StudentDTO.class);
    }

    public void deleteStudent(Long id){
        logger.info("Delete a Student!");
        StudentEntity studentEntity = repository.findById(id).orElseThrow(()-> new ResourceNotFoundEception("There is no such id in database"));
        repository.delete(studentEntity);
    }
}
