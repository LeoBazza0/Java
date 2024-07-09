import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Matrice implements Iterable<Iterator<Integer>> {
    // ATTRIBUTI
    int[][] matrix;

    // COSTRUTTORI
    public Matrice(int n, int m) throws IllegalArgumentException {
        if (n <= 0 || m <= 0)
            throw new IllegalArgumentException("Valori per righe/colonne matrice non validi");
        matrix = new int[n][m];
        assert repOk();
    }

    // MAIN
    public static void main(String[] args) {
        Matrice matrice = null;
        Scanner s = new Scanner(System.in);

        try {
            matrice = new Matrice(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        } catch (IllegalArgumentException | IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
        for (int i = 0; i < matrice.getRows(); i++) {
            System.out.println(
                    "Inserisci i " + matrice.getCols() + " numeri (separati da spazio) della riga " + (i + 1));
            for (int j = 0; j < matrice.getCols(); j++) {
                matrice.set(i, j, s.nextInt());
            }
        }

        System.out.println("Matrice inserita:");
        System.out.println(matrice);

        // for (Iterator<Integer> riga : matrice) {
        // while (riga.hasNext())
        // System.out.print(riga.next() + " ");
        // System.out.println();
        // }

    }

    // METODI

    public void set(int r, int c, int value) throws IndexOutOfBoundsException {
        if (r > this.matrix.length || c > this.matrix[r].length)
            throw new IndexOutOfBoundsException("numero inserito fuori dal range della matrice");
        matrix[r][c] = value;
        assert repOk();
    }

    public int get(int r, int c) throws IndexOutOfBoundsException {
        if (r > this.matrix.length || c > this.matrix[r].length)
            throw new IndexOutOfBoundsException("numero inserito fuori dal range della matrice");
        return matrix[r][c];
    }

    public int getRows() {
        return matrix.length;
    }

    public int getCols() {
        return matrix[0].length;
    }

    // REPOK
    public boolean repOk() {
        if (matrix == null)
            return false;
        return true;
    }

    // OVERRIDE
    @Override
    public String toString() {
        String res = "";
        for (int[] row : matrix) {
            for (int i : row) {
                res += i + " ";
            }
            res += "\n";
        }
        return res;

    }

    // ITERATORI
    @Override
    public Iterator<Iterator<Integer>> iterator() {
        return new Iterator<Iterator<Integer>>() {
            int currentRow = 0;

            @Override
            public boolean hasNext() {
                return currentRow < matrix.length;
            }

            @Override
            public Iterator<Integer> next() {
                if (!(hasNext()))
                    throw new NoSuchElementException("La matrice non ha ulteriori righe");
                int row = currentRow++;

                return new Iterator<Integer>() {
                    int currentElement = 0;

                    @Override
                    public boolean hasNext() {
                        return currentElement < matrix[row].length;
                    }

                    @Override
                    public Integer next() {
                        if (!hasNext())
                            throw new NoSuchElementException("La riga della matrice non ha ulteriori elementi");
                        return matrix[row][currentElement++];
                    }

                };
            }
        };
    }
}
