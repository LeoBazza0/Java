public class Punto3D implements Punto {

    // ATTRIBUTI
    final Punto2D p;
    final double z;

    // COSTRUTTORI
    public Punto3D(double x, double y, double z) {
        // MODIFIES: this
        // EFFECTS: inizializza this con x y z

        this.p = new Punto2D(x, y);
        this.z = z;
    }

    // METODI
    public double getX() {
        return p.getX();
    }

    public double getY() {
        return p.getY();
    }

    public double getZ() {
        return z;
    }

    // OVERRIDE
    @Override
    public String toString() {
        return p.toString() + ", z: " + z;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (o == null)
            return false;

        if (!(o instanceof Punto3D))
            return false;

        Punto3D tmp = (Punto3D) o;

        if (this.p != tmp.p)
            return false;

        if (this.z != tmp.z)
            return false;

        return true;
    }
}
