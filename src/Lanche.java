public class Lanche extends Pedido{
    private double peso;

    public Lanche(int codigo, String descricao, double preco, double peso) {
        super(codigo, descricao, preco);
        this.peso = peso;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return super.toString() + "\nPeso      --> " + getPeso() + " Kg\n----------";
    }
}
