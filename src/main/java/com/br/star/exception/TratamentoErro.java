package com.br.star.exception;

import com.br.star.exception.ValidacaoException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratamentoErro {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity TratarErro404() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(ValidacaoException.class)
    public ResponseEntity TratarErroIntegridade(ValidacaoException e) {
        return ResponseEntity.badRequest().body(e.getLocalizedMessage());
    }
}
