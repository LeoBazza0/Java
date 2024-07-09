public class Palindroma {
    public static void main(String[] args) {
        String parola =args[0];
        int lunghezza = parola.length();

        for (int i=0; i<lunghezza/2; i++) {
            if (parola.charAt(i) != parola.charAt(lunghezza - 1 - i)) {
                System.out.println("Non palindroma");
                System.exit(0);
            } 
        }
        System.out.println("Palindroma");

    }
}
