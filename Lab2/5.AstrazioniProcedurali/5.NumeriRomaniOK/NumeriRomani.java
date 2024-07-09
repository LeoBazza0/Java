import java.util.HashMap;
import java.util.Map;

public class NumeriRomani {
    // I->1 ; V->5 ; X->10 ; L->50 ; C->100 ; D->500 ; M->1000
    public static void main(String[] args) {
        int n = roman2dec(args[0]);
        if (n>=0){
            System.out.println(n);
        } else {
            int dec = Integer.parseInt(args[0]);
            System.out.println(dec2roman(dec));
        }
    }

    public static String dec2roman (int n) {
        // REQUIRES: n è positivo e < di 4000 (0-3999)
        // EFFECTS: prende un intero n e restituisce il numero romano in stringa 

        int curr = n; 
        String res="";
        String[] romanvalues = {"M","CD", "D","CD", "C","XC", "L","XL", "X","IX", "V","IV", "I"}; 
        int[] decavalues = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        for (int i=0; i<decavalues.length; i++){
            while (curr-decavalues[i]>=0) {
                curr-=decavalues[i];
                res+=romanvalues[i];
            }
        }
        return res;
    }

    public static int roman2dec (String n){
        // REQUIRES: deve essere un numero romano valido 
        // EFFECTS: prende un numero romano in string e restituisce il suo numero int 

        int res = 0; 
        Map <String, Integer> mappa = new HashMap <String, Integer>();
        mappa.put("I", 1);
        mappa.put("IV", 4);
        mappa.put("V", 5);
        mappa.put("IX", 9);
        mappa.put("X", 10);
        mappa.put("XL",40);
        mappa.put("L", 50);
        mappa.put("XC", 90);
        mappa.put("C", 100);
        mappa.put("CD", 400);
        mappa.put("D", 500);
        mappa.put("CM", 900);
        mappa.put("M", 1000);
        int i = 0; 
        while (i < n.length())
            if (i < n.length()-1 && mappa.get(n.substring(i,i+2)) != null ){
                res+=mappa.get(n.substring(i,i+2)); 
                i+=2; 
            } else if ( mappa.get(n.substring(i,i+1))  != null ) {
                res+=mappa.get(n.substring(i,i+1)); 
                i++; 
            } else {
                return -1;
            }
            return res; 
    }


}
