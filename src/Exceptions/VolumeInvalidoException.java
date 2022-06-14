package Exceptions;

public class VolumeInvalidoException extends RuntimeException{
    public VolumeInvalidoException(){
        super("Volume invalido! Volume deve estar entre 0 litros e 10 litros");
    }
}

