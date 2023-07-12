package ml.academiadigital.controller;

import ml.academiadigital.entity.form.AvaliacaoFisicaForm;
import ml.academiadigital.service.impl.AvaliacaoFisicaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoFisicaController {

    private final AvaliacaoFisicaServiceImpl service;

    public AvaliacaoFisicaController(AvaliacaoFisicaServiceImpl service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Validated AvaliacaoFisicaForm form) {
        return ResponseEntity.ok(service.create(form));
    }

}
