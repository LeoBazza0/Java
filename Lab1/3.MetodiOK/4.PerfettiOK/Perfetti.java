public class Perfetti {
    public static void main(String[] args) {
        int n = Integer.parseInt (args[0]);
        if (n==0){
            System.out.println("0 non è perfetto");
            System.exit(0);
        }
        if (perfetto(n)) {
            System.out.println(n+" è perfetto");
        }
        else {
        System.out.println(n+" non è perfetto");
        }
    }

    public static int sommaDivisoriPropri(int n){
        int tot =0;
        for (int i=1; i<n; i++) {
            if (n%i == 0) {
                tot+=i;
            }
        }
        return tot;
    }

    public static boolean perfetto(int n){
        return sommaDivisoriPropri(n)==n;
    }
}
