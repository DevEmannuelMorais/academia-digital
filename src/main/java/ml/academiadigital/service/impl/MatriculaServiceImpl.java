package ml.academiadigital.service.impl;

import ml.academiadigital.entity.Aluno;
import ml.academiadigital.entity.Matricula;
import ml.academiadigital.entity.form.MatriculaForm;
import ml.academiadigital.repository.AlunoRepository;
import ml.academiadigital.repository.MatriculaRepository;
import ml.academiadigital.service.iservice.IMatriculaService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MatriculaServiceImpl implements IMatriculaService {
    private MatriculaRepository matriculaRepository;

    private AlunoRepository alunoRepository;
    @Override
    public Matricula create(MatriculaForm form) {
        Matricula matricula = new Matricula();
        Aluno aluno = alunoRepository.findById(form.getAlunoId()).get();

        matricula.setAluno(aluno);
        return matriculaRepository.save(matricula);
    }

    @Override
    public Matricula get(Long id) {
        return null;
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

    }
}
