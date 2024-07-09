import java.util.Scanner;

public class Orario {

    // ATTRIBUTI
    int ore = 0;
    int minuti = 0;

    // MAIN
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Orario orario = null;

        try {
            String[] time = args[0].split(":");
            if (args.length == 1) {
                orario = new Orario(
                        Integer.parseInt(time[0]),
                        Integer.parseInt(time[1]));
            } else {
                orario = new Orario(
                        Integer.parseInt(time[0]),
                        Integer.parseInt(time[1]),
                        args[1].equals("PM"));
            }
        } catch (IndexOutOfBoundsException | NumberFormatException e) {
            orario = new Orario();
        }
        System.out.println("Orario: " + orario.getOra24());
        System.out.println("Orario: " + orario.getOra12());

        try {
            s.hasNext();
            String line = s.nextLine();
            String[] lineSplit = line.split(" ");
            int ore = Integer.parseInt(lineSplit[1]);
            int minuti = Integer.parseInt(lineSplit[2]);
            orario.avanza(ore, minuti);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Orario: " + orario.getOra24());
        System.out.println("Orario: " + orario.getOra12());
    }

    // COSTRUTTORI
    public Orario() {
        this.ore = 0;
        this.minuti = 0;
    }

    public Orario(int ore, int minuti) throws IllegalArgumentException {
        if (ore < 0 || ore >= 24)
            throw new IllegalArgumentException("Valore non valido per ore (1-24)");
        if (minuti < 0 || minuti >= 60)
            throw new IllegalArgumentException("Valore non valido per minuti (0-59)");
        this.ore = ore;
        this.minuti = minuti;

        assert repOk();
    }

    public Orario(int ore, int minuti, boolean PM) {
        if (ore < 1 || ore > 12)
            throw new IllegalArgumentException("Valore non valido per ore (1-12)");

        if (minuti < 0 || minuti >= 60)
            throw new IllegalArgumentException("Valore non valido per minuti (0-59)");
        this.ore = convertiOra12to24(ore, PM);
        this.minuti = minuti;
        assert repOk();
    }

    // METODI
    public int getOre() {
        return this.ore;
    }

    public int getMinuti() {
        return this.minuti;
    }

    public void avanza(int ore, int minuti) throws IllegalArgumentException {
        if (ore < 0 || minuti < 0) {
            throw new IllegalArgumentException("Non si possono inserire ore o minuti negativi");
        }
        this.ore = (this.ore + ore) % 24;
        this.minuti += minuti;
        if (this.minuti >= 60) {
            this.ore += (this.minuti / 60);
            this.minuti = this.minuti % 60;
        }
        assert repOk();
    }

    public String getOra24() {
        return this.toString();
    }

    public String getOra12() {
        int ore = convertiOra24to12(this.ore);
        String suf = (this.ore >= 12) ? "PM" : "AM"; // IF SOLO SU UNA RIGA, SE (...) ALLORA "1" : ALTRIMENTI "2"
        return String.format("%02d:%02d %s", ore, minuti, suf); // FORMAT è TIPO UN SPRINTF GIUSTO?
    }

    public int convertiOra12to24(int ore, boolean PM) throws IllegalArgumentException {
        if (ore < 0 || ore > 23)
            throw new IllegalArgumentException("Valore non valido per ore (0-23)");
        if (ore == 12 && !PM)
            return 0;
        if (ore == 12 && PM)
            return 12;
        if (ore <= 12 && !PM)
            return ore;
        return ore + 12;
        // AM false; PM true
    }

    public int convertiOra24to12(int ore) throws IllegalArgumentException {
        if (ore < 0 || ore > 23)
            throw new IllegalArgumentException("Valore non valido per ore (0-23)");
        if (ore == 12)
            return 12;
        if (ore <= 12)
            return ore;
        return ore - 12;
    }

    // REPOK
    public boolean repOk() {
        if (ore < 0 || ore > 23)
            return false;

        if (minuti < 0 || minuti > 59)
            return false;

        return true;

    }

    // OVERRIDE

    @Override
    public String toString() {
        return String.format("%02d:%02d", ore, minuti);
        // return ore + ":" + minuti;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Orario other = (Orario) obj;
        if (ore != other.ore)
            return false;
        if (minuti != other.minuti)
            return false;
        return true;
    }
}
