import java.util.Scanner;

public class Asteroide {

    double massa; // in kg
    double distanza; // in km

    // COSTRUTTORE
    public Asteroide(double massa, double distanza) {
        this.massa = massa;
        this.distanza = distanza;
    }

    // METODI
    public double getMassa() {
        return massa;
    }

    public double getDistanza() {
        return distanza;
    }

    public double getForzaGravitazionale() {
        return (this.massa / (this.distanza * this.distanza));
    }

    @Override
    public String toString() {
        return "Asteroide a distanza " + this.distanza + "km del peso di " + this.massa + "kg";
    }
}
