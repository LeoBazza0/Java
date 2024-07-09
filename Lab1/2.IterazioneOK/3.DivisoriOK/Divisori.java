public class Divisori {
    public static void main(String[] args) {
        int num = Integer.parseInt(args[0]);
        System.out.print("Divisori di "+num+": ");
        for (int i=1; i<num; i++) {
            if (num%i == 0) {
                System.out.print(i+" ");
            }
        }
    }
}
