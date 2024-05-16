package com.claudio.school.model;

import com.claudio.school.dtos.aluno.AlunoUDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@Builder
@Entity(name = "aluno")
@Table(name = "aluno")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Aluno extends Audit {

    @Id
    @Column(name = "cd_aluno")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nm_aluno", nullable = false, unique = true)
    private String nome;

    @Email
    @Column(name = "nm_email", nullable = false, unique = true)
    private String email;

    @Temporal(TemporalType.DATE)
    @Column(name = "dt_nascimento", nullable = false)
    private LocalDate dataNascimento;

    @JsonManagedReference
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cd_endereco")
    private Endereco endereco;

    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "cd_matricula")
    private Matricula matricula;

    public void atualizar(AlunoUDTO alunoUDTO) {
        this.nome = Objects.isNull(alunoUDTO.nome()) ? this.nome : alunoUDTO.nome();
        this.email = Objects.isNull(alunoUDTO.email()) ? this.email : alunoUDTO.email();
        this.dataNascimento = Objects.isNull(alunoUDTO.dataNascimento()) ? this.dataNascimento : alunoUDTO.dataNascimento();
    }

}
