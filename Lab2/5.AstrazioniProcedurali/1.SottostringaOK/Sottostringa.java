public class Sottostringa {

    public static void main(String[] args) {
        if (sottoStringaTotale(args[0], args[1])) {
            System.out.println(args[1] + " è sottostringa di " + args[0]);
        } else {
            System.out.println(args[1] + " non è sottostringa di " + args[0]);
        }
    }

    // parziale
    public static boolean sottoStringa(String testo, String parola) {
        testo = testo.toLowerCase();
        parola = parola.toLowerCase();
        return (testo.contains(parola));
    }

    // totale
    public static boolean sottoStringaTotale(String testo, String parola) {
        if (testo == null || parola == null)
            return false;
        testo = testo.toLowerCase();
        parola = parola.toLowerCase();
        return (testo.contains(parola));
    }
}
