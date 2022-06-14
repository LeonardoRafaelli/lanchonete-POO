package Exceptions;

public class OpcaoInvalidaException extends RuntimeException{
    public OpcaoInvalidaException(){
        super("Opcao invalida!");
    }
}
