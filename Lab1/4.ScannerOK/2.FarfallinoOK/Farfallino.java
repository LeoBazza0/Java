import java.util.Scanner;

public class Farfallino {
    public static void main(String[] args) {
        String testo = "";
        System.out.println("Inserisci un testo su piu' righe (termina con Ctrl+D)");
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            testo += s.nextLine() + " ";
        }
        System.out.println("Risultato:");
        System.out.print(convertiInFarfallino(testo));
    }

    private static String convertiInFarfallino (String testo) {
        char[] vocaliMinu = { 'a', 'e', 'i', 'o', 'u'};
        char[] vocaliMaiu = {'A', 'E', 'I', 'O', 'U'};
        for (char vocale : vocaliMinu) { // foreach = tipo un for range 
            testo = testo.replace("" + vocale, vocale + "f" + vocale); //"" perché replace vuole string e string 
        }
        for (char vocale : vocaliMaiu) {
            testo = testo.replace("" + vocale, vocale + "F" + vocale);
        }
        return testo; 
    }

    
}
