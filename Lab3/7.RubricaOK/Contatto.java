public class Contatto {

    // VARIABILI
    String nome, cognome;
    String numeroDiTelefono;
    String email;

    // COSTRUTTORI
    public Contatto(String nome, String cognome) throws IllegalArgumentException {
        // EFFECTS: istanzia un nuovo Contatto
        if (nome == null || nome.equals("") || cognome == null || cognome.equals("")) {
            throw new IllegalArgumentException("Non sono ammessi campi vuoti o nulli");
        }
        this.nome = nome;
        this.cognome = cognome;
    }

    public Contatto(String nome, String cognome, String numeroDiTelefono, String email)
            throws IllegalArgumentException {
        // EFFECTS: istanzia un nuovo Contatto
        // ammessi numeroDiTelefono e email nulli o vuoti)
        if (nome == null || nome.equals("") || cognome == null || cognome.equals(""))
            throw new IllegalArgumentException("Non sono ammessi campi vuoti o nulli");
        this.nome = nome;
        this.cognome = cognome;
        this.numeroDiTelefono = numeroDiTelefono;
        this.email = email;
    }

    // METODI
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws IllegalArgumentException {
        if (nome == null || nome.equals(""))
            throw new IllegalArgumentException("Non sono ammessi campi vuoti o nulli");
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) throws IllegalArgumentException {
        if (cognome == null || cognome.equals(""))
            throw new IllegalArgumentException("Non sono ammessi campi vuoti o nulli");
        this.cognome = cognome;
    }

    public String getNumeroDiTelefono() {
        return numeroDiTelefono;
    }

    public void setNumeroDiTelefono(String numeroDiTelefono) {
        this.numeroDiTelefono = numeroDiTelefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return nome + " " + cognome + " " + numeroDiTelefono + " " + email;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Contatto other = (Contatto) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome)) // FUNZIONE RICORSIVA MENTRE LA STO ANCORA SCRIVENDO? EXPLAIN
            return false;
        if (cognome == null) {
            if (other.cognome != null)
                return false;
        } else if (!cognome.equals(other.cognome)) // FUNZIONE RICORSIVA MENTRE LA STO ANCORA SCRIVENDO? EXPLAIN
            return false;
        if (numeroDiTelefono == null) {
            if (other.numeroDiTelefono != null)
                return false;
        } else if (!numeroDiTelefono.equals(other.numeroDiTelefono)) // FUNZIONE RICORSIVA MENTRE LA STO ANCORASCRIVENDO? EXPLAIN
            return false;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email)) // FUNZIONE RICORSIVA MENTRE LA STO ANCORA SCRIVENDO? EXPLAIN
            return false;
        return true;
    }

}
