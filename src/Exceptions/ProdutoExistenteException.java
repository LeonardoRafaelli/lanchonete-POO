package Exceptions;

public class ProdutoExistenteException extends RuntimeException{
    public ProdutoExistenteException(int tipo){
        if(tipo == 1){
            System.out.println("Lanche já existe!");
        }else if (tipo == 2){
            System.out.println("Bebida já existe");
        } else if (tipo == 3){
            System.out.println("Outro já existe");
        }

    }
}
