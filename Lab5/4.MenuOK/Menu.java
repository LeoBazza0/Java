import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Menu implements Iterable<Piatto> {

    // ATTRIBUTI
    ArrayList<Piatto> piatti;

    // COSTRUTTORI
    public Menu() {
        piatti = new ArrayList<>(); // FILO NON METTE IL PRIMO ArrayList<Piatto> , PERCHE'?
        assert repOk();
    }

    // MAIN
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Menu menu = new Menu();

        System.out.println("aggiungi i piatti nel formato: nome tipo costo (terminare la lettura con CTRL+D):");

        while (s.hasNextLine()) {
            String[] in = s.nextLine().split(" ");
            Piatto p = new Piatto(in[0], in[1],
                    Integer.parseInt(in[2].substring(0, in[2].length() - 1)));
            try {
                menu.addPiatto(p);
            } catch (NullPointerException | PiattoGiaInMenuException e) {
                e.printStackTrace();
            }
        }

        Iterator<Piatto> primi = menu.iterator("primo");
        System.out.println("\nPrimi: ");
        while (primi.hasNext()) {
            System.out.println(primi.next());
        }
        Iterator<Piatto> secondi = menu.iterator("secondo");
        System.out.println("\nSecondi: ");
        while (secondi.hasNext()) {
            System.out.println(secondi.next());
        }

    }

    // METODI

    public void addPiatto(Piatto p) throws NullPointerException, PiattoGiaInMenuException { // MA CHE CAZZO DI PROBLEMI
                                                                                            // HAI?
        if (p == null)
            throw new NullPointerException("Piatto nullo non valido");
        if (piatti.contains(p))
            throw new PiattoGiaInMenuException("Il Piatto e' gia' nel menu'");
        piatti.add(p);
        assert repOk();
    }

    public void removePiatto(Piatto p) throws NullPointerException, IllegalArgumentException {
        if (p == null)
            throw new NullPointerException("Piatto nullo non valido");
        if (!(piatti.contains(p)))
            throw new IllegalArgumentException("Il Piatto non c'è nel menu'");
        piatti.remove(p);
        assert repOk();
    }

    public void modificaPiatto(String nome, int costo) throws NullPointerException {
        if (nome == null)
            throw new NullPointerException("Nome nullo non valido");
        for (Piatto piatto : piatti) {
            if (piatto.getNome().equals(nome)) {
                piatti.remove(piatto);
                Piatto newPiatto = piatto.copiaPiatto(costo);
                piatti.add(newPiatto);
            }
        }
        assert repOk();
    }

    // REPOK
    public boolean repOk() {
        if (piatti == null)
            return false;
        for (Piatto piatto : piatti) {
            if (piatto == null)
                return false;
            if (piatti.indexOf(piatto) != piatti.lastIndexOf(piatto))
                return false;
        }
        return true;
    }

    // OVERRIDE

    // ITERATORS
    public Iterator<Piatto> iterator(String tipo) {
        // EFFECTS: restituisce un iterator che scorre la lista dei Piatti, restituendo
        // solo i Piatti del tipo specificato (primo/secondo). Lancia
        // NullPointerException se tipo è nullo lancia IllegalArgumentException se tipo
        // non è primo né secondo
        if (tipo == null)
            throw new IllegalArgumentException("Tipo nullo non valido");
        if (!(tipo.equals("primo") || tipo.equals("secondo")))
            throw new IllegalArgumentException("Tipo non valido (primo/secondo)");

        return new Iterator<Piatto>() {
            int current = 0;

            @Override
            public boolean hasNext() {
                // EFFECTS; verifica se tra gli elementi ancora da scandire della lista ve ne
                // sia almeno uno del tipo scelto
                for (int i = current; i < piatti.size(); i++) {
                    if (piatti.get(i).getTipo().equals(tipo))
                        return true;
                }
                return false;
            }

            @Override
            public Piatto next() {
                // MODIFIES: this (Iterator)
                // EFFECST: restituisce il prossimo piatto della lista che è del tipo
                // specificato. Poi incrementa current di 1 (Attenzione che non è quindi detto
                // che current stia puntando ad un piatto "giusto" [Non so se sia un problema])
                for (int i = current; i < piatti.size(); i++) {
                    if (piatti.get(i).getTipo().equals(tipo)) {
                        current = i + 1;
                        return piatti.get(i);
                    }
                }
                current = piatti.size();
                throw new NoSuchElementException("gli elementi di tipo " + tipo + " sono terminati");
            }
        };
    }

    @Override
    public Iterator<Piatto> iterator() {
        // EFFECTS: restituisce un iterator che scorre tutta la lista di Piatti
        // contenuta nel menù, un Piatto per volta.
        return new Iterator<Piatto>() {

            Iterator<Piatto> i = piatti.iterator();

            @Override
            public boolean hasNext() {
                return i.hasNext();
            }

            @Override
            public Piatto next() {
                return i.next();
            }

        };
    }

}
