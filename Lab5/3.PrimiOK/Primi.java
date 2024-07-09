import java.util.Iterator;

public class Primi implements Iterator<Integer> {

    // OVERVIEW: prendo un numero n da linea di comando e restituisco i primi n
    // numeri primi

    // ATTRIBUTI
    int curr = 1;

    // COSTRUTTORI
    public Primi() {
        this.curr = 2;
        assert repOk();
    }

    // MAIN
    public static void main(String[] args) {
        // int n = Integer.parseInt(args[0]);
        Primi p = new Primi();
        for (int i = 0; i < Integer.parseInt(args[0]); i++) {
            System.out.println(p.next());
        }
    }

    // METODI
    public static boolean isPrimo(int n) {  
        if (n < 2)
            return false;

        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0)
                return false;
        }
        return true;

    }

    // REPOK
    public boolean repOk() {
        if (curr < 2)
            return false;
        return true;
    }

    // OVERRIDE
    @Override
    public Integer next() {
        while (!isPrimo(this.curr))
            this.curr++;
        assert repOk();
        return this.curr++;
    }

    @Override
    public boolean hasNext() {
        // return (this.count < n);
        return true;
    }
}
