import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        ArrayList<Film> films = new ArrayList<>();
        int i = 0;
        double penaleTotale = 0;

        System.out.println("Inserisci i film noleggiati nel formato `nome tipo data` (CTRL+D per terminare)");
        while (s.hasNextLine()) {
            String[] in = s.nextLine().split(" ");
            String[] campiData = in[2].split("-");
            LocalDate dataNoleggio = LocalDate.of(
                    Integer.parseInt(campiData[2]),
                    Integer.parseInt(campiData[1]),
                    Integer.parseInt(campiData[0]));
            Film f = null;
            switch (in[1]) {
                case "Azione":
                    f = new Azione(i, in[0], dataNoleggio);
                    break;
                case "Commedia":
                    f = new Commedia(i, in[0], dataNoleggio);
                    break;
                case "Dramma":
                    f = new Dramma(i, in[0], dataNoleggio);
                    break;
                default:
                    System.out.println("Categoria non riconosciuta");
                    break;
            }
            films.add(f);
            i++;
        }
        for (Film film : films) {
            penaleTotale += film.calcolaPenaleRitardo();
        }
        System.out.println("Penale totale: " + penaleTotale + "€");
    }
}
