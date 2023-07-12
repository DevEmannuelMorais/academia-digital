package ml.academiadigital.service.impl;

import ml.academiadigital.entity.Aluno;
import ml.academiadigital.entity.Matricula;
import ml.academiadigital.entity.form.MatriculaForm;
import ml.academiadigital.repository.AlunoRepository;
import ml.academiadigital.repository.MatriculaRepository;
import ml.academiadigital.service.iservice.IMatriculaService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class MatriculaServiceImpl implements IMatriculaService {
    private final MatriculaRepository matriculaRepository;

    private final AlunoRepository alunoRepository;

    public MatriculaServiceImpl(MatriculaRepository matriculaRepository, AlunoRepository alunoRepository) {
        this.matriculaRepository = matriculaRepository;
        this.alunoRepository = alunoRepository;
    }

    @Override
    public List<Matricula> create(MatriculaForm form) {
        Matricula matricula = new Matricula();
        Aluno aluno = alunoRepository.findById(form.getAlunoId()).get();

        matricula.setAluno(aluno);
        return Collections.singletonList(matriculaRepository.save(matricula));
    }

    @Override
    public Matricula get(Long id) {
        return matriculaRepository.findById(id).get();
    }

    @Override
    public List<Matricula> getAll(String bairro) {
        if (bairro == null){
            return matriculaRepository.findAll();
        }else {
            return matriculaRepository.findByAlunoBairro(bairro);
        }

    }

    @Override
    public void delete(Long id) {
        matriculaRepository.deleteById(id);
    }


}
