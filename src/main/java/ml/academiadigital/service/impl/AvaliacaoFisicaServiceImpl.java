package ml.academiadigital.service.impl;

import ml.academiadigital.entity.AvaliacaoFisica;
import ml.academiadigital.entity.form.AvaliacaoFisicaForm;
import ml.academiadigital.entity.form.AvaliacaoFisicaUpdateForm;
import ml.academiadigital.repository.AlunoRepository;
import ml.academiadigital.repository.AvaliacaoFisicaRepository;
import ml.academiadigital.service.iservice.IAvaliacaoFisicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AvaliacaoFisicaServiceImpl implements IAvaliacaoFisicaService {
    @Autowired
    private AvaliacaoFisicaRepository avaliacaoFisicaRepository;
    @Autowired
    private AlunoRepository alunoRepository;
    @Override
    public AvaliacaoFisica create(AvaliacaoFisicaForm form) {
        AvaliacaoFisica avaliacaoFisica = new AvaliacaoFisica();
        avaliacaoFisica.setPeso(form.getPeso());
        avaliacaoFisica.setAltura(form.getAltura());
        avaliacaoFisica.setAluno(alunoRepository.getReferenceById(form.getAlunoId()));
        return avaliacaoFisicaRepository.save(avaliacaoFisica);
    }

    @Override
    public AvaliacaoFisica get(Long id) {
        return null;
    }

    @Override
    public List<AvaliacaoFisica> getAll() {
        return null;
    }

    @Override
    public AvaliacaoFisica update(Long id, AvaliacaoFisicaUpdateForm formUpdate) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
