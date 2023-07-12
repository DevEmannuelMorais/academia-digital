package ml.academiadigital.controller;


import ml.academiadigital.entity.Aluno;
import ml.academiadigital.entity.form.AlunoForm;
import ml.academiadigital.entity.form.AlunoUpdateForm;
import ml.academiadigital.service.iservice.IAlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
    private final IAlunoService alunoService;
    public AlunoController(IAlunoService alunoService) {
        this.alunoService = alunoService;
    }


    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Validated AlunoForm form) {
        return ResponseEntity.ok(alunoService.create(form));
    }

    @GetMapping("/avaliacoes/{id}")
    public List<?> getAllAvaliacaoFisicaId(@PathVariable Long id) {
        return ResponseEntity.ok(alunoService.getAllAvaliacaoFisicaId(id)).getBody();
    }

    @GetMapping
    public ResponseEntity<List<Aluno>> getAll(@RequestParam(value = "dataDeNascimento", required = false)
                                  String dataNascimento) {
        return ResponseEntity.ok().body(alunoService.getAll(dataNascimento));
    }
    @GetMapping("/{id}")
    public Aluno getAlunoId(@PathVariable Long id){
        return alunoService.get(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateAluno(@PathVariable Long id, @RequestBody @Validated AlunoUpdateForm form) {
        return ResponseEntity.ok().body(alunoService.update(id, form));

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAlunoId(@PathVariable Long id) {
        alunoService.delete(id);
        return ResponseEntity.ok().body(alunoService);
    }

}