import java.util.ArrayList;

public class Fattoriale {
    public static void main(String[] args) {
        stampaFattoriali(listaFattoriali(Integer.parseInt(args[0])));
    }

    public static int fattoriale(int n) {
        // RETURNS: restituisce il fattoriale del numero `n`
        int sum = 1;
        for (int i = 2; i <= n; i++) {
            sum *= i;
        }
        return sum;

    }

    public static ArrayList<Integer> listaFattoriali(int n) {
        // RETURNS: che restituisce una `List` nella quale, all'indice `0` è memorizzato
        // il fattoriale di `1`, all'indice `1` il fattoriale di `2`, ..., all'indice
        // `n-1` è memorizzato il fattoriale di `n`
        if (n < 0)
            return null;

        ArrayList<Integer> listaFatto = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            listaFatto.add(fattoriale(i));
        }
        return listaFatto;
    }

    public static void stampaFattoriali(ArrayList<Integer> lista) {
        // RETURNS: che stampa la lista dei fattoriali trovata al punto precedente.
        if (lista == null)
            return;
        for (int i = 0; i < lista.size(); i++) {
            System.out.println((i + 1) + ": " + lista.get(i));
        }
    }
}
