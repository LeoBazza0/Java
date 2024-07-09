import java.util.HashMap;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Bag<E> implements Iterable<E> {
    // E perché può variare tra stinghe, int e double
    // Iterable perché produce un iterator

    // OVERVIEW: modella un bag/multiset generico

    // ATTRIBUTI
    HashMap<E, Integer> elems = new HashMap<>();

    // COSTRUTTORI
    // non serve fare un costruttore della mappa perché la posso inizializzare gia
    // quando la dichiaro come attributo
 
    // MAIN
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        if (args[0].equals("String")) {

            Bag<String> b = new Bag<>();
            while (s.hasNext())
                b.insert(s.next());
            System.out.println(b);

        } else if (args[0].equals("Double")) {

            Bag<Double> b = new Bag<>();
            while (s.hasNextDouble())
                b.insert(s.nextDouble());
            System.out.println(b);

        } else if (args[0].equals("Integer")) {

            Bag<Integer> b = new Bag<>();
            while (s.hasNextInt())
                b.insert(s.nextInt());
            System.out.println(b);

        } else { // default
            System.out.println("zio hai sbagliato a scrivere");
        }

    }

    // METODI
    public void insert(E elem) throws NullPointerException {
        // MODIFIES: this
        // EFFECTS: inserisce elem in this; se elem==null lancia NullPointerException
        if (elem == null)
            throw new NullPointerException("elem null");

        Integer currentCount = elems.putIfAbsent(elem, 1);
        if (currentCount != null)
            elems.replace(elem, currentCount + 1);

        assert repOk();
    }

    public E pick() throws NoSuchElementException {
        // EFFECTS: restituisce un elemento della Bag; se bag vuota lancia una
        // NoSuchElementException

        if (this.size() == 0)
            throw new NullPointerException("bag empty");
        return (E) (elems.keySet().toArray())[0];
    }

    public void remove(E elem) throws NullPointerException, NoSuchElementException {
        // MODIFIES: this
        // EFFECTS: rimuove elem da this; se elem non in this lancia
        // NoSuchElementException
        if (this.size() == 0)
            throw new NullPointerException("bag empty");
        if (!(this.contains(elem)))
            throw new NoSuchElementException("elem non presente");

        Integer currentCount = elems.get(elem);
        if (currentCount == 1)
            elems.remove(elem);
        else
            elems.replace(elem, currentCount - 1);
    }

    public boolean contains(E elem) throws NoSuchElementException {
        // EFFECTS: controlla se in this c'è elem, restituisce true o false; se
        // elem==null lancia NullPointerException
        if (elem == null)
            throw new NullPointerException("elem null");
        if (elems.containsKey(elem))
            return true;
        return false;
    }

    public int count(E elem) throws NoSuchElementException {
        // EFFECTS: restituisce il numero di elem in this; se elem==null lancia
        // NullPointerException
        if (elem == null)
            throw new NullPointerException("elem null");
        Integer currentCount = elems.get(elem); 
        if (currentCount == null)
            return 0;
        return currentCount;
    }

    public int size() {
        // EFFECTS: restituisce il numero di elementi totale
        int count = 0;
        for (E elem : elems.keySet()) {
            count += elems.get(elem);
        }
        return count;
    }

    public int sizeUnique() {
        // EFFECTS: restituise il numero di elementi unici
        return elems.size();
    }

    // REPOK
    public boolean repOk() {
        for (E elem : elems.keySet()) {
            if (elem == null)
                return false;
            if (elems.get(elem) <= 0)
                return false;
        }
        return true;
    }

    // OVERRIDE
    @Override
    public String toString() {
        String res = "Bag [ ";
        for (E elem : this)
            res += elem + " ";
        return res + " ]";
    }

    // ITERATORI
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            Iterator<E> keys = elems.keySet().iterator();
            E current = null;
            int currCount = 1;

            @Override
            public boolean hasNext() { // METODO OSSERVAZIONALE
                if (current != null && elems.get(current) > currCount)
                    return true;
                else if (keys.hasNext())
                    return true;
                return false;
            }

            @Override
            public E next() {
                if (!(this.hasNext()))
                    throw new NoSuchElementException("no more elems");
                if (current != null && elems.get(current) > currCount)
                    currCount++;
                else {
                    current = keys.next();
                    currCount = 1;
                }
                return current;
            }
        };
    }

}
