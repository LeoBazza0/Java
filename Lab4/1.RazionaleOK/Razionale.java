import java.util.InputMismatchException;

public class Razionale {

    // ATTRIBUTI
    public int num;
    public int den;

    // MAIN
    public static void main(String[] args) {
        int num = 0, den = 0;
        try {
            num = Integer.parseInt(args[0]);
            den = Integer.parseInt(args[1]);
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
        try {
            Razionale raz = new Razionale(num, den);
            System.out.println("Il razionale e' " + raz + " o " + raz.valore());
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }

    }

    // COSTRUTTORE
    public Razionale(int num, int den) throws ArithmeticException {
        if (den == 0) {
            throw new ArithmeticException("Denominatore del razionale non può essere zero");
        }
        this.num = num;
        this.den = den;
    }

    // METODI
    public int getNumeratore() {
        return this.num;
    }

    public void setNumeratore(int newNum) {
        this.num = newNum;
        assert repOk();
    }

    public int getDenominatore() {
        return den;
    }

    public void setDenominatore(int newDen) throws ArithmeticException {
        if (newDen == 0)
            throw new ArithmeticException("Il denominatore non può essere uguale a 0");
        this.den = newDen;
        assert repOk();
    }

    public double valore() {
        // EFFECTS: restituisce il rapporto fra il numeratore ed il denominatore
        return (double) this.num / this.den;
    }

    public double getValue() {
        // EFFECTS: restituisce il rapporto fra il numeratore ed il denominatore
        return (double) this.num / this.den;
    }

    public boolean repOk() {
        return (den != 0);
    }

    // OVERRIDE
    @Override
    public String toString() {
        return num + "/" + den;
    }
}
