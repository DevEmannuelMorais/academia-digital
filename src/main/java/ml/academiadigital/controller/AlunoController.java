package ml.academiadigital.controller;


import ml.academiadigital.entity.Aluno;
import ml.academiadigital.entity.AvaliacaoFisica;
import ml.academiadigital.entity.form.AlunoForm;
import ml.academiadigital.entity.form.AlunoUpdateForm;
import ml.academiadigital.service.impl.AlunoServiceImpl;
import ml.academiadigital.service.iservice.IAlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
    @Autowired
    private IAlunoService alunoService;


    @PostMapping
    public Aluno create(@RequestBody AlunoForm form) {
        return alunoService.create(form);
    }

    @GetMapping("/avaliacoes/{id}")
    public List<AvaliacaoFisica> getAllAvaliacaoFisicaId(@PathVariable Long id) {
        return alunoService.getAllAvaliacaoFisicaId(id);
    }

    @GetMapping
    public List<Aluno> getAll(@RequestParam(value = "dataDeNascimento", required = false)
                                  String dataNascimento) {
        return alunoService.getAll(dataNascimento);
    }
    @GetMapping("/{id}")
    public Aluno getAlunoId(@PathVariable Long id){
        return alunoService.get(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aluno> updateAluno(@PathVariable Long id, @RequestBody AlunoUpdateForm form) {
        return ResponseEntity.ok(alunoService.update(id, form));

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAlunoId(@PathVariable Long id) {
        alunoService.delete(id);
        return ResponseEntity.ok("Aluno deletado com sucesso");
    }

}