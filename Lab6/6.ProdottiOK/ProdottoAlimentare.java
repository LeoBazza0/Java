import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ProdottoAlimentare extends Prodotto {

    // ATTRIBUTI
    private LocalDate dataScadenza;
    double scontoAlimentare = 30.0;

    // COSTRUTTORI
    public ProdottoAlimentare(String nomeProdotto, double prezzoOriginale, LocalDate dataScadenza)
            throws IllegalArgumentException, NullPointerException {
        super(nomeProdotto, prezzoOriginale);

        if (dataScadenza == null)
            throw new NullPointerException("Data nulla");

        this.dataScadenza = dataScadenza;
        assert repOk();
    }

    // METODI
    public LocalDate getLocalDate() {
        return dataScadenza;
    }

    // REPOK
    public boolean repOk() {
        if (nomeProdotto == null || nomeProdotto.equals(""))
            return false;
        if (prezzoOriginale < 0)
            return false;
        if (prezzoOriginale == 0)
            return false;
        if (dataScadenza == null)
            return false;
        return true;
    }

    // OVERRIDE
    @Override
    public double sconto() {
        if (LocalDate.now().until(dataScadenza, ChronoUnit.DAYS) < 10)
            return super.sconto(scontoAlimentare);
        return super.sconto();
    }

    @Override
    public double getPercentualeSconto() {
        if (LocalDate.now().until(dataScadenza, ChronoUnit.DAYS) < 10)
            return scontoAlimentare;
        return super.getPercentualeSconto();
    }

    @Override
    public String toString() {
        return super.toString().replace("Prodotto", "Prodotto Alimentare");
    }

    // ITERATORI

}
