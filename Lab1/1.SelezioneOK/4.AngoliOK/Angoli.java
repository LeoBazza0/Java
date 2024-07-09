public class Angoli {
    public static void main(String[] args) {
        int ang1 = Integer.parseInt(args[0]); 
        int ang2 = Integer.parseInt(args[1]);
        if ((ang1+ang2)<180)
        System.out.println("Ampiezza terzo angolo = "+(180-ang1-ang2));
        else 
        System.out.println("I due angoli non appartengono ad un triangolo");
    }
}
