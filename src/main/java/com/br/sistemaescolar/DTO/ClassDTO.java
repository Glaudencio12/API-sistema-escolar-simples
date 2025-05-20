package com.br.sistemaescolar.DTO;

import com.br.sistemaescolar.Enum.ShiftClass;
import com.br.sistemaescolar.model.StudentEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Data
public class ClassDTO {
    private Long id;
    private String name;
    private ShiftClass shift;
    private List<StudentDTO> students = new ArrayList<>();
}
