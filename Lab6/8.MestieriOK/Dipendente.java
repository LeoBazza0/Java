public class Dipendente extends Persona {

    // ATTRIBUTI
    double retribuzione;
    int annoAssunzione;
    String id;

    // COSTRUTTORI
    public Dipendente(String nome, String id, double retribuzione, int annoAssunzione) throws IllegalArgumentException {
        super(nome);
        if (id == null || id.equals(""))
            throw new IllegalArgumentException("id non valido");
        if (retribuzione <= 0)
            throw new IllegalArgumentException("retribuzione non valida");
        this.id = id;
        this.retribuzione = retribuzione;
        this.annoAssunzione = annoAssunzione;
        assert repOk();
    }

    // METODI
    public String getId() {
        return id;
    }

    public double getRetribuzione() {
        return retribuzione;
    }

    public int getAnno() {
        return annoAssunzione;
    }

    public void setRetribuzione(double retribuzione) {
        if (retribuzione < 0)
            throw new IllegalArgumentException("retribuzione non valida");
        this.retribuzione = retribuzione;
        assert repOk();
    }

    // REPOK OVERRIDE
    @Override
    public boolean repOk() {
        if (id == null)
            return false;
        if (id.equals(""))
            return false;
        if (retribuzione < 0)
            return false;
        return super.repOk();
    }

    // OVERRIDE
    @Override
    public String toString() {
        return super.toString().replace("Persona", "Dipendente") + ": Retribuzione " + retribuzione
                + " - Anno di Assuzione: " + annoAssunzione;
    }

}
