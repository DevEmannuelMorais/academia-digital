package ml.academiadigital.entity.form;

import jakarta.persistence.Entity;

import java.time.LocalDateTime;
@Entity
public class Matricula {
    private Long id;
    private Aluno aluno;
    private LocalDateTime dataDaMatricula;
}
