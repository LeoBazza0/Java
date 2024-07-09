import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TopN {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        System.out.println("Inserisci almeno " + n + " numeri interi diversi tra loro (CTRL+D per terminare):");
        int[] numbers = new int[args.length - 1];
        int[] topNumbers = new int[n];

        numbers = readIntArray();
        topNumbers = highest(numbers, n);
        printArray(topNumbers);
    }

    private static int[] readIntArray() {
        // RETURNS: che legge da **standard input** una serie di almeno `n` numeri
        // interi **diversi tra loro**, fino a quando con `ctrl+D` non viene terminata
        // la lettura
        // ArrayList<Integer> arrayList = new ArrayList<Integer>();
        Set<Integer> array = new HashSet<>(); // Set permette di eliminare le ripetizioni in automatico
        // int i = 0;

        Scanner s = new Scanner(System.in);
        while (s.hasNextInt()) {
            array.add(s.nextInt());
        }
        return array.stream().mapToInt(i -> i).toArray(); // Strano casting da set ad array passando per Stream
    }

    public static int[] highest(int[] numbers, int n) {
        // RETURNS: che calcola e restituisce un array con gli `n` interi più alti tra
        // quelli inseriti a **standard input**
        int[] maxNums = new int[n];
        int max = numbers[0];
        int iMax;
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < numbers.length; i++) {
                if (numbers[i] > max) {
                    max = numbers[i];
                    iMax = i;
                    numbers[iMax] = 0;

                }
            }
            maxNums[j] = max;
            max = 0;

        }
        return maxNums;
    }

    private static void printArray(int[] numbers) {
        // REQUIRES: che stampa a **standard output** l'array ottenuto dalla procedura
        // precedente.
        System.out.print("Numeri più alti: ");
        for (int i = 0; i < (numbers.length); i++) {
            System.out.print(numbers[i]);
        }
        //////////// il bastardo mi stampa "Numeri più alti: [I@14ae5a5" ... perché?

    }
}
