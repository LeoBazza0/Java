// NON FUNZIONA AAAAAA

public class Parentesi {
    
    public static void main(String[] args) {
        String parentesi = args[0];
        int counter = 0; 

        for (int i=0; i<parentesi.length(); i++) {
            if(parentesi.charAt(i)== '[') 
                counter++ ;  
            else 
                counter--;
        }
        if (counter != 0) {
                System.out.println("non bilanciata"); 
            }
            else {
                System.out.println ("bilanciata");

            }
    }
} 

