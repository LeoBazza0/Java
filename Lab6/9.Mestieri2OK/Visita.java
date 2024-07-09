public class Visita {
    // OVERVIEW: classe che descrive la visita di un Paziente ad un Dottore
    // Non mutabile.

    // ATTRIBUTI            
    private final String nomeDottore;
    private final int idPaziente;

    // COSTRUTORI
    public Visita(String nomeDottore, int idPaziente) throws NullPointerException, IllegalArgumentException {
        // MODIFIES: this
        // EFFECTS: inizializza una nuova visita.
        // lancia NullPointerException se nomeDottore nullo
        // lancia IllegalArgumentException se nomeDottore vuoto o idPaziente < 0
        if (nomeDottore == null)
            throw new NullPointerException("Dottore nullo");
        if (nomeDottore.equals(""))
            throw new NullPointerException("Dottore vuoto");
        if (idPaziente < 0)
            throw new NullPointerException("Id Paziente < 0");
        this.nomeDottore = nomeDottore;
        this.idPaziente = idPaziente;

        assert repOk();
    }

    // METODI
    public String getNomeDottore() {
        return nomeDottore;
    }

    public int getIdPaziente() {
        return idPaziente;
    }

    // REPOK
    public boolean repOk() {
        if (nomeDottore == null)
            return false;
        if (nomeDottore.equals(""))
            return false;
        if (idPaziente < 0)
            return false;

        return true;
    }

    // REPOK
    @Override
    public String toString() {
        return "Visita del dottor" + nomeDottore + " al paziente " + idPaziente;
    }
}
