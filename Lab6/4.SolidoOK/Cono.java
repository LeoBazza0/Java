public class Cono extends Solido {
    // ATTRIBUTI
    double raggioCono;
    double altezzaCono;

    // COSTRUTTORE
    public Cono(double raggioCono, double altezzaCono) throws IllegalArgumentException {
        super("cono");
        if (raggioCono <= 0 || altezzaCono <= 0)
            throw new IllegalArgumentException("Il raggio o altezza del cono non possono essere <= a zero");
        this.raggioCono = raggioCono;
        this.altezzaCono = altezzaCono;
        assert repOk();
    }

    // METODI
    public double getRaggio() {
        return this.raggioCono;
    }

    public double getAltezza() {
        return this.altezzaCono;
    }

    // REPOK
    public boolean repOk() {
        if (raggioCono <= 0 || altezzaCono <= 0)
            return false;
        return true;
    }

    // OVERRIDE
    @Override
    public double volume() {
        return Math.PI * altezzaCono * raggioCono * raggioCono / 3;
    }

    @Override
    public String toString() {
        return "Cono:\nraggio: " + raggioCono + "\naltezza: " + altezzaCono;
    }

}
