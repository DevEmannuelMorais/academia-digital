package ml.academiadigital.entity.form;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tb_aluno")
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_aluno")
    private Long id;
    private String nome;
    private String cpf;
    private String bairro;
    private LocalDate dataDeNascimento;
    private AvaliacaoFisica avaliacaoFisica;
}
