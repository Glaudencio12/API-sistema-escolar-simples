package com.br.sistemaescolar.model;

import com.br.sistemaescolar.Enum.ShiftClass;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class ClassEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 30)
    private String name;

    @Column(nullable = false, length = 30)
    @Enumerated(EnumType.STRING)
    private ShiftClass shift;

    @OneToMany(mappedBy = "class_", fetch = FetchType.EAGER)
    private List<StudentEntity> students = new ArrayList<>();
}
