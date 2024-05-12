package com.claudio.school.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "endereco")
@Table(name = "endereco")
@EqualsAndHashCode(callSuper = true)
public class Endereco extends Audit {

    @Id
    @Column(name = "cd_endereco")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "no_cep")
    private String cep;

    @Column(name = "nm_logradouro")
    private String logradouro;

    @Column(name = "nm_complemento")
    private String complemento;

    @Column(name = "no_numero")
    private int numero;

    @Column(name = "nm_bairro")
    private String bairro;

    @Column(name = "nm_localidade")
    private String localidade;

    @JsonBackReference
    @OneToOne(mappedBy = "endereco")
    private Aluno aluno;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "cd_uf")
    private UF uf;

}
