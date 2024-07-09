import java.util.Iterator;

public class Fibonacci implements Iterator<Integer> {
    // OVERVIEW: iteratore Standalone per iterare sulla sequenza di Fibonacci
    // -> Standalone quindi ho i metodi next() e hasNext()

    // ATTRIBUTI
    int n1, n2;

    // COSTRUTTORI
    public Fibonacci() {

    }

    // MAIN
    public static void main(String[] args) {
        Fibonacci fibo = new Fibonacci();
        for (int i = 0; i < Integer.parseInt(args[0]); i++) {
            System.out.println(fibo.next());
        }
    }

    // METODI
    public Integer next() {

        if (n1 == 0 && n2 == 0) {
            n1 = 0;
            n2 = 1;
            return n2;
        }
        int nExtra = n2;
        n2 += n1;
        n1 = nExtra;
        return n2;
    }

    public boolean hasNext() {
        return true;
    }

    // REPOK
    public boolean repOk() {
        if (n2 > n1)
            return false;
        return true;
    }

    // OVERRIDE

}
