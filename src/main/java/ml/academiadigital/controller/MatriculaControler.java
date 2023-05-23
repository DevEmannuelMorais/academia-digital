package ml.academiadigital.controller;

import jakarta.validation.Valid;
import ml.academiadigital.entity.Matricula;
import ml.academiadigital.entity.form.MatriculaForm;
import ml.academiadigital.service.impl.MatriculaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matriculas")
public class MatriculaControler {
    @Autowired
    private MatriculaServiceImpl service;

    @PostMapping
    public Matricula create(@Valid @RequestBody MatriculaForm form) {return service.create(form);}

    @GetMapping
    public List<Matricula> getAll(@RequestParam(value = "bairro", required = false) String bairro) {
        return service.getAll(bairro);
    }
}
