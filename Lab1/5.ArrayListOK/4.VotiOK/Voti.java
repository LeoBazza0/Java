import java.util.Scanner;
import java.util.ArrayList; 

public class Voti {
    public static void main(String[] args) {
        ArrayList<Integer> voti = new ArrayList<Integer>();

        System.out.println("inserisci i voti (senza spazio alla fine):");
       voti = leggiNumeri(); 
        filtraVoti(voti);
    }

    public static void filtraVoti(ArrayList<Integer> l){
        ArrayList<Integer> votiSuff = new ArrayList<Integer>();
        ArrayList<Integer> votiInsuff = new ArrayList<Integer>();

        for (Integer voto : l) {
            if (voto>=60) {
                votiSuff.add(voto);
            } else {
                votiInsuff.add(voto);
            }
        }
        System.out.println("Voti sufficienti: " + votiSuff );
        System.out.println("Voti insufficienti: "+ votiInsuff);
    }

    public static ArrayList<Integer> leggiNumeri() {
    Scanner s = new Scanner(System.in);
        ArrayList<Integer> voti = new ArrayList<Integer>();

        while (s.hasNext()) {
            try {
                voti.add(Integer.parseInt(s.nextLine())); 
            } catch (Exception e) {
                // se arriva qua vuol dire che un elemento in serito non è un numero
            }
        }
    return voti; 
    }
}
