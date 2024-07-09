public class Primi {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        if (n<=0){
            System.out.println("La soglia inserita non è positiva");
        } 
        else {
            System.out.println("Numeri primi inferiori a "+n);
            for (int i=n; i>0; i-- ){
                if (isPrimo(i)) {
                    System.out.print    (i+" ");
                }
            }
        }
    }
    public static boolean isPrimo (int n) {
        for (int i =2; i<n; i++){
            if (n%i==0){
                return false;
            } 
        }
    return true;
    }
}
