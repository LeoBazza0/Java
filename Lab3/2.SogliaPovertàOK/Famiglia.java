import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;

public class Famiglia {

    int dimensione;
    double reddito;

    public static void main(String[] args) {
        double costoCibo = 0, costoCasa = 0;
        ArrayList<Famiglia> arrFam = new ArrayList<Famiglia>();
        Scanner s = new Scanner(System.in);
        int conta = 1;
        int num = 0;

        if (args.length != 2) {
            System.out.println("inserire due parametri da riga di comando");
        }

        try {
            costoCibo = Integer.parseInt(args[0]);
            costoCasa = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            System.out.println("parametri non validi");
        }
        System.out.println(
                "Inserisci il reddito e la dimensione di una famiglia (Ctrl+D per terminare la lettura)");

        while (s.hasNext()) {
            double red = s.nextDouble();
            int dim = s.nextInt();
            try {
                arrFam.add(new Famiglia(red, dim));
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
            }
            System.out.println(
                    "Inserisci il reddito e la dimensione di una famiglia (Ctrl+D per terminare la lettura)");
        }
        for (Famiglia fam : arrFam) {
            try {
                if (fam.sottoSogliaPoverta(costoCasa, costoCibo)) {
                    num++;
                }
            } catch (InputMismatchException e) {
                // l'eventuale messaggio del "costo minore di zero" lo scrivo eventualmente nel
                // prossimo foreach dove devo gia stampare altro
            }
        }

        System.out.println("\n" + num + " famiglie sotto la soglia di povertà:");
        for (Famiglia fam : arrFam) {
            try {
                if (fam.sottoSogliaPoverta(costoCasa, costoCibo)) {
                    System.out.println("Famiglia " + conta + ": " + fam.toString());
                    conta++;
                }
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
            }

        }
    }

    public Famiglia(double reddito, int dimensione) throws InputMismatchException {
        if (dimensione <= 0) {
            throw new InputMismatchException("Non è possibile crare una famiglia con meno di 1 persona");
        }
        this.dimensione = dimensione;
        this.reddito = reddito;
    }

    public boolean sottoSogliaPoverta(double costoCasa, double costoCibo) throws InputMismatchException {

        if (costoCasa < 0)
            throw new InputMismatchException("il costo della casa è minore di zero");
        if (costoCibo < 0)
            throw new InputMismatchException("il costo del cibo è minore di zero");
        return costoCasa + costoCibo * this.dimensione > this.reddito * 0.5;
    }

    @Override
    public String toString() {
        return dimensione + " persone con reddito complessivo di " + reddito;
    }
}
