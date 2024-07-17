public class TrattaAereo extends Tratta {
    // ATTRIBUTI
    double qCO2;
    double fisso;

    // COSTRUTTORI
    public TrattaAereo(String origine, String destinazione, double lunghezza, double velocita, double qCO2,
            double fisso)
            throws NullPointerException, IllegalArgumentException {
        super(origine, destinazione, lunghezza, velocita);
        if (qCO2 < 0) {
            throw new IllegalArgumentException("il quantitativo non può essere negativo");
        }
        this.qCO2 = qCO2;
        this.fisso = fisso;
    }

    // METODI
    @Override
    public double getCO2() {
        return getLunghezza() * qCO2 + fisso;
    }

    // OVERRIDE
    @Override
    public String toString() {
        return "(Aereo) " + super.toString() + ", qCO2: " + qCO2 + "fisso: " + fisso;
    }
}
