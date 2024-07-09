import java.util.InputMismatchException;

public class CalcolatriceConMemoria {
    // OVERVIEW: calcolatrice con uno stato di memoria al quale di possono applicare
    // le operazioni aritmetiche base

    // ATTRIBUTI
    double mem;

    // COSTRUTTORI
    public CalcolatriceConMemoria() {
        // MODIFIES: this
        // EFFECTS: inizializza e restituisce una nuova CalcolatriceConMemoria, con
        // stato = 0
        this.mem = 0;
    }

    public CalcolatriceConMemoria(double mem) {
        // MODIFIES: this
        // EFFECTS: inizializza e restituisce una nuova CalcolatriceConMemoria, con
        // stato = mem
        this.mem = mem;
    }

    // METODI
    public double getMem() {
        return mem;
    }

    public double add(double op2) {
        // MODIFIES: this
        // EFFECTS: mem_post = mem + op2e restituisce il risultato

        this.mem += op2;
        return this.mem;
    }

    public double sub(double op2) {
        // MODIFIES: this
        // EFFECTS: mem_post = mem - op2 e restituisce il risultato

        this.mem -= op2;
        return this.mem;

    }

    public double mul(double op2) {
        // MODIFIES: this
        // EFFECTS: mem_post = mem * op2 e restituisce il risultato

        this.mem *= op2;
        return this.mem;
    }

    public double div(double op2) throws DivideByZeroException {
        // REQUIRES:
        // EFFECTS: imposta mem_post = mem/op2 e restituisce il risultato
        // se op2 == 0 lancia una DivideByZeroException

        if (op2 == 0)
            throw new DivideByZeroException("Non è possibilie dividere per zero");
        this.mem /= op2;
        return this.mem;
    }

    public double operate(char operator, double op2) throws InputMismatchException, DivideByZeroException {
        // MODIFIES: this
        // EFFECTS: imposta mem_post a risultato dell'operazione definita da operator
        // tra mem e op2
        // se operator!= + - * / lancia InputMismatchException
        // se operator== / e op2 == 0 lancia DivideByZeroException

        switch (operator) {
            case '+':
                return this.add(op2);
            case '-':
                return this.sub(op2);
            case '*':
                return this.mul(op2);
            case '/':
                return this.div(op2);
            default:
                throw new InputMismatchException(operator + " != + - * / ");
        }

    }

}
