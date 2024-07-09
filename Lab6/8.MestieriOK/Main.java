import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        ArrayList<Dipendente> dipendenti = new ArrayList<>();
        int annoRiferimento = 0;

        try {
            annoRiferimento = Integer.parseInt(args[0]);
        } catch (IndexOutOfBoundsException | NumberFormatException e) {
            System.out.println("Parametro da riga di comando mancante o errato");
        }

        System.out.println("Inserisci dipendenti nel formato `nome codice anno salario` (termina con CTRL+D)");

        while (s.hasNext()) {
            if (s.nextLine().length() < 4)
                throw new IndexOutOfBoundsException("problema con l'input");
            try {
                String[] lineSplit = s.nextLine().split(" ");
                String nome = lineSplit[0];
                String id = lineSplit[1];
                int annoAssunzione = Integer.parseInt(lineSplit[2]);
                double retribuzione = Double.parseDouble(lineSplit[3]);
                Dipendente d = new Dipendente(nome, id, retribuzione, annoAssunzione);
                dipendenti.add(d);
            } catch (IndexOutOfBoundsException | NumberFormatException e) {
                System.out.println("Input nel formato non corretto");
            } catch (IllegalArgumentException | NullPointerException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Dipendenti assunti prima del " + annoRiferimento);
        for (Dipendente dipe : dipendenti) {
            if (dipe.getAnno() < annoRiferimento)
                System.out.println(dipe.getNome());
        }
    }
}
