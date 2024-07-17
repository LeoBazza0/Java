import java.util.ArrayList;
import java.util.Iterator;

public class Percorso implements Iterable<Tratta> {

    // ATRIBUTI
    ArrayList<Tratta> tratte = new ArrayList<>();

    // COSTRUTTORI
    public Percorso() {
    }

    public Percorso(Percorso p) throws NullPointerException, TrattaNonValidaException {
        for (Tratta tratta : p) {
            this.add(tratta);
        }
    }

    // METODI
    public void add(Tratta t) throws TrattaNonValidaException, NullPointerException {
        if (t == null)
            throw new NullPointerException("tratta nulla");
        if (!tratte.isEmpty() && !tratte.get(tratte.size() - 1).getDestinazione().equals(t.getOrigine()))
            throw new TrattaNonValidaException("Tratta non continua il percorso");

        tratte.add(t);

        assert repOk();
    }

    public double getDurata() {
        double durataTot = 0;
        for (Tratta tratta : this) {
            durataTot += tratta.getDurata();
        }
        return durataTot;
    }

    public double getCO2() {
        return tratte.stream().mapToDouble(Tratta::getCO2).sum();
    }

    public ArrayList<Tratta> sort() {
        ArrayList<Tratta> SortedTratte = new ArrayList<>(tratte);
        SortedTratte.sort(null);
        return SortedTratte;
    }

    // REPOK
    public boolean repOk() {
        if (tratte == null)
            return false;

        for (int i = 0; i < tratte.size(); i++) {
            if (tratte.get(i) == null)
                return false;
            if (i != 0 && !tratte.get(i - 1).getDestinazione().equals(tratte.get(i).getOrigine()))
                return false;
        }

        return true;
    }

    // OVERRIDE
    @Override
    public String toString() {
        String res = "Percorso (durata: " + getDurata() + ", co2: " + getCO2() + ")\n";
        for (Tratta tratta : this) {
            res += "\t" + tratta + "\n";
        }
        return res;
    }

    @Override
    public Iterator<Tratta> iterator() {
        return new Iterator<Tratta>() {

            Iterator<Tratta> i = tratte.iterator();

            @Override
            public boolean hasNext() {
                return i.hasNext();
            }

            @Override
            public Tratta next() {
                return i.next();
            }
        };
    }
}
