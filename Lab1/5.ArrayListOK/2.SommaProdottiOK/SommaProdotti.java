import java.util.ArrayList;
import java.util.Arrays;

public class SommaProdotti {
    public static void main(String[] args) {
     //   String linea = ""; 
        ArrayList<Integer> n = new ArrayList<Integer>() ; 

       // String[] ArrNumStr = linea.split(" "); 
        String[] ArrNumStr = Arrays.copyOfRange(args, 0, args.length);
        for (int i=0; i< ArrNumStr.length; i++){
            int num = Integer.parseInt(ArrNumStr[i]); 
           n.add(num); 
        }
        System.out.println("La somma è: "+calcola(n));
    }

    public static int calcola (ArrayList<Integer> n) {
        int tot =0;
        for (int i=0; i<((n.size())-1); i+=2){ 
            tot+= n.get(i)*n.get(i+1);
        }
        return tot;
    }
}