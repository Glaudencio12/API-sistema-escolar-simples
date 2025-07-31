package com.br.sistemaescolar.service;

import com.br.sistemaescolar.DTO.request.ClassRequestDTO;
import com.br.sistemaescolar.DTO.response.ClassResponseDTO;
import com.br.sistemaescolar.exception.ClassWithStudentsException;
import com.br.sistemaescolar.exception.ResourceNotFoundEception;
import com.br.sistemaescolar.mapper.ObjectMapper;
import com.br.sistemaescolar.model.ClassEntity;
import com.br.sistemaescolar.repository.ClassRepository;
import com.br.sistemaescolar.utils.HateoasLinks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ClassService {
    private static final Logger logger = LoggerFactory.getLogger(ClassService.class);

    private final ClassRepository repository;
    private final HateoasLinks hateoasLinks;

    public ClassService(ClassRepository repository, HateoasLinks hateoasLinks) {
        this.repository = repository;
        this.hateoasLinks = hateoasLinks;
    }

    public ClassResponseDTO createClass(ClassRequestDTO class_){
        logger.info("Creating one class!");
        ClassEntity entity = ObjectMapper.parseObject(class_, ClassEntity.class);
        var dto = ObjectMapper.parseObject(repository.save(entity), ClassResponseDTO.class);
        hateoasLinks.links(dto);
        return dto;
    }

    public ClassResponseDTO findById(Long id){
        logger.info("Finding a class");
        ClassEntity entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundEception("There is no such id in the database!"));
        var dto = ObjectMapper.parseObject(entity, ClassResponseDTO.class);
        dto.getStudents().forEach(hateoasLinks::links);
        hateoasLinks.links(dto);
        return dto;
    }

    public List<ClassResponseDTO> findAll(){
        logger.info("Finding all class");
        var dtos = ObjectMapper.parseListObjects(repository.findAll(), ClassResponseDTO.class);
        dtos.forEach(classDTO -> {
            classDTO.getStudents().forEach(hateoasLinks::links);
            hateoasLinks.links(classDTO);
        });
        return dtos;
    }

    public ClassResponseDTO updateClass(Long id, ClassRequestDTO class_){
        logger.info("Updating a class!");
        ClassEntity entity = repository.findById(id).orElseThrow(()-> new ResourceNotFoundEception("There is  no such id in the database!"));
        entity.setName(class_.getName());
        entity.setShift(class_.getShift());
        var dto = ObjectMapper.parseObject(repository.save(entity), ClassResponseDTO.class);
        hateoasLinks.links(dto);
        return dto;
    }

    public void delete(Long idClass){
        ClassEntity entity = repository.findById(idClass).orElseThrow(()-> new ResourceNotFoundEception("There is  no such id in the database!"));
        if (!entity.getStudents().isEmpty()) {
            throw new ClassWithStudentsException("The class cannot be excluded as it has enrolled students");
        }
        repository.delete(entity);
    }
}
