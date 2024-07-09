public class Sommaintervallo {
    public static void main(String[] args) {
        int tot = 0;
        int num1 = Integer.parseInt(args[0]);
        int num2 = Integer.parseInt(args[1]);
        for (int i = num1; i<num2; i++) {
            if (i%2==0)
                tot+=i; 
        }
        System.out.println("Somma = "+tot);
    }
}
