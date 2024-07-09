
public abstract class PoliticaSconto {
    // ATTRIBUTI
    int numeroArticoli;
    double prezzoArticolo;

    // COSTRUTTORI
    public PoliticaSconto(int numeroArticoli, double prezzoArticolo) throws IllegalArgumentException {
        if (numeroArticoli <= 0)
            throw new IllegalArgumentException("Numeri Articoli non valido");
        if (prezzoArticolo < 0)
            throw new IllegalArgumentException("Prezzo non valido");

        this.numeroArticoli = numeroArticoli;
        this.prezzoArticolo = prezzoArticolo;

        assert repOk();

    }

    // METODI
    public abstract double calcolaSconto();

    public double prezzoTotaleListino() {
        // EFFECTS: ritorna numeroArticoli * prezzoArticolo, senza applicare sconti
        return numeroArticoli * prezzoArticolo;
    }

    // REPOK
    public boolean repOk() {
        if (numeroArticoli <= 0)
            return false;
        if (prezzoArticolo < 0)
            return false;
        return true;
    }

    // OVERRIDE
    @Override
    public String toString() {
        return "Politica di Sconto generica su " + numeroArticoli + " articoli da " + prezzoArticolo + " l'uno";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof PoliticaSconto))
            return false;
        PoliticaSconto other = (PoliticaSconto) obj;
        if (numeroArticoli != other.numeroArticoli)
            return false;
        if (Double.doubleToLongBits(prezzoArticolo) != Double.doubleToLongBits(other.prezzoArticolo))
            return false;
        return true;
    }

}
