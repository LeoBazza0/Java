
public class TrattaTreno extends Tratta {
    // ATTRIBUTI
    double qCO2;

    // COSTRUTTORI
    public TrattaTreno(String origine, String destinazione, double lunghezza, double velocita, double qCO2)
            throws IllegalArgumentException, NullPointerException {
        super(origine, destinazione, lunghezza, velocita);
        if (qCO2 < 0) {
            throw new IllegalArgumentException("il quantitativo non può essere negativo");
        }
        this.qCO2 = qCO2;
    }

    // METODI
    @Override
    public double getCO2() {
        return getLunghezza() * qCO2;
    }

    // OVERRIDE
    @Override
    public String toString() {
        return "(Treno) " + super.toString() + ", qCO2: " + qCO2;
    }
}
