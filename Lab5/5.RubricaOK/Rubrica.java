import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Rubrica implements Iterable {

    // ATTRIBUTI
    HashMap<String, Contatto> contatti;

    // COSTRUTTORI
    public Rubrica() {
        contatti = new HashMap<>();
        assert repOk();
    }
 
    // MAIN
    public static void main(String[] args) {
        Contatto c1 = new Contatto("Joe", "Henry");
        c1.addNumero("5553456");
        c1.addNumero("5134902");
        c1.addEmail("jhenry@bix.net");
        c1.addEmail("j.hen@nis.org");

        Contatto c2 = new Contatto("JimBob", "Johnson");
        c2.addEmail("jbj@email.com");
        c2.addEmail("bjb@gmail.com");

        Contatto c3 = new Contatto("Jack", "Ripper");
        c3.addNumero("3116535");
        c3.addEmail("slice@dice.org");
        c3.addEmail("dice@slice.org");

        Rubrica rubrica = new Rubrica();

        rubrica.addContatto(c1);
        rubrica.addContatto(c2);
        rubrica.addContatto(c3);

        // 1° modo
        System.out.println(rubrica);
        System.out.println("---------------------------");

        // 2° modo
        Iterator<Contatto> contatti = rubrica.iterator();

        while (contatti.hasNext()) {
            System.out.println(contatti.next());
        }
        System.out.println("---------------------------");

        // 3° modo
        // for (Contatto contatto : rubrica) { // BRO?
        // System.out.println(contatto);
        // }
        System.out.println("Mancherebbe il terzon modo però non funziona :( ");
        System.out.println("---------------------------");

    }

    // METODI
    public void addContatto(Contatto c) throws NullPointerException {
        if (c == null)
            throw new NullPointerException("Parametro nullo non valido");
        contatti.put(c.getNome() + " " + c.getCognome(), c); // PUT E' TIPO L'ADD MA PER LE HASHMAP?
        assert repOk();
    }

    public void removeContatto(String nome, String cognome) throws NullPointerException, IllegalArgumentException {
        if (nome == null || cognome == null)
            throw new NullPointerException("Parametri nulli non validi");
        if (nome.equals("") || cognome.equals(""))
            throw new IllegalArgumentException("Parametri vuoti non validi");
        contatti.remove(nome + " " + cognome); // QUINDI FAMMI CAPIRE MI BASTA "ELIMINARE" LA PARTE STRING DI QUESTA
                                               // MAPPA? POSSO FARLO TOGLIENDO ANCHE L'ALTRA PARTE? SE NON FOSSE UNA
                                               // STRINGA MA CON ALTRI PARAMETRI, VALE LO STESSO?
        assert repOk();

    }

    public void modificaContatto(String vecchioNome, String vecchioCognome, String nuovoNome, String nuovoCognome)
            throws IllegalArgumentException {
        if (vecchioNome == null || vecchioNome.equals(""))
            throw new IllegalArgumentException("formato errato del nome vecchio");
        if (vecchioCognome == null || vecchioCognome.equals(""))
            throw new IllegalArgumentException("formato errato del cognome vecchio");
        if (nuovoNome == null || nuovoNome.equals(""))
            throw new IllegalArgumentException("formato errato del nome nuovo");
        if (nuovoCognome == null || nuovoCognome.equals(""))
            throw new IllegalArgumentException("formato errato del cognome nuovo");
        contatti.replace(vecchioNome + " " + vecchioCognome,
                contatti.get(vecchioNome + " " + vecchioCognome).copiaContatto(nuovoNome, nuovoCognome));
        // PERCHE' QUESTA SECONDA PARTE? COSA MI RAPPRESENTA IL GET?
    }

    // REPOK
    public boolean repOk() {
        if (contatti == null)
            return false;
        for (Contatto c : contatti.values()) {
            if (c == null)
                return false;
        }
        return true;
    }

    // OVERRIDE
    @Override
    public String toString() {
        String res = "Rubrica: \n";
        for (Contatto c : contatti.values()) {
            res += "> " + c.toString() + "\n";
        }
        return res;
    }

    // ITERATORI
    @Override
    public Iterator<Contatto> iterator() {
        return new Iterator<Contatto>() {
            Iterator<Contatto> i = contatti.values().iterator();// QUESTO VALUES E' PERCHE' LAVORA SUI VALORI KEY/VALUES
                                                                // DELLA HASHMAP VERO?

            @Override
            public boolean hasNext() {
                return i.hasNext();
            }

            @Override
            public Contatto next() {
                return i.next();
            }
        };
    }

}