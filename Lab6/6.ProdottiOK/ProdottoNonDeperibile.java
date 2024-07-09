public class ProdottoNonDeperibile extends Prodotto {
    // ATTRIBUTI
    boolean riciclabile;
    double ScontoRiciclabile = 10.00;

    // COSTRUTTORI
    public ProdottoNonDeperibile(String nomeProdotto, double prezzoOriginale, boolean riciclabile)
            throws IllegalArgumentException, NullPointerException {
        super(nomeProdotto, prezzoOriginale);
        this.riciclabile = riciclabile;
        assert repOk();
    }

    // METODI
    public boolean getRiciclabile() {
        return riciclabile;
    }

    // REPOK
    public boolean repOk() {
        if (nomeProdotto == null || nomeProdotto.equals(""))
            return false;
        if (prezzoOriginale < 0)
            return false;
        if (prezzoOriginale == 0)
            return false;
        return true;
        // return super.repOk();
    }

    // OVERRIDE
    @Override
    public double sconto() {
        if (riciclabile)
            return prezzoOriginale - prezzoOriginale * (ScontoRiciclabile / 100);
        return super.sconto();
    }

    @Override
    public double getPercentualeSconto() {
        if (riciclabile)
            return ScontoRiciclabile;
        return super.getPercentualeSconto();
    }

    @Override
    public String toString() {
        return super.toString().replace("Prodotto", "Prodotto non deperibile");
    }
    // ITERATORI

}
