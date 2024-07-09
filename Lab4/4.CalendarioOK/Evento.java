import java.util.Date;
import java.util.concurrent.TimeUnit;

public final class Evento {

    String nome;
    Date data;

    // COSTRUTTORE
    public Evento(Date data, String nome) throws IllegalArgumentException {
        if (data == null) {
            throw new IllegalArgumentException("data nulla");
        }
        if (nome == null) {
            throw new IllegalArgumentException("nome nullo");
        }
        if (nome == "") {
            throw new IllegalArgumentException("nome vuoto");
        }

        this.nome = nome;
        this.data = (Date) (data.clone());

        assert repOk();
    }

    // METODI
    public String getNome() {
        return this.nome;
    }

    public Date getData() {
        return (Date) (this.data.clone());
    }

    public Evento copiaEvento(int n) throws IllegalArgumentException {
        // EFFECTS: restituisce un evento nuovo a distanza di offset giorni
        if (n <= 0)
            throw new IllegalArgumentException("n <= 0");

        Evento nuovo = (Evento) this.clone();
        Date newdata = new Date(this.data.getTime() + TimeUnit.DAYS.toMillis(n));
        return new Evento(newdata, this.nome);
    }

    // REPOK
    private boolean repOk() {
        if (((this.data != null) && (this.nome != null)) && (this.nome != ""))
            return true;
        return false;
    }

    // OVERRIDE
    @Override
    public String toString() {
        return "Evento: " + this.nome + " in data " + this.data.getDate() + "/" + (this.data.getMonth() + 1) + "/"
                + (this.data.getYear() + 1900);

    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Evento other = (Evento) obj;
        if (data == null) {
            if (other.data != null)
                return false;
        } else if (!data.equals(other.data))
            return false;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        return true;
    }

    @Override
    public Object clone() {
        Evento nuovo = null;
        try {
            nuovo = (Evento) super.clone();
        } catch (CloneNotSupportedException e) {
            nuovo = new Evento(data, nome);
        }
        nuovo.data = (Date) data.clone();
        return nuovo;

    }
}