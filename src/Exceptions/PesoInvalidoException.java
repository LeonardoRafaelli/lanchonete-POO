package Exceptions;

public class PesoInvalidoException extends RuntimeException{
    public PesoInvalidoException(){
        super("Peso invalido! Peso deve estar entre 0.0 Kg e 10.0 Kg");
    }

}
