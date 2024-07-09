import java.util.ArrayList;
import java.util.Scanner;

public class Armageddon {
    int distanza;
    int peso;

    public static void main(String[] args) {
        double valoreSoglia = 0;
        Scanner s = new Scanner(System.in);
        // double massa = 0;
        // double distanza = 0;
        ArrayList<Asteroide> asteroidi = new ArrayList<>();

        if (args.length != 1) {
            System.out.println("inserire un numero da riga di comando");
        }

        try {
            valoreSoglia = Double.parseDouble(args[0]);
        } catch (NumberFormatException e) {
            System.out.println("numero da riga di comando in formato errato");
        }

        while (s.hasNext()) {
            double massa = s.nextDouble();
            double distanza = s.nextDouble();
            asteroidi.add(new Asteroide(massa, distanza));
        }

        for (Asteroide asteroide : asteroidi) {
            if (asteroide.getForzaGravitazionale() > valoreSoglia) {
                System.out.println(toStringAsteroidePericoloso(asteroide));
            }
        }
    }

    public static String toStringAsteroidePericoloso(Asteroide a) {
        // EFFECTS: ritorna una stringa corrispondente alla descrizione di a, segnalando
        // che e' pericoloso
        return a.toString().replace("Asteroide", "Asteroide pericoloso");
    }

}
