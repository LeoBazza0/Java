public class Cerchio implements Figura {
    // OVERVIEW: classe che descrive la Figura Cerchio. Immutabile

    // ATTRIBUTI
    public final double raggio;

    // COSTRUTTORI
    public Cerchio(double raggio) throws IllegalArgumentException {
        // MODIFIES: this
        // EFFECTS: inizializza un nuovo Cerchio
        // lancia IllegalArgumentException se raggio <= 0
        if (raggio <= 0)
            throw new IllegalArgumentException("Raggio non valido");

        this.raggio = raggio;

        assert repOk();
    }

    // METODI
    @Override
    public double perimetro() {
        return 2 * raggio * Math.PI;
    }

    @Override
    public double area() {
        return Math.PI * raggio * raggio;
    }

    // REPOK
    public boolean repOk() {
        if (raggio <= 0)
            return false;

        return true;
    }

    // OVERRIDE
    @Override
    public String toString() {
        return "Cerchio " + raggio + " - Perimetro: " + perimetro();
    }
}