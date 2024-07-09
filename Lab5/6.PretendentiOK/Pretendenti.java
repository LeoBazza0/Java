import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Pretendenti implements Iterable<Integer> {
    // classe che modella il metodo di seleziona dei pretendenti della principessa

    // ATTRIBUTI
    ArrayList<Integer> pretendenti = new ArrayList<>();

    // MAIN
    public static void main(String[] args) {
        Pretendenti p = new Pretendenti(Integer.parseInt(args[0]));

        Iterator<Integer> i = p.iterator();

        while (i.hasNext()) {
            System.out.println(p);
            System.out.println(i);
            System.out.println("Sto rimuovendo " + i.next());
            i.remove();
        }
        try {
            System.out.println("Ha vinto " + p.getVincitore());
        } catch (PretendentiStillRunningException e) {
            e.printStackTrace();
        }
    }

    // COSTRUTTORI
    public Pretendenti(int n) throws IllegalArgumentException {
        // MODIFIES: this
        // EFFECTS: inizializza this con n pretendenti e if n <= 0 throws
        // IllegalArgumentException
        if (n <= 0) {
            throw new IllegalArgumentException("Serve avere almeno un pretendente");
        }
        for (int i = 1; i <= n; i++) {
            pretendenti.add(i);
        }
        assert repOk(); // TODO: LOL QUESTO CHE SIGNIFICA?
    }

    // METODI
    public int getVincitore() throws PretendentiStillRunningException {
        // metodo di osservazione
        // MODIFIES: X
        // EFFECTS: resitiuisce il vincitore della conta e if !=1 pretendenti rimasti
        // throws PretendentiStillRunningException
        if (pretendenti.size() != 1)
            throw new PretendentiStillRunningException("vincitore possibile solo al termine della conta");

        return this.pretendenti.get(0);
    }

    private boolean repOk() {
        Integer last = null;
        if (pretendenti == null)
            return false;
        if (pretendenti.size() == 0)
            return false;
        for (int pretendente : pretendenti) {
            if (pretendente <= 0)
                return false;
            // if (pretendenti.indexOf(pretendente) != pretendenti.lastIndexOf(pretendente))
            // return false;
            if (last != null && pretendente <= last)
                return false;
            last = pretendente;
        }
        return true;
    }

    // OVERRIDE
    @Override
    public Iterator<Integer> iterator() {
        // EFFECTS: restituisce un Iterator che selezione un nuovo pretendente a
        // distanza 3 dall'ultimo restituito, quando si arriva in coda la conta continua
        // cambiando direzione, stessa cosa quando al ritorno si arriva al primo
        // elemento
        // MODIFIES: può rimuovere l'utlimo elemento selezionato di Pretendenti.this

        return new Iterator<Integer>() {

            int current = 0; //
            boolean dir = true; // true crescente
            boolean removed = true;

            @Override
            public boolean hasNext() {
                return pretendenti.size() > 1;
            }

            @Override
            public Integer next() { // non serve scrivere throws NoSuchElementException perché lo dice gia il padre
                // MODIFIES: this (Iterator)
                // EFFECT: restituisc eil prossimo pretendente aggiorna elemento corrente la
                // direzione e imposta removed a false. Se non ci sono altri pretendenti da
                // rimuovere lancia NoSuchElementExcepiton
                if (!this.hasNext())
                    throw new NoSuchElementException("Non ci son più elementi da eliminare");

                if (this.dir)
                    this.current += 2;
                else
                    this.current -= 2;
                if (this.current >= Pretendenti.this.pretendenti.size() - 1) {
                    this.current = 2 * ((Pretendenti.this.pretendenti.size() - 1)) - this.current;
                    this.dir = false;
                }
                if (this.current <= 0) {
                    this.current = -this.current;
                    this.dir = true;
                }
                removed = false;
                return Pretendenti.this.pretendenti.get(this.current);
            }

            @Override
            public void remove() {
                // MODIFIES: Pretendenti.this, this
                // EFFECTS: rimuove l'ultimo elemento restituito da next(), aggiorna elemento
                // corrente e mette remove... . Se già un elemento è stato rimosso e non è stata
                // chiamata next() lancia IllegalStateException
                if (this.removed)
                    throw new IllegalStateException("elemento gia rimosso");
                Pretendenti.this.pretendenti.remove(this.current);

                if (!dir)
                    current--;
                if (this.current > Pretendenti.this.pretendenti.size() - 1)
                    current--;
                if (this.current == Pretendenti.this.pretendenti.size() - 1)
                    this.dir = false;
                if (this.current == 0)
                    this.dir = true;

                removed = true;
            }

            @Override
            public String toString() {
                if (dir)
                    return "Si conta da " + current + " direzione avanti";
                return "Si conta da " + current + " direzione indietro";

            }
        };
    }

    @Override
    public String toString() {
        String ret = "Pretendenti: [ ";
        for (int pretendente : pretendenti)
            ret += pretendente + " ";
        return ret += "]";
    }

}
