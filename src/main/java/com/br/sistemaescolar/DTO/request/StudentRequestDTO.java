package com.br.sistemaescolar.DTO.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class StudentRequestDTO{
    private Long id;

    @NotBlank(message = "The name cannot be blank")
    @Size(min = 3, message = "The name must have at least 3 characters")
    private String name;

    @NotBlank(message = "The email is mandatory")
    @Email(message = "The email must be valid")
    private String email;

    @NotNull(message = "The class id is mandatory")
    private Long classId;
}
