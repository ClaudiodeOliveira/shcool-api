package com.claudio.school.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "matricula")
@Table(name = "matricula")
@EqualsAndHashCode(callSuper = false)
public class Matricula extends Audit  {

    @Id
    @Column(name = "cd_matricula")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    @Column(name = "dt_matricula", nullable = false)
    private LocalDate dataMatricula;

    @Column(name = "nm_status")
    private StatusMatricula status;

    @ManyToMany
    @JsonManagedReference
    @JoinTable(name = "matricula_has_curso", joinColumns = @JoinColumn(name = "cd_matricula"), inverseJoinColumns = @JoinColumn(name = "cd_curso"))
    private List<Curso> cursos;
}