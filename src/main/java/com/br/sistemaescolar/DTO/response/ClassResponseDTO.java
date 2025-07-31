package com.br.sistemaescolar.DTO.response;

import com.br.sistemaescolar.Enum.ShiftClass;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class ClassResponseDTO extends RepresentationModel<ClassResponseDTO> {
    private Long id;
    private String name;
    private ShiftClass shift;
    private List<StudentResponseDTO> students = new ArrayList<>();
}
