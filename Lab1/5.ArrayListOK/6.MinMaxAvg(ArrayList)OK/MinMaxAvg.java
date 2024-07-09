import java.util.Scanner;
import java.util.ArrayList;

public class MinMaxAvg {
    public static void main(String[] args) {
        Scanner s = new Scanner (System.in); 
        ArrayList<Integer> valori = new ArrayList<Integer>(); 

        System.out.println("Inserisci i numeri (Ctrl+D per terminare): ");
        while (s.hasNext()) {
            valori.add(s.nextInt());
        }
    System.out.println("Minimo: " + minimo(valori));
    System.out.println("Massimo: " + massimo(valori));
    System.out.println("Media: " + media(valori));
    }
    public static int minimo(ArrayList<Integer> in) {
        int min = in.get(0);
        for (int i =0; i<in.size(); i++){
            if (in.get(i)<min){
                min=in.get(i);
            }
        }
        return min;
    }
    public static int massimo(ArrayList<Integer> in) {
        int max = in.get(0);
        for (int i =0; i<in.size(); i++){
            if (in.get(i)>max){
                max=in.get(i);
            }
        }
        return max;
    }
    public static float media(ArrayList<Integer> in) {
        float tot = 0; 
        for (int i =0; i<in.size(); i++){
            tot+=in.get(i);
        }
        return tot/in.size();
    }
}
