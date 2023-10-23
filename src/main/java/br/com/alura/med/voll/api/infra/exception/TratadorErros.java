package br.com.alura.med.voll.api.infra.exception;

import br.com.alura.med.voll.api.domain.ValidaConsultaException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratadorErros {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity tratarErro404(){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity tratarErro400(MethodArgumentNotValidException ex){
        var erros = ex.getFieldErrors();
        return ResponseEntity.badRequest().body(erros.stream().map(dadosErroValidacao::new).toList());
    }

    @ExceptionHandler(ValidaConsultaException.class)
    public ResponseEntity tratarErroNegocio(ValidaConsultaException ex){
        var erros = ex.getMessage();
        return ResponseEntity.badRequest().body(erros);
    }


    private record dadosErroValidacao(String campo, String mensagem){
        public dadosErroValidacao(FieldError erro){
            this(erro.getField(),erro.getDefaultMessage());
        }

    }
}
