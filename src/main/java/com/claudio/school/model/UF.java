package com.claudio.school.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "uf")
@Table(name = "uf")
@EqualsAndHashCode(callSuper = true)
public class UF extends Audit {

    @Id
    @Column(name = "cd_uf")
    private Long id;

    @Column(name = "nm_uf", nullable = false, length = 50)
    private String nome;

    @Column(name = "nm_sigla", nullable = false, length = 2)
    private String sigla;

    @JsonBackReference
    @OneToMany(mappedBy = "uf", cascade = CascadeType.ALL)
    private List<Endereco> enderecos;
}
