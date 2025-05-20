package com.br.sistemaescolar.Enum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ShiftClass {
    MANHA("Manhã"),
    TARDE("Tarde"),
    NOITE("Noite");

    private String turno;
}
