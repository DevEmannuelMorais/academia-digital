package ml.academiadigital.controller;

import ml.academiadigital.exception.AlunoNullException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class AlunoControllerAdvice extends ResponseEntityExceptionHandler {
    @ExceptionHandler(AlunoNullException.class)
    public ResponseEntity<?> capturaErroNull() {
        Map<String, Object> body = new HashMap<>();

        body.put("message", "Verifique o formulario do aluno");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);

    }

}
