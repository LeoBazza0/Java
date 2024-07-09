import java.util.Scanner; 
public class MinMaxAvg {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]); 
        Scanner s = new Scanner (System.in); 
        int[] valori = new int[n]; 

        System.out.println("Inserisci i " + n + " numeri:");
        for (int i = 0; i<n; i++) {
            valori[i] = s.nextInt();
        }
    System.out.println("Minimo: " + minimo(valori));
    System.out.println("Massimo: " + massimo(valori));
    System.out.println("Media: " + media(valori));
    }

    public static int minimo(int[] in){
        int min = in[0];
        for (int i =0; i<in.length; i++){
            if (in[i]<min){
                min=in[i];
            }
        }
        return min;
    }

    public static int massimo(int[] in) {
        int max = in[0];
        for (int i =0; i<in.length; i++){
            if (in[i]>max){
                max=in[i];
            }
        }
        return max;
    }

    public static float media(int[] in){
        float tot = 0; 
        for (int i =0; i<in.length; i++){
            tot+=in[i];
        }
        return tot/in.length;
    }
}
