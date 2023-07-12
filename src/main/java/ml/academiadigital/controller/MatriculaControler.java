package ml.academiadigital.controller;

import ml.academiadigital.entity.Matricula;
import ml.academiadigital.entity.form.MatriculaForm;
import ml.academiadigital.service.iservice.IMatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matriculas")
public class MatriculaControler {

    private final IMatriculaService service;

    public MatriculaControler(IMatriculaService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody @Validated MatriculaForm form) {
        return ResponseEntity.ok(service.create(form));
    }

    @GetMapping("/getAll")
    public List<Matricula> getAll(@RequestParam(value = "bairro", required = false) String bairro) {
        return service.getAll(bairro);
    }
}
