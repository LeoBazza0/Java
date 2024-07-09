public abstract class Solido implements Comparable<Solido> {

    // ATTRIBUTI
    String tipo;

    // COSTRUTTORI
    public Solido(String tipo) throws NullPointerException, IllegalArgumentException {
        if (tipo == null)
            throw new NullPointerException("tipo null");
        if (tipo.equals(""))
            throw new IllegalArgumentException("tipo vuoto");
        this.tipo=tipo;
    }

    // METODI
    public String tipo() {
        return this.tipo;
    }

    public abstract double volume(); 

    // REPOK

    // OVERRIDE
    @Override
    public int compareTo(Solido s) {
        if (this.volume() < s.volume())
            return -1;
        if (this.volume() == s.volume())
            return 0;
        return 1; // if (this.volume() > s.volume())
    }

}
