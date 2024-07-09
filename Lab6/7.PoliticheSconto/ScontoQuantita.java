
public class ScontoQuantita extends PoliticaSconto {
    // OVERVIEW: Essa dovrebbe avere un costruttore con altri due parametri,
    // `minimo` e `percentuale`. Inoltre, dovrebbe ridefinire il metodo
    // calcolaSconto in modo che se la quantità di un articolo acquistato è maggiore
    // del `minimo`, lo sconto è di `percentuale` sul totale.

    // ATTRIBUTI
    double minimo;
    double percentuale;

    // COSTRUTTORI
    public ScontoQuantita(int numeroArticoli, double prezzoArticolo, double minimo, double percentuale)
            throws IllegalArgumentException {
        if (minimo <= 0)
            throw new IllegalArgumentException("minio negativo");
        if (percentuale <= 0)
            throw new IllegalArgumentException("percentuale negativa");
        this.minimo = minimo;
        this.percentuale = percentuale;
        assert repOk();
    }
    // METODI

    // REPOK
    @Override
    public boolean repOk() {
        if (minimo < 0)
            return false;
        if (percentuale < 0)
            return false;
        return super.repOk();
    }

    // OVERRIDE
    @Override
    public double calcolaSconto() {
        if (numeroArticoli >= minimo)
            return prezzoTotaleListino() * percentuale / 100;
        return 0;
    }

    @Override
    public String toString() {
        return super.toString().replace("generica", "'Sconto Quantita''") + " - Sconto del " + percentuale
                + "% per quantita' superiori a " + (minimo - 1);
    }

}
