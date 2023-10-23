package br.com.alura.med.voll.api.domain;

public class ValidaConsultaException extends RuntimeException {
    public ValidaConsultaException(String mensagem) {
        super(mensagem);
    }
}
