package ml.academiadigital.controller;


import ml.academiadigital.entity.Aluno;
import ml.academiadigital.entity.AvaliacaoFisica;
import ml.academiadigital.entity.form.AlunoForm;
import ml.academiadigital.entity.form.AlunoUpdateForm;
import ml.academiadigital.service.impl.AlunoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
    @Autowired
    private AlunoServiceImpl service;


    @PostMapping
    public Aluno create(@RequestBody AlunoForm form) {
        return service.create(form);
    }

    @GetMapping("/avaliacoes/{id}")
    public List<AvaliacaoFisica> getAllAvaliacaoFisicaId(@PathVariable Long id) {
        return service.getAllAvaliacaoFisicaId(id);
    }

    @GetMapping
    public List<Aluno> getAll(@RequestParam(value = "dataDeNascimento", required = false)
                                  String dataNascimento) {
        return service.getAll(dataNascimento);
    }
    @GetMapping("/{id}")
    public Aluno getAlunoId(@PathVariable Long id){
        return service.get(id);
    }

    @PutMapping("/{id}")
    public Aluno updateAluno(@PathVariable Long id, @RequestBody AlunoUpdateForm form) {


        return service.update(id, form);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAlunoId(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok("Aluno deletado com sucesso");
    }

}