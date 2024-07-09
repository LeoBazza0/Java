import java.util.Scanner;
import java.util.ArrayList;

public class Punto {

    // VARIABILI GLOBALI
    double x, y;

    // MAIN
    public static void main(String[] args) {
        Scanner s = new Scanner((System.in));
        ArrayList<Punto> punti = new ArrayList<Punto>();
        Punto p1 = null, p2 = null;
        double distanzaMax = 0;

        System.out.println("Inserire i punti (<x> <y>)");
        System.out.println("Terminare la lettura con CTRL+D");

        while (s.hasNext()) {
            String input = s.nextLine();

            String[] splitIn = input.split(" ");
            try {
                double x = Double.parseDouble(splitIn[0]);
                double y = Double.parseDouble(splitIn[1]);
                punti.add(new Punto(x, y));
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
                System.exit(1);
            }
        }
        for (int i = 0; i < punti.size() - 1; i++) {
            for (int j = i + 1; j < punti.size(); j++) {
                try {
                    double distanza = punti.get(i).distanza(punti.get(j));
                    if (distanza > distanzaMax) {
                        distanzaMax = distanza;
                        p1 = punti.get(i);
                        p2 = punti.get(j);
                    }
                } catch (NullPointerException e) {
                    // In teoria non dovrebbe succedere
                    System.exit(1);
                }
            }
        }
        System.out.println("\nI punti piu' distanti sono:");
        System.out.println(p1);
        System.out.println(p2.toString());

    }

    // COSTRUTTORI
    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Punto(double x) {
        this.x = x;
    }

    public Punto() {
        this.x = 0;
        this.y = 0;
    }

    // METODI
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setXY(double x, double y) {
        setX(x); // this.x = x;
        setY(y); // this.y = y;
    }

    @Override
    public String toString() {
        return "{Punto: " + x + ", " + y + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (getClass() != o.getClass()) // confronta se sono la stesa classe
            return false;
        Punto other = (Punto) o; // do a o ( che era un tipo "Object") il tipo "Punto"
        if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x)) // CONTROLLO SE LA X CON IL DOPPIO DELLE
                                                                            // CIFRE IN DOUBLE è UGUALE AL NUOVO OGGETTO
                                                                            // APPENA CREATO
            return false;
        if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y)) // CONTROLLO SE LA X CON IL DOPPIO DELLE
                                                                            // CIFRE IN DOUBLE è UGUALE AL NUOVO OGGETTO
                                                                            // APPENA CREATO
            return false;
        return true;

    }

    public double distanza(Punto p) throws IllegalArgumentException {
        // ritorna la distanza tra this e p
        // in " double distanza = punti.get(i).distanza(punti.get(j)); " (riga 35) il
        // primo è il this e il secondo è il p
        if (p == null) {
            throw new IllegalArgumentException("Il punto iserito è nullo");
        }
        return Math.sqrt(Math.pow(p.x - this.x, 2) + Math.pow(p.y - this.y, 2));
    }
}