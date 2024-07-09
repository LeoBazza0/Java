import java.util.InputMismatchException;
import java.util.Scanner;

public class SvolgiCalcolo {

    public static void main(String[] args) {
        CalcolatriceConMemoria c = null; 

        if (args.length ==0 )
            c = new CalcolatriceConMemoria();
        else {
            try{
                c = new CalcolatriceConMemoria(Double.parseDouble(args[0])); 
            } catch (Exception e) {
                c = new CalcolatriceConMemoria();  
            }   
        }   
        System.out.println("Calcolatrice inizializzata con " + c.getMem());


        Scanner s = new Scanner (System.in);

        printHead();
        while (s.hasNext()) {
            String firstParam = s.next();

            if (firstParam.equals("=")) {
                System.out.println("Risultao: "+c.getMem());
                break; //termina lettura
            } 

            double secondParam = s.nextDouble();
            try {
                System.out.println("Risultato: "+ c.operate(firstParam.charAt(0), secondParam));
    //            c.operate(firstParam.charAt(0), secondParam); 
            } catch (DivideByZeroException e) {
                System.out.println(e.getMessage());
                printHead();
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
                printHead();
            }

        }

    }

    public static void printHead() {
        System.out.println("Inserisci <operatore> <operando>. es: + 3");
        System.out.println("Per terminare inserire il carattere '='.");
    }
}
