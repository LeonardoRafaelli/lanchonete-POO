package Exceptions;

public class TamanhoInvalidoException extends RuntimeException{
    public TamanhoInvalidoException(){
        super("Tamanho invalido! Tamanhos disponíveis: Pequena, Média, Grande");
    }
}

