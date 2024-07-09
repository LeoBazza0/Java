public class Radice {
    public static void main(String[] args) {
        double n = Double.parseDouble(args[0]);
        if (n<=0) {
            System.out.println("Il valore inserito non appartiene al dominio della funzione");
        } 
        else {
            System.out.println("Radice quadrata: "+ Math.sqrt(n));
        }
    }
}
