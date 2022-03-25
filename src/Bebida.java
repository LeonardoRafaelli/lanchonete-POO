public class Bebida extends Pedido{
    private double volume;

    public Bebida() {
        super();
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return super.toString() + "\nVolume   --> " + volume +
                "\n----------";
    }
}
