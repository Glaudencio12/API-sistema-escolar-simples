package com.br.sistemaescolar.DTO.request;

import com.br.sistemaescolar.Enum.ShiftClass;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
public class ClassRequestDTO{
    private Long id;

    @NotBlank(message = "The class name is mandatory")
    @Size(min = 2, message = "The minimum size of the class name is 2 characters")
    private String name;

    @NotNull(message = "The class shift is mandatory")
    private ShiftClass shift;
}
