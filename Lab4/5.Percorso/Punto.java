public class Punto {

    // ATTRIBUTI
    double x = 0;
    double y = 0;

    // COSTRUTTORI
    public Punto() {
        assert repOk();
    }

    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
        assert repOk();
    }

    // METODI
    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public double distanza(Punto p) throws NullPointerException {
        if (p == null || this == null)
            throw new NullPointerException("Punto nullo");

        return Math.sqrt(Math.pow(p.x - this.x, 2) + Math.pow(p.y - this.y, 2));

    }

    public Punto puntoSpostato(double x, double y) {
        return new Punto(x + this.x, y + this.y);
    }

    // REPOK
    public boolean repOk() {
        // per fare eventuali controlli sulle coordinate ma non mi sembra ce ne siano
        return true;
    }
    // OVERRIDE
}
