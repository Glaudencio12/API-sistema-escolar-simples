package com.br.sistemaescolar.repository;

import com.br.sistemaescolar.model.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
}
