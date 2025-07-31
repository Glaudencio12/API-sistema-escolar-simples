package com.br.sistemaescolar.DTO.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

@NoArgsConstructor
@Getter
@Setter
public class StudentResponseDTO extends RepresentationModel<StudentResponseDTO> {
    private Long id;
    private String name;
    private String email;
    @JsonProperty("class")
    private String nameClass;
}
