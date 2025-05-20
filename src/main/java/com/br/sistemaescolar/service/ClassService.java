package com.br.sistemaescolar.service;

import com.br.sistemaescolar.DTO.ClassDTO;
import com.br.sistemaescolar.exception.ResourceNotFoundEception;
import com.br.sistemaescolar.mapper.ObjectMapper;
import com.br.sistemaescolar.model.ClassEntity;
import com.br.sistemaescolar.repository.ClassRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ClassService {
    @Autowired
    private ClassRepository repository;

    private static final Logger logger = LoggerFactory.getLogger(ClassService.class);

    public ClassDTO createClass(ClassDTO class_){
        logger.info("Creating one class!");
        ClassEntity entity = ObjectMapper.parseObject(class_, ClassEntity.class);
        return ObjectMapper.parseObject(repository.save(entity), ClassDTO.class);
    }

    public ClassDTO findById(Long id){
        logger.info("Finding a class");
        ClassEntity entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundEception("There is no such id in the database!"));
        return ObjectMapper.parseObject(entity, ClassDTO.class);
    }

    public List<ClassDTO> findAll(){
        logger.info("Finding all class");
        return ObjectMapper.parseListObjects(repository.findAll(), ClassDTO.class);
    }

    public ClassDTO updateClass(ClassDTO class_){
        logger.info("Updating a class!");
        ClassEntity entity = repository.findById(class_.getId()).orElseThrow(()-> new ResourceNotFoundEception("There is  no such id in the database!"));
        entity.setName(class_.getName());
        entity.setShift(class_.getShift());
        return ObjectMapper.parseObject(repository.save(entity), ClassDTO.class);
    }

    public void delete(Long idClass){
        ClassEntity entity = repository.findById(idClass).orElseThrow(()-> new ResourceNotFoundEception("There is  no such id in the database!"));
        repository.delete(entity);
    }
}
