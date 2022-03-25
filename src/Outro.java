public class Outro extends Pedido{
    private String tamanho;

    public Outro(){
        super();
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    @Override
    public String toString() {
        return super.toString() + "\nTamanho    --> '" + tamanho + "'\n----------";
    }
}
