import java.time.format.DateTimeParseException;
import java.time.DateTimeException;

public class FormatoOra {
    public static void main(String[] args) {
        try {
            System.out.println(converti(args[0]));
        } catch (DateTimeException e) {
            System.out.println(e.getMessage());
        }
    }

    public static String converti(String ora24) throws DateTimeException {
        String[] ores = new String[2];
        ores = ora24.split(":");

        if (ores.length != 2 || ores[0].length() != 2 || ores[1].length() != 2) {
            throw new DateTimeException("Formato ora non valido ");
        }

        try {
            int hh = Integer.parseInt(ores[0]);
        } catch (NumberFormatException e) {
            throw new DateTimeException("ore non valide");
        }
        try {
            int mm = Integer.parseInt(ores[1]);
        } catch (NumberFormatException e) {
            throw new DateTimeException("minuti non validi");
        }
        int hh = Integer.parseInt(ores[0]);
        int mm = Integer.parseInt(ores[1]);

        if (hh >= 24 || mm >= 60 || hh < 0 || mm < 0) {
            throw new DateTimeException("Formato ora non valido ");
        }

        if (hh < 12) {
            return hh + ":" + ores[1] + " AM";
        } else { // 13, 14, 15, ... 24
            return (hh - 12) + ":" + ores[1] + " PM";
        }

    }
}
