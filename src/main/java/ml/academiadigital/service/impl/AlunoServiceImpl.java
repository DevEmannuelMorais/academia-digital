package ml.academiadigital.service.impl;


import ml.academiadigital.entity.Aluno;
import ml.academiadigital.entity.AvaliacaoFisica;
import ml.academiadigital.entity.form.AlunoForm;
import ml.academiadigital.entity.form.AlunoUpdateForm;
import ml.academiadigital.exception.AlunoNotFoundException;
import ml.academiadigital.infra.utils.JavaTimeUtils;
import ml.academiadigital.repository.AlunoRepository;
import ml.academiadigital.service.iservice.IAlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;


import static org.springframework.util.Assert.notNull;

@Service
public class AlunoServiceImpl implements IAlunoService {
    private final AlunoRepository alunoRepository;
@Autowired
    public AlunoServiceImpl(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    @Override
    public Aluno create(AlunoForm form) {
        Aluno aluno = new Aluno();
        aluno.setNome(form.getNome());
        aluno.setCpf(form.getCpf());
        aluno.setBairro(form.getBairro());
        aluno.setDataDeNascimento(form.getDataDeNascimento());

        return alunoRepository.save(aluno);

    }

    @Override
    @Transactional(readOnly = true)
    public Aluno get(Long id) {
        if (id == null) {
            throw new NullPointerException("Erro ao buscar pessoas por id = null");
        }
        try {
            notNull(id, "Id Obrigatorio");
            return alunoRepository.findById(id).get();
        }

        catch (RuntimeException e) {

                throw new AlunoNotFoundException(id);

//            if (e.equals(NullPointerException.class)) {
//                throw new AlunoNullException("O id do aluno não pode ser nulo ");
//            }

        }

//        //.orElseThrow(() ->new AlunoNotFoundException(id)
    }

    @Override
    @Transactional
    public List<Aluno> getAll(String dataDeNascimento) {

        if (dataDeNascimento == null) {
            Sort sort = Sort.by("id").descending().and(
                    Sort.by("nome").ascending()
            );
            return alunoRepository.findAll(sort);
        }
        else {
            LocalDate localDate = LocalDate.parse(dataDeNascimento, JavaTimeUtils.LOCAL_DATE_FORMATTER);
            return alunoRepository.findByDataDeNascimento(localDate);
        }
    }
    public List<Aluno> getConsultaPaginada(Integer numPagina, Integer numRegistros) {
        PageRequest pag = PageRequest.of(numPagina, numRegistros);
        Page<Aluno> result = alunoRepository.findAll(pag);
        return result.stream().toList();

    }
    @Transactional(readOnly = false)
    @Override
    public Aluno update(Long id, AlunoUpdateForm formUpdate) {
        Aluno aluno = alunoRepository.findById(id).orElseThrow(() -> new AlunoNotFoundException(id));
            aluno.setNome(formUpdate.getNome());
            aluno.setBairro(formUpdate.getBairro());
            aluno.setDataDeNascimento(formUpdate.getDataDeNascimento());
            return alunoRepository.save(aluno);


    }

    @Override
    public void delete(Long id) {
        alunoRepository.deleteById(id);
    }

    @Override
    public List<AvaliacaoFisica> getAllAvaliacaoFisicaId(Long id) {
        Aluno aluno =  alunoRepository.findById(id).get();

        return aluno.getAvaliacoes();
    }




}