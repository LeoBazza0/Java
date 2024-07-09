import java.util.InputMismatchException;
import java.util.Scanner;

public class Calcolatrice {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Inserisci <operando1> <operatore> <operando2>. es: 4 + 3");
        String input = s.nextLine();

        try {
            System.out.println("Il risultato è " + calculateFromString(input));
        } catch (InputMismatchException | DivisionByZeroException | NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

    public static double calculate(double o1, double o2, char op)
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
                    throw new DivisionByZeroException("Non è possibile dividere per 0");
                } else {
                    return o1 / o2;
                }
            default:
                throw new InputMismatchException("operatore non riconosciuto");
        }
    }

    public static double calculateFromString(String s)
            throws NullPointerException, InputMismatchException, DivisionByZeroException {
        // EFFECTS: returns the result of the expression s
        if (s == null)
            throw new NullPointerException();

        String[] inputs = s.split(" ");

        if (inputs.length != 3)
            throw new InputMismatchException("Non sono stati inseriti tutti gli input richiesti");

        double o1 = 0, o2 = 0;
        try {
            o1 = Double.parseDouble(inputs[0]);
            o2 = Double.parseDouble(inputs[2]);
        } catch (NumberFormatException e) {
            throw new InputMismatchException("Gli operando devono essere numeri reali");
        }

        return calculate(o1, o2, inputs[1].charAt(0));

    }

}

