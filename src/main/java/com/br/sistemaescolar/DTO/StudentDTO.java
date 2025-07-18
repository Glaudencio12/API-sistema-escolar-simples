package com.br.sistemaescolar.DTO;

import com.br.sistemaescolar.model.ClassEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.JoinColumn;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

@NoArgsConstructor
@Getter
@Setter
public class StudentDTO extends RepresentationModel<StudentDTO> {
    private Long id;
    private String name;
    private String email;
    @JsonIgnore
    private ClassDTO classDTO;
}
