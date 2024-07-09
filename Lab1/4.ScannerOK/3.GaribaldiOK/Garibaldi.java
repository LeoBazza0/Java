import java.util.Scanner;

public class Garibaldi {
    public static void main(String[] args) {
        String testo = "";
        Scanner s = new Scanner (System.in);

        System.out.println("Inserisci un testo su più righe (termina con riga vuota):\n");
        while (s.hasNext()) {
            testo += convertiGaribaldi(s.nextLine())+"\n";
        }
        System.out.println("\\nRisultato trasformazione:");
        System.out.println(testo);
    }

    public static String convertiGaribaldi (String testo) {
        char[] vocali = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'}; 
        for (char vocale : vocali) {
            testo=testo.replace(""+vocale, "u");
        }
        return testo; 
    }
}
