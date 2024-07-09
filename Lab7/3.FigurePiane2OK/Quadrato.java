public class Quadrato implements Figura {
    // OVERVIEW: classe che descrive la Figura Quadrato. Immutabile

    // ATTRIBUTI
    public final double lato;

    // COSTRUTTORI
    public Quadrato(double lato) throws IllegalArgumentException {
        // MODIFIES: this
        // EFFECTS: inizializza un nuovo Quadrato
        // lancia IllegalArgumentException se lato <= 0
        if (lato <= 0)
            throw new IllegalArgumentException("Lato non valido");

        this.lato = lato;

        assert repOk();
    }

    // METODI
    @Override
    public double perimetro() {
        return lato * 4;
    }

    @Override
    public double area() {
        return lato * lato;
    }

    // REPOK
    public boolean repOk() {
        if (lato <= 0)
            return false;

        return true;
    }

    // OVERRIDE
    @Override
    public String toString() {
        return "Quadrato " + lato + " - Perimetro: " + perimetro();
    }
}
