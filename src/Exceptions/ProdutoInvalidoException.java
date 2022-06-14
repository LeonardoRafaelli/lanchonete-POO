package Exceptions;

public class ProdutoInvalidoException extends RuntimeException{
    public ProdutoInvalidoException(){
        super("Produto invalido!");
    }
}

