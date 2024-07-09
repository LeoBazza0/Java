import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public final class Evento {
    // OVERVIEW: classe che modelli un evento di un calendario, definito da una data
    // specificata e dal suo nome
    // modelliamo il dato che i...

    private final String nome; // cosi le rendo immutabili
    private final Date data; // cosi le rendo immutabili

    // COSTRUTTORE
    public Evento(Date data, String nome) throws IllegalArgumentException {
        // MODIFIES: this
        // EFFECTS: inizializza un evento con data e nome secificata
        // se il nome è vuoto o la data o il nome sono null lancia una
        // IllegalArgumentException
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

    // MAIN
    public static void main(String[] args) {
        Scanner tastiera = new Scanner(System.in);
        System.out.println("Inserisci la data del primo evento: ");

        String[] stringData1 = tastiera.next().split("/");
        int giorno1 = Integer.parseInt(stringData1[0]);
        int mese1 = Integer.parseInt(stringData1[1]) - 1;
        int anno1 = Integer.parseInt(stringData1[2]) - 1900;
        System.out.println("Inserisci il nome del primo evento: ");
        String nomeEvento1 = tastiera.next();

        Date dataEvento1 = new Date(anno1, mese1, giorno1);
        Evento Evento1 = new Evento(dataEvento1, nomeEvento1);
        // Evento1.getData().setDate(2);

        System.out.println(Evento1);

        System.out.println("Inserisci la data del secondo evento: ");
        String[] stringData2 = tastiera.next().split("/");
        int giorno2 = Integer.parseInt(stringData2[0]);
        int mese2 = Integer.parseInt(stringData2[1]) - 1;
        int anno2 = Integer.parseInt(stringData2[2]) - 1900;

        System.out.println("Inserisci il nome del secondo evento: ");
        String nomeEvento2 = tastiera.next();
        Date dataEvento2 = new Date(anno2, mese2, giorno2);
        Evento Evento2 = new Evento(dataEvento2, nomeEvento2);

        System.out.println(Evento2);

        if (Evento1.equals(Evento2)) {
            System.out.println("I due eventi sono uguali");
        }

        Evento promemoria = Evento1.copiaEvento(2);

        System.out.println("il promemoria è: " + promemoria);
    }

    // METODI
    public String getNome() {
        return this.nome;
    }

    public Date getData() {
        return (Date) (this.data.clone());
    }

    public Evento copiaEvento(int offset) {
        // EFFECTS: restituisce un evento nuovo a distanza di offset giorni
        Date newdata = new Date(this.data.getTime() + TimeUnit.DAYS.toMillis(offset));
        return new Evento(newdata, this.nome);
    }

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
    public boolean equals(Object o) {
        // quando riscrivo un metodo che è gia esistente devo fare le specifiche uguali
        // identiche
        // a quelle di quello gia esistente, altrimento sto semplicemente affancandoil
        // metodo e
        // non "sovrascrivendo"
        if (o == null)
            return false;
        if (!(o instanceof Evento))
            return false;
        Evento tmpEvento = (Evento) o;
        if (this.data.equals(tmpEvento.data) && this.nome.equals(tmpEvento.nome))
            return true;

        return false;
    }

}