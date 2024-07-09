import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Massimo<E extends Comparable<E>> { // DEVO RICONTROLLARE QUESTA PARTE QUA AIUTO - - - DATO CHE C'E
                                                // COMPARABLE MICA DEVO FARE UN OVERRIDE DI COMPARETO ?     
    // OVERVIEW: classe che modella il massimo di un insieme di oggetti generici,
    // comparabili

    // ATTRIBUTI
    private E max;
    private Comparator<? super E> comparator; // DA QUANDO C'E UN TIPO COMPARATOR?!?!?!

    // COSTRUTTORI
    public Massimo() {
        // MODIFIES: this
        // EFFECTS: inizializza un nuovo Massimo con valore null
        // e criterio di confronto default
        max = null;
        comparator = null;
    }

    public Massimo(Comparator<? super E> comparator) {
        // MODIFIES: this
        // EFFECTS: inizializza un nuovo Massimo con valore null
        // e criterio di confronto comparator
        max = null;
        this.comparator = comparator;
    }

    // MAIN
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Massimo<String> maxLessicografico = new Massimo<>();
        Massimo<String> maxLength = new Massimo<>(
                new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        return Integer.compare(o1.length(), o2.length());
                    }
                });

        System.out.println("Inserisci Stringhe (CTRL+D per terminare)");

        while (s.hasNext()) {
            String in = s.next();
            maxLessicografico.insert(in);
            maxLength.insert(in);
        }

        System.out.println("Massimo (lessicografico): " + maxLessicografico.getMax());
        System.out.println("Massimo (lunghezza): " + maxLength.getMax());

    }

    // METODI
    public E getMax() {
        return max;
    }

    public void insert(E element) throws NullPointerException {
        // MODIFIES: this
        // EFFECTS: imposta E come massimo, qualora sia maggiore (secondo il criterio
        // stabilito) del massimo corrente
        // lancia NullPointerException se element è nullo
        if (element == null)
            throw new NullPointerException("Element nullo");
        if (max == null)
            max = element;
        if ((comparator == null && element.compareTo(max) > 0)) // QUESTO COMPARATOR, CHE ALTRI VALORI POTREBBE AVERE
                                                                // ALTRIMENTI?
            max = element;
        if (comparator != null && comparator.compare(element, max) > 0)
            max = element;
    }

    // REPOK
    // Niente repok perché non ha rappresentazioni non ammesse

    // OVERRIDE
    @Override
    public String toString() {
        return "Massimo: " + max;
    }

}