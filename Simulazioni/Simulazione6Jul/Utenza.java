public abstract class Utenza implements Comparable<Utenza>, Cloneable {

    // ATTRIBUTI
    String numero;
    String nome;
    int durata;

    // COSTRUTTORI
    public Utenza(String numero, String nome) throws IllegalArgumentException, NullPointerException {
        if (numero == null)
            throw new NullPointerException("Numero nullo");
        if (nome == null)
            throw new NullPointerException("Nome nullo");
        if (nome.equals(""))
            throw new IllegalArgumentException("Nome vuoto");
        if (numero.length() != 10)
            throw new IllegalArgumentException("Numero non valido");
        try {
            Integer.parseInt(numero);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Numero non valido");
        }
        this.numero = numero;
        this.nome = nome;
        this.durata = 0;
        assert repOk();
    }

    // METODI
    public String getNumero() {
        return numero;
    }

    public String getNome() {
        return nome;
    }

    public int getDurata() {
        return durata;
    }

    public abstract void chiama(int secondi) throws IllegalArgumentException, TempoEsauritoException;

    public void incrementaDurata(int sec) throws IllegalArgumentException {
        if (sec < 0)
            throw new IllegalArgumentException("non ci possono essere durate negative");
        this.durata += sec;
        assert repOk();

    }

    // REPOK
    public boolean repOk() {
        if (durata < 0)
            return false;
        return true;

    }

    // OVERRIDE
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Utenza))
            return false;
        Utenza o = (Utenza) obj;
        if (numero == null) {
            if (o.numero != null)
                return false;
        }
        if (!numero.equals(o.numero))
            return false;
        return true;
    }

    @Override
    public int compareTo(Utenza o) {
        return Integer.compare(this.durata, o.durata);
    }

    @Override
    public String toString() {
        return "Utenza di " + nome + ", numero: " + numero + "; durata: " + durata;
    }

    @Override
    protected Object clone() {
        Utenza u = null;
        try {
            u = (Utenza) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return u;
    }
}
