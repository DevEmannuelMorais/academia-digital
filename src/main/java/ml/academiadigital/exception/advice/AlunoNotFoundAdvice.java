package ml.academiadigital.exception.advice;

import ml.academiadigital.exception.AlunoNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


public class AlunoNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(AlunoNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String alunoNotFoundHandler(AlunoNotFoundException ex) {
        final String message = ex.getMessage();
        return message;
    }
}
