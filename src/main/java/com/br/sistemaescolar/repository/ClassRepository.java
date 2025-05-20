package com.br.sistemaescolar.repository;

import com.br.sistemaescolar.model.ClassEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassRepository extends JpaRepository<ClassEntity, Long> {
}
