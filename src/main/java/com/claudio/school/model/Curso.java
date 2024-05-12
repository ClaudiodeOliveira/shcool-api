package com.claudio.school.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "curso")
@Table(name = "curso")
@EqualsAndHashCode(callSuper = false)
public class Curso extends Audit {

    @Id
    @Column(name = "cd_curso")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nm_curso", nullable = false, unique = true)
    private String nome;

    @Column(name = "ds_curso", nullable = false)
    private String descricao;

    @Column(name = "tm_duracao")
    private int duracao;

    @JsonBackReference
    @ManyToMany(mappedBy = "cursos")
    private List<Matricula> matriculas;
}
