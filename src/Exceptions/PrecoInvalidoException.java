package Exceptions;

public class PrecoInvalidoException extends RuntimeException{
    public PrecoInvalidoException(){
        super("Preço invalido! Preço deve estar entre R$0.00 e R$200.00");
    }
}

