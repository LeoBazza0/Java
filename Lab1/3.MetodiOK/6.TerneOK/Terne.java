public class Terne {
    public static void main(String[] args) {
        int soglia = Integer.parseInt(args[0]);
        if (soglia<0){
            System.out.println("Inserire un numero > di 0");
            System.exit(0);
        }
        System.out.println("Terne pitagoriche:");
        ternePitagoriche(soglia);
    }

    public static boolean ternaPitagorica(int a, int b, int c){
        return c*c==a*a+b*b;
    }

    public static void ternePitagoriche(int soglia){
        for (int a=1; a<soglia; a++){
            for (int b=a; b<soglia; b++){
                for (int c=b; c<soglia; c++){
                    if (ternaPitagorica(a, b, c)) {
                        System.out.printf("(%d, %d, %d)\n", a, b, c);
                    }
                }
            }
        }
    }
}
