package com.br.sistemaescolar.DTO;

import com.br.sistemaescolar.Enum.ShiftClass;
import com.br.sistemaescolar.model.StudentEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class ClassDTO extends RepresentationModel<ClassDTO> {
    private Long id;
    private String name;
    private ShiftClass shift;
    private List<StudentDTO> students = new ArrayList<>();
}
