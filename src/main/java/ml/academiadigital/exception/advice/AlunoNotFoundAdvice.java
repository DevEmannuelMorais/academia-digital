package ml.academiadigital.exception.advice;

import ml.academiadigital.exception.AlunoNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;


public class AlunoNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(AlunoNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    ResponseEntity<?> alunoNotFoundHandler(AlunoNotFoundException ex) {
        Map<String, Object> body = new HashMap<>();

        body.put("message", "id não existe");

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
    }
}
