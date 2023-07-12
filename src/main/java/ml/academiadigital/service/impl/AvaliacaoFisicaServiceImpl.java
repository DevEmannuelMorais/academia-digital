package ml.academiadigital.service.impl;

import ml.academiadigital.entity.AvaliacaoFisica;
import ml.academiadigital.entity.form.AvaliacaoFisicaForm;
import ml.academiadigital.entity.form.AvaliacaoFisicaUpdateForm;
import ml.academiadigital.repository.AlunoRepository;
import ml.academiadigital.repository.AvaliacaoFisicaRepository;
import ml.academiadigital.service.iservice.IAvaliacaoFisicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class AvaliacaoFisicaServiceImpl implements IAvaliacaoFisicaService {
    private final AvaliacaoFisicaRepository avaliacaoFisicaRepository;
    private final AlunoRepository alunoRepository;
    public AvaliacaoFisicaServiceImpl(AvaliacaoFisicaRepository avaliacaoFisicaRepository, AlunoRepository alunoRepository) {
        this.avaliacaoFisicaRepository = avaliacaoFisicaRepository;
        this.alunoRepository = alunoRepository;
    }

    @Override
    public AvaliacaoFisica create(AvaliacaoFisicaForm form) {
        AvaliacaoFisica avaliacaoFisica = new AvaliacaoFisica();
        avaliacaoFisica.setPeso(form.getPeso());
        avaliacaoFisica.setAltura(form.getAltura());
        avaliacaoFisica.setAluno(alunoRepository.getReferenceById(form.getAlunoId()));
        return avaliacaoFisicaRepository.save(avaliacaoFisica);
    }

    @Override
    public List<AvaliacaoFisica> get(Long id) {
        return Collections.singletonList(avaliacaoFisicaRepository.findById(id).get());
    }

    @Override
    public List<AvaliacaoFisica> getAll() {
        Sort sort = Sort.by("id").descending().and(
                Sort.by("nome").ascending()
        );
        return avaliacaoFisicaRepository.findAll(sort);
    }

    @Override
    public AvaliacaoFisica update(Long id, AvaliacaoFisicaUpdateForm formUpdate) {
        AvaliacaoFisica avaliacaoFisica = avaliacaoFisicaRepository.findById(id).get();
        avaliacaoFisica.setPeso(formUpdate.getPeso());
        avaliacaoFisica.setPeso(formUpdate.getPeso());
        return avaliacaoFisica;
    }

    @Override
    public void delete(Long id) {
        avaliacaoFisicaRepository.deleteById(id);
    }
}