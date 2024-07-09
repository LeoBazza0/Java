import java.util.Scanner;

public class Inverso {
    public static void main(String[] args) {
        String line3 = "";
        Scanner s = new Scanner(System.in);
        System.out.println(("Inserisci un testo su più righe (termina con riga vuota):"));
        while (s.hasNext()) {
            String line = s.nextLine();
            String[] line2 = line.split("");    
            for (int i = line.length()-1 ; i>=0; i--) {
                line3+=line2[i];
            }
            line3+="\n";
        }
        System.out.println("\nTesto inserito:\n"+line3);
    }
}
