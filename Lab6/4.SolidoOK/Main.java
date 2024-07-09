import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Inserisci il raggio di una sfera");
        double raggioSfera = s.nextDouble();
        Sfera sfera = new Sfera(raggioSfera);
        System.out.println("Inserisci il raggio e l'altezza di un cono");
        double raggioCono = s.nextDouble();
        double altezzaCono = s.nextDouble();
        Cono cono = new Cono(raggioCono, altezzaCono);
        switch (sfera.compareTo(cono)) {
            case -1:
                System.out.println("La sfera ha un volume minore del cono");
                break;
            case 0:
                System.out.println("La sfera ha lo stesso volume del cono");
                break;
            case 1:
                System.out.println("La sfera ha un volume maggiore del cono");
                break;
            default:
                break;
        }
    }
}
