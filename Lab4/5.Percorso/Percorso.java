import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Percorso {

    // ATTRIBUTI
    ArrayList<Punto> punti;

    // COSTRUTTORI
    public Percorso() {
        new ArrayList<>();
        assert repOk();
    }

    // MAIN
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        Percorso percorso = new Percorso();

        System.out.println("Inserisci le coordinate di un punto per riga nel formato <x y> (termina con CTRL+D)");
        System.out.println("ATTENZIONE: Inserire valori decimali utilizzando la virgola e non il punto");

        while (s.hasNext()) {
            try {
                percorso.addPunto(new Punto(s.nextDouble(), s.nextDouble()));
            } catch (NullPointerException e) {
                System.out.println(e.getMessage());
            } catch (NoSuchElementException | IllegalStateException e) {
                System.out.println("Input errato. Punto non inserito");
            }
        }

        for (int i = 0; i < percorso.getSize() - 1; i++) {
            System.out.println("Tratto " + (i + 1) + ": distanza " + percorso.distanzaTraPunti(i, i + 1));
        }

        System.out.println("Totale: " + percorso.distanzaTot());

    }

    /*
     * Tratto 1: distanza 2
     * Tratto 2: distanza 2.236
     * Tratto 3: distanza 2.236
     * Tratto 4: distanza 0.5
     * Totale: 6.972
     */
    // METODI
    public void addPunto(Punto p) throws NullPointerException {
        if (p == null)
            throw new NullPointerException("punto nullo non valido");
        punti.add(p);
        assert repOk();
    }

    public void removePunto() throws IllegalArgumentException {
        if (this.punti.size() == 0) {
            throw new IllegalArgumentException("il percorso è gia vuoto");
        }
        punti.remove(punti.size() - 1);
    }

    public double distanzaTraPunti(int i, int j) throws IllegalArgumentException {
        // i e j sono gli indici dell'arraylist
        double totDist = 0;
        if (i < 0 || j < 0 || i > punti.size() || j > punti.size() || i > j)
            throw new IllegalArgumentException("parametri inseriti non validi");
        for (int k = i; k < j; k++) {
            totDist += punti.get(k).distanza(punti.get(k + 1));
        }
        return totDist;
    }

    public double distanzaTot() {
        return distanzaTraPunti(0, punti.size() - 1);

    }

    public int getSize() {
        return punti.size(); // MA CHE CAZZO DI SENSO HA? NEL SENSO, FUNZIONA MA PERCHE NON FUNZIONEREBBE
                             // ALTRIMENTI??
    }

    // REPOK
    public boolean repOk() {
        if (punti == null)
            return false;
        return true;
    }
    // OVERRIDE
    // non ci servono
}
