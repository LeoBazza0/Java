public class Persona {

    // ATTRIBUTI
    String nome;

    // COSTRUTTORI
    public Persona(String nome) throws IllegalArgumentException {
        if (nome == null || nome.equals(""))
            throw new IllegalArgumentException("nome non valido");
        this.nome = nome;
    }

    // MAIN

    // METODI
    public String getNome() throws NullPointerException {
        return this.nome;
    }

    // REPOK
    public boolean repOk() {
        if (nome == null)
            return false;
        if (nome.equals(""))
            return false;

        return true;
    }

    // OVERRIDE
    @Override
    public String toString() {
        return "Persona di nome " + nome;
    }
    // ITERATORI
}
// ||