public class Multiplo {
    public static void main(String[] args) {
        int n1 = Integer.parseInt(args[0]);
        int n2 = Integer.parseInt(args[1]);

        if (n1%n2==0)
            System.out.println(n1+" è multiplo di "+n2);
        else 
            System.out.println(n1+" non è multiplo di "+n2);

   }
}
