public class Sfera extends Solido {
    // ATTRIBUTI
    double raggioSfera;

    // COSTRUTTORI
    public Sfera(double raggioSfera) throws IllegalArgumentException {
        super("sfera");
        if (raggioSfera <= 0)
            throw new IllegalArgumentException("Il raggio della sfera non può essere <= a 0");
        this.raggioSfera = raggioSfera;
        assert repOk();
    }

    // METODI
    public double getRaggio() {
        return this.raggioSfera;
    }

    // REPOK
    public boolean repOk() {
        if (raggioSfera <= 0)
            return false;
        return true;
    }

    // OVERRIDE
    @Override
    public double volume() {
        return (4 / 3) * Math.PI * Math.pow(raggioSfera, 3);
    }

    @Override
    public String toString() {
        return "Sfera:\nraggio: " + raggioSfera;
    }
}
