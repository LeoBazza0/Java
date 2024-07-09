import java.util.ArrayList;
import java.util.Arrays;

public class SommaUnici {
    public static void main(String[] args) {
        ArrayList<Integer> numeri= new ArrayList<Integer>();
        int sommaUnici = 0;

        String[] n = Arrays.copyOfRange(args, 0, args.length);
        for (int i=0; i< n.length; i++){
            try { 
                numeri.add(Integer.parseInt(n[i])); 
            } catch (Exception e){
                //dovrei scrivere qualcosa ma naaaah non interrombpiamo il flow per ora
            }
        }
        for (Integer Elem : numeri) {
            if (occorrenze(numeri,Elem)==1) {
                sommaUnici+=Elem;
            }
        }
        System.out.println("sommaUnici: " + sommaUnici);
    }



    public static int occorrenze(ArrayList<Integer> numeri, int n){
        int count = 0;
        for (Integer x: numeri) {
            if (x == n) {
                count ++;
            }
        }
        return count;
    }
}
