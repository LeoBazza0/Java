import java.util.InputMismatchException;
import java.util.Scanner;

public class CalcolatriceSequenziale {

    double risultato;

    // COSTRUTTORI
    public CalcolatriceSequenziale() {
        risultato = 0;
    }

    // MAIN
    public static void main(String[] args) {
        CalcolatriceSequenziale cs = new CalcolatriceSequenziale();
        Scanner s = new Scanner(System.in);

        System.out.println("Inserisci <operatore> <operando>. es: + 3");
        System.out.println("Per terminare inserire il carattere '='");
        System.out.println("risultato = " + cs.getRisultato());

        while (true) { // come se fosse un for infinito (sempre vero, finché non si mette break dentro)
            String input = s.nextLine();
            if (input.equals("="))
                break;
            try {
                cs.calculateFromString(input);
                System.out.println("risultato " + input + " = " + cs.getRisultato());
            } catch (NumberFormatException | InputMismatchException | DivisionByZeroException e) {
                System.out.println(e.getMessage());
                System.out.println("risultato = " + cs.getRisultato());
            }
        }

        System.out.println("Il risultato finale e' " + cs.getRisultato());

    }

    // FUNZIONI
    public void calculateFromString(String s)
            throws NumberFormatException, InputMismatchException, DivisionByZeroException {
        if (s == null) {
            throw new NullPointerException("Parametro nullo");
        }

        String[] splitInput = s.split(" ");

        if (splitInput.length != 2)
            throw new InputMismatchException("Non sono stati inseriti tutti gli input richiesti");

        double o2 = 0;
        try {
            o2 = Double.parseDouble(splitInput[1]);
        } catch (NumberFormatException e) {
            throw new InputMismatchException("Operando non valido");
        }

        this.risultato = calculate(this.risultato, splitInput[0].charAt(0), o2);

    }

    public static double calculate(double o1, char op, double o2)
            throws InputMismatchException, DivisionByZeroException {
        switch (op) {
            case '+':
                return o1 + o2;
            case '-':
                return o1 - o2;
            case '*':
                return o1 * o2;
            case '/':
                if (o2 == 0) {
                    throw new DivisionByZeroException("Non e' possibile dividere per 0");
                }
                return o1 / o2;
            default:
                throw new InputMismatchException("Operatore non riconosciuto");
        }
    }

    // METODI
    public double getRisultato() {
        // EFFECTS: returns the current value for risultato
        return this.risultato;
    }
}
