package com.br.sistemaescolar.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
        import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Data
@AllArgsConstructor
@ToString(exclude = "class_")
@Entity
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 60)
    private String name;

    @Column(nullable = false, length = 60)
    private String email;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private ClassEntity class_;
}
