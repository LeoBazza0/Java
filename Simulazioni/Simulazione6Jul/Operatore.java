import java.util.ArrayList;
import java.util.Iterator;

public class Operatore implements Iterable<Utenza> {
    // ATTRIBUTI
    String nome;
    ArrayList<Utenza> utenze = new ArrayList<>();

    // COSTRUTTORI

    public Operatore(String nome) throws NullPointerException, IllegalArgumentException {
        if (nome == null)
            throw new NullPointerException("Nome nullo");
        if (nome.equals(""))
            throw new IllegalArgumentException("Nome vuoto");

        this.nome = nome;
        assert repOk();
    }

    // METODI
    public void add(Utenza u) throws NullPointerException, UtenzaNonValidaException {
        if (u == null)
            throw new NullPointerException("Utenza nulla");
        if (utenze.contains(u))
            throw new UtenzaNonValidaException("Utenza gia esistente");
        utenze.add((Utenza) u.clone());
        assert repOk();
    }

    public Utenza getByNumber(String numero) throws UtenzaNonValidaException {
        for (Utenza utenza : utenze) {
            if (utenza.getNumero().equals(numero))
                return (Utenza) utenza.clone();
        }
        throw new UtenzaNonValidaException("Utenza non presente");
    }

    // REPOK
    public boolean repOk() {
        if (utenze == null)
            return false;
        for (Utenza utenza : utenze) {
            if (utenza == null)
                return false;
            for (Utenza utenza2 : utenze) {
                if (utenza.equals(utenza2))
                    return false;
            }
        }
        return true;

    }

    // OVERRIDE
    @Override
    public String toString() {
        String res =  "Utenze di " + nome + ":\n";  
        for (Utenza utenza : this) {
            res += "\t" + utenza + "\n";
        }
        return res;
    }

    // ITERATORI

    @Override
    public Iterator<Utenza> iterator() {
        return new Iterator<Utenza>() {

            Iterator<Utenza> i = getSortedIterator();

            private Iterator<Utenza> getSortedIterator() {
                ArrayList<Utenza> utenzeOrdinate = new ArrayList<>(utenze);
                utenzeOrdinate.sort(null);
                return utenzeOrdinate.iterator();
            }

            @Override
            public boolean hasNext() {
                return i.hasNext();
            }

            @Override
            public Utenza next() {
                return i.next();
            }

        };

    }

}
