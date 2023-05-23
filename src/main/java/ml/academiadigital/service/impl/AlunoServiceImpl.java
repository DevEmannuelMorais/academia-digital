package ml.academiadigital.service.impl;


import ml.academiadigital.entity.Aluno;
import ml.academiadigital.entity.AvaliacaoFisica;
import ml.academiadigital.entity.form.AlunoForm;
import ml.academiadigital.entity.form.AlunoUpdateForm;
import ml.academiadigital.infra.utils.JavaTimeUtils;
import ml.academiadigital.repository.AlunoRepository;
import ml.academiadigital.service.iservice.IAlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class AlunoServiceImpl implements IAlunoService {
    @Autowired
    private AlunoRepository alunoRepository;

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
    public Aluno get(Long id) {
        return null;
    }

    @Override
    @Transactional
    public List<Aluno> getAll(String dataDeNascimento) {

        if (dataDeNascimento == null) {
            return alunoRepository.findAll();
        }
        else {
            LocalDate localDate = LocalDate.parse(dataDeNascimento, JavaTimeUtils.LOCAL_DATE_FORMATTER);
            return alunoRepository.findByDataDeNascimento(localDate);
        }
    }

    @Override
    public Aluno update(Long id, AlunoUpdateForm formUpdate) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<AvaliacaoFisica> getAllAvaliacaoFisicaId(Long id) {
        Aluno aluno =  alunoRepository.findById(id).get();

        return aluno.getAvaliacoes();
    }


}