import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    // MAIN
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println(
                "Inserisci un prodotto nel formato: `<nome> <costo> alimentare <datascadenza>` oppure `<nome> <costo> nondeperibile riciclabile\\nonriciclabile`");
        while (s.hasNext()) {
            Prodotto p = null;
            String[] in = s.nextLine().split(" ");
            String nomeProdotto = in[0];
            double prezzoOriginale = Double.parseDouble(in[1]);

            switch (in[2]) {
                case "alimentare":
                    String[] dataSplit = in[3].split("-");
                    LocalDate dataScadenza = LocalDate.of(Integer.parseInt(dataSplit[2]),
                            Integer.parseInt(dataSplit[1]), Integer.parseInt(dataSplit[0]));
                    p = new ProdottoAlimentare(nomeProdotto, prezzoOriginale, dataScadenza);
                    break;
                case "nondeperibile":
                    boolean riciclabile = in[3].equals("riciclabile");
                    p = new ProdottoNonDeperibile(nomeProdotto, prezzoOriginale, riciclabile);
                    break;
                default:
                    System.out.println("input non corretto, prodotto non riconosciuto");
                    break;
            }
            System.out.println("Prezzo con sconto del " + p.getPercentualeSconto() + "% : " + p.sconto());
        }
    }

}
