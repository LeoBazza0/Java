import java.io.PrintStream;
import java.util.Scanner;

public class Tris {

    // ATTRIBUTI
    int turnoMossa = 0;
    static char[][] tabellone;
    static char turnoPlayer;
    final char CERCHIO = 'O';
    final char EX = 'X';
    final char NADA = 0;

    // COSTRUTTORI
    public Tris() {
        tabellone = new char[3][3];
        turnoPlayer = CERCHIO;
        assert repOk();
    }

    // MAIN
    public static void main(String[] args) {
        Tris tris;
        Scanner s = new Scanner(System.in);
        boolean giocaAncora = true;

        while (giocaAncora) {
            tris = new Tris();
            System.out.println(tris.toString());

            while (!tris.terminato()) {
                System.out.println("mossa di " + tris.turno());
                System.out.println("Inserisci: x y");
                try {
                    tris.mossa(s.nextInt(), s.nextInt());
                    System.out.println(tris.toString() + "\n");
                    if (tris.vittoria()) {
                        System.out.println("Ha vinto " + turnoPlayer);
                        break;
                    }
                    tris.CambiaTurno();
                } catch (IllegalArgumentException e) {
                    System.out.println("Mossa non eseguita: " + e.getMessage());
                    System.out.println(tris.toString() + "\n");
                }
            }

            if (tris.terminato())
                System.out.println("partita terminata in pareggio");

            System.out.println("Un'altra partita? (S/s per si)");
            String sino = s.next();
            if (sino != "s" || sino != "S")
                giocaAncora = false;
        }
    }

    // METODI
    public static char turno() {
        return turnoPlayer;
    }

    public char CambiaTurno() {
        if (this.turnoPlayer == EX)
            return this.turnoPlayer = CERCHIO;
        else
            return this.turnoPlayer = EX;
    }

    public void mossa(int x, int y) throws IllegalArgumentException {
        if (x < 1 || x > 3 || y < 1 || x > 3)
            throw new IllegalArgumentException("Coordinate non valide");
        if (tabellone[x - 1][y - 1] != NADA) {
            throw new IllegalArgumentException("Coordinate già occupate");
        }
        tabellone[x - 1][y - 1] = this.turnoPlayer;
        this.turnoMossa++;
        assert repOk();
    }

    public boolean vittoria() {
        for (int i = 0; i < 3; i++) {
            if (sonoUguali(turnoPlayer, tabellone[i][0], tabellone[i][1], tabellone[i][2]))
                return true;
            if (sonoUguali(turnoPlayer, tabellone[0][i], tabellone[1][i], tabellone[2][i]))
                return true;
        }
        if (sonoUguali(turnoPlayer, tabellone[0][0], tabellone[1][1], tabellone[2][2]))
            return true;
        if (sonoUguali(turnoPlayer, tabellone[0][2], tabellone[1][1], tabellone[2][0]))
            return true;
        return false;
    }

    public boolean terminato() {
        return (turnoMossa >= 9);
    }

    public boolean sonoUguali(char a, char b, char c, char d) {
        return a == b && b == c && c == d;
    }

    // REPOK
    public boolean repOk() {
        if (turnoMossa > 9 || turnoMossa < 0)
            return false;
        if (turnoPlayer != CERCHIO && turnoPlayer != EX)
            return false;
        if (tabellone == null)
            return false;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tabellone[i][j] != NADA && tabellone[i][j] != CERCHIO && tabellone[i][j] != EX) {
                    return false;
                }
            }
        }
        return true;
    }

    // OVERRIDE

    @Override
    public String toString() {
        return String.format(
                "-----------------/ì\n|X\\Y| 1 | 2 | 3 |\n-----------------\n| 1 | %c | %c | %c |\n-----------------\n| 2 | %c | %c | %c |\n-----------------\n| 3 | %c | %c | %c |\n-----------------",
                tabellone[0][0], tabellone[0][1], tabellone[0][2], tabellone[1][0], tabellone[1][1], tabellone[1][2],
                tabellone[2][0], tabellone[2][1], tabellone[2][2]);
    }

}
