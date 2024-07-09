public class Cerchio {
    public static void main(String[] args) {
        double raggio = Double.parseDouble(args[0]);
        System.out.println("Area del cerchio: "+ CalcolaArea(raggio));
        System.out.println("Circonferenza del cerchio: "+ CalcolaCirconferenza(raggio));
    }
    public static double CalcolaArea(double raggio) {
        return Math.PI * raggio * raggio;
    }

    public static double CalcolaCirconferenza(double raggio) {
        return 2*Math.PI*raggio; 
    }
}

