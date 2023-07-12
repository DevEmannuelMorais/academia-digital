package ml.academiadigital.controller;


import ml.academiadigital.exception.AlunoNullException;
import ml.academiadigital.exception.AvaliacaoNegativeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

public class AvaliacaoFisicaControllerAdvice extends ResponseEntityExceptionHandler {
    @ExceptionHandler(AvaliacaoNegativeException.class)
    public ResponseEntity<?> capturaErroNegativo() {
        Map<String, Object> body = new HashMap<>();

        body.put("message", "verifique se algum valor está negativo");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);

    }
}
