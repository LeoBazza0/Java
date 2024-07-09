public class Piatto {

    // ATTRIBUTI
    String nome;
    String tipo;
    int costo;
 
    // COSTRUTTORI
    public Piatto(String nome, String tipo, int costo) throws NullPointerException, IllegalArgumentException {
        if (tipo == null || nome == null)
            throw new NullPointerException("inserito un parametro nullo");

        if (nome.equals(""))
            throw new IllegalArgumentException("nome piatto vuoto");

        if (!(tipo.equals("primo") || tipo.equals("secondo")))
            throw new IllegalArgumentException("tipo piatto non riconosxiuto");

        if (costo <= 0)
            throw new IllegalArgumentException("costo minore di zero");

        this.nome = nome;
        this.tipo = tipo;
        this.costo = costo;
        assert repOk();
    }

    // METODI
    public String getNome() {
        return this.nome;
    }

    public String getTipo() {
        return this.tipo;
    }

    public int getCosto() {
        return this.costo;
    }

    public Piatto copiaPiatto(int costo) throws IllegalArgumentException {
        if (costo <= 0)
            throw new IllegalArgumentException("non è possibile copiare un piatto con costo <= a 0");
        return new Piatto(this.nome, this.tipo, costo);
    }

    // REPOK
    public boolean repOk() {
        if (nome == null || tipo == null)
            return false;

        if (nome.equals(""))
            return false;

        if (!tipo.equals("primo") || !tipo.equals("secondo"))
            return false;

        if (costo <= 0)
            return false;

        return true;
    }

    // OVERRIDE
    @Override
    public String toString() {
        return this.nome + " " + this.tipo + " " + this.costo + "E";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Piatto other = (Piatto) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (tipo == null) {
            if (other.tipo != null)
                return false;
        } else if (!tipo.equals(other.tipo))
            return false;
        if (costo != other.costo)
            return false;
        return true;
    }

    @Override
    public Object clone() {
        Piatto p = null;
        try {
            p = (Piatto) super.clone();
        } catch (CloneNotSupportedException e) {
            p = new Piatto(nome, tipo, costo);
            // Ha solo parametri non mutabili quindi non ho bisogno di clonare nulla qua
        }
        return p;
    }

}