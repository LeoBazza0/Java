import java.util.ArrayList;

import javax.lang.model.element.ModuleElement.DirectiveVisitor;
import javax.management.openmbean.ArrayType;

public class Abbondanti {
    public static void main(String[] args) {
        ArrayList<Integer> divisoriPropri = new ArrayList<>();
        int n = Integer.parseInt(args[0]);
        divisoriPropri = elencoDivisoriPropri(n);
        stampaNumeriAbbondanti(numeriAbbondanti(n));
    }

    public static ArrayList<Integer> elencoDivisoriPropri(int n) {
        // RETURNS: che restituisce una `List` di `Integer` contenente tutti i divisori
        // propri di `n`
        ArrayList<Integer> divisoriPropri = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            if (n % i == 0) {
                divisoriPropri.add(i);
            }
        }
        return divisoriPropri;
    }

    public static int sommaDivisoriPropri(int n) {
        // RETURNS: che restituisce la somma dei divisori propri di `n`. Se `n` non ha
        // divisori propri la funzione restituisce `0`
        int somma = 0;
        ArrayList<Integer> divisoriPropri = new ArrayList<>();

        divisoriPropri = elencoDivisoriPropri(n);
        if (divisoriPropri.size() == 0) {
            return 0;
        } else {
            for (int i = 0; i < divisoriPropri.size(); i++) {
                somma += divisoriPropri.get(i);
            }
        }
        return somma;
    }

    public static boolean abbondante(int n) {
        // RETURNS: che restituisce `true` se `n` è abbondante, `false` altrimenti
        return (sommaDivisoriPropri(n) > n);
    }

    public static ArrayList<Integer> numeriAbbondanti(int limite) {
        // RETURNS: che restituisce tutti i numeri abbondanti inferiori a `limite`
        ArrayList<Integer> numeri = new ArrayList<>();
        for (int i = 0; i < limite; i++) {
            if (abbondante(i)) {
                numeri.add(i);
            }
        }
        return numeri;
    }

    public static void stampaNumeriAbbondanti(ArrayList<Integer> numeri) {
        // RETURNS: che stampa
        System.out.print("Numeri abbondanti: ");

        for (int x : numeri) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}