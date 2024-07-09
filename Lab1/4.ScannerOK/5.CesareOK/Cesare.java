import java.util.Scanner;

public class Cesare {
    public static void main(String[] args) {
        int K =Integer.parseInt(args[0]);
        System.out.println("Inserisci un testo su più righe (termina con CTRL D):");

        String testo = "";
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            testo+=s.nextLine() + "\n"; 
        }
        System.out.println(cifraTesto(testo, K));


    }
    public static String cifraTesto(String s, int chiaveK) {
            String newS = "";
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (isLettera(c))
                    newS += cifraCarattere(s.charAt(i), chiaveK);
                else
                    newS += c;
            }
            return newS;
        }
        
    public static char cifraCarattere(char c, int chiave) {
        int LETTERE_IN_ALFABETO = 26;
        chiave = ((chiave % LETTERE_IN_ALFABETO) + LETTERE_IN_ALFABETO) % LETTERE_IN_ALFABETO; //Questa roba assurda è per convertire le chiavi negative, non proprio la mia miglior invenzione diciamo
        if (isMaiuscola(c))
            return (char) (((int) c + chiave - (int) 'A') % (LETTERE_IN_ALFABETO) + (int) 'A');
        else
            return (char) (((int) c + chiave - (int) 'a') % (LETTERE_IN_ALFABETO) + (int) 'a');
    }


    private static boolean isMaiuscola(char c) {
        return (c >= 'A' && c <= 'Z');
    }

    private static boolean isMinuscola(char c) {
        return (c >= 'a' && c <= 'z');
    }

    private static boolean isLettera(char c) {
        return (isMaiuscola(c) || isMinuscola(c));
    }

}
