public class UtenzaSoglia extends UtenzaPrepagata {
    
    // ATTRIBUTI
    private final int soglia;

    // COSTRUTTORI
    public UtenzaSoglia(String numero, String nome, int soglia)
            throws NullPointerException, IllegalArgumentException {
        super(numero, nome);

        if (soglia < 0)
            throw new IllegalArgumentException("Soglia non valida");

        this.soglia = soglia;

        reset();
        assert repOk();
    }

    // METODI
    public void reset() {
        super.ricarica(soglia);
        assert repOk();
    }

    public void ricarica(int secondi) throws IllegalArgumentException {
        throw new IllegalArgumentException("Operazione non ammessa su Utenza Soglia");
    }

    // REPOK
    public boolean repOk() {
        if (getCreditoResiduo() > soglia)
            return false;
        return true;
    }

    // OVERRIDE
    @Override
    public String toString() {
        return super.toString() + ", soglia: " + soglia;
    }

}
