public class Prodotto {

    // ATTRIBUTI
    String nomeProdotto;
    double prezzoOriginale;
    double scontoDefault = 5.00;

    // COSTRUTTORI
    public Prodotto(String nomeProdotto, double prezzoOriginale) throws IllegalArgumentException, NullPointerException {
        if (nomeProdotto == null || nomeProdotto.equals(""))
            throw new NullPointerException("nome specificato è nullo");
        if (prezzoOriginale < 0)
            throw new IllegalArgumentException("il prezzo non può essere negativo");
        if (prezzoOriginale == 0)
            throw new IllegalArgumentException("il prezzo non può essere uguae a zero");
        this.nomeProdotto = nomeProdotto;
        this.prezzoOriginale = prezzoOriginale;
        assert repOk();
    }

    // METODI
    public String getNome() {
        return nomeProdotto;
    }

    public double getPrezzoOriginale() {
        return prezzoOriginale;
    }

    public double getPercentualeSconto() {
        return scontoDefault;
    }

    public void setPrezzoOriginale(double prezzoOriginale) throws IllegalArgumentException {
        if (prezzoOriginale < 0)
            throw new IllegalArgumentException("il prezzo non può essere negativo");
        if (prezzoOriginale == 0)
            throw new IllegalArgumentException("il prezzo non può essere uguae a zero");
        this.prezzoOriginale = prezzoOriginale;
        assert repOk();
    }

    public double sconto() {
        return prezzoOriginale - prezzoOriginale * (scontoDefault / 100);
    }

    public double sconto(double percentuale) throws IllegalArgumentException {
        if (percentuale < 0)
            throw new IllegalArgumentException("la percentuale non può essere minore di zero");
        return prezzoOriginale - prezzoOriginale * (percentuale / 100);
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
    }

    // OVERRIDE
    @Override
    public String toString() {
        return "Prodotto " + nomeProdotto + " con prezzo " + prezzoOriginale + "€";
    }

    // ITERATORI

}
