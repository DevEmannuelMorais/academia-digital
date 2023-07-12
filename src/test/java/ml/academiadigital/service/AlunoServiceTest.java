package ml.academiadigital.service;

import ml.academiadigital.entity.Aluno;
import ml.academiadigital.entity.AvaliacaoFisica;
import ml.academiadigital.exception.AlunoNotFoundException;
import ml.academiadigital.exception.AlunoNullException;
import ml.academiadigital.repository.AlunoRepository;
import ml.academiadigital.service.impl.AlunoServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.CollationElementIterator;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;



import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AlunoServiceTest {
    @InjectMocks
    AlunoServiceImpl service;

    @Mock
    AlunoRepository repository;

    Aluno aluno;
    AvaliacaoFisica avaliacaoFisica;

    @BeforeEach
    public void setUp() {
        aluno = new Aluno(1L,"Emannuel","22244412335","Centro", LocalDate.parse("2002-04-23"),  Collections.singletonList(avaliacaoFisica));
        avaliacaoFisica = new AvaliacaoFisica(1L, aluno, LocalDateTime.now(),94d, 1.9);
    }


    @Test
    void deveBuscarTodosAlunosComSucesso() {
        when(repository.findAll()).thenReturn(Collections.singletonList(aluno));

        List<Aluno> alunos = service.getAll(null);
        assertEquals(Collections.singletonList(aluno), alunos);
        verify(repository).findAll();
        verifyNoMoreInteractions(repository);



    }
    @Test
    void DeveBuscarAlunosPorIdComSucesso() {
        when(repository.findById(aluno.getId())).thenReturn(Optional.of(aluno));

        Aluno findAluno = service.get(aluno.getId());
        assertEquals(aluno,findAluno);
        verify(repository).findById(aluno.getId());
        verifyNoMoreInteractions(repository);

    }

    @Test
    void naoDeveChamaroRepositoryCasoParametroIdNull() {
        final NullPointerException e = assertThrows(NullPointerException.class, () -> {
            service.get(null);
        });
        assertThat(e, notNullValue());
        assertThat(e.getMessage(), is("Erro ao buscar pessoas por id = null"));
        //assertThat(e.getCause().getMessage(), is("Could not find the id: "+ 10L));
        verifyNoInteractions(repository);
    }

}
