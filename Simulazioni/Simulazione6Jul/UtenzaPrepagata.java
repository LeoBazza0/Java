public class UtenzaPrepagata extends Utenza {
    // ATTRIBUTI
    int creditoResiduo;

    // CASTRUTTORI
    public UtenzaPrepagata(String numero, String nome)
            throws IllegalArgumentException, NullPointerException {

        super(numero, nome);
        this.creditoResiduo = 0;
        assert repOk();
    }

    // METODI
    public int getCreditoResiduo() {
        return creditoResiduo;
    }

    public void ricarica(int secondi) throws IllegalArgumentException {
        if (secondi < 0)
            throw new IllegalArgumentException("Secondi non validi");
        this.creditoResiduo += secondi;
        assert repOk();
    }

    // REPOK
    @Override
    public boolean repOk() {
        if (creditoResiduo < 0)
            return false;
        return super.repOk();
    }

    // OVERRIDE
    @Override
    public String toString() {
        return super.toString() + ", credito: " + creditoResiduo;
    }

    @Override
    public void chiama(int secondi) throws IllegalArgumentException, TempoEsauritoException {
        if (secondi > creditoResiduo)
            throw new TempoEsauritoException("tempo esaurito");
        if (secondi < 0)
            throw new IllegalArgumentException("non è possibile fare chiamate minori di 0 secondi");
        incrementaDurata(secondi);
        creditoResiduo -= secondi;
        assert repOk();
    }

}
