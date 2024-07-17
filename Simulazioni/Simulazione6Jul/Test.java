import java.util.Arrays;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        String nomeOperatore = args[0];
        Operatore o = new Operatore(nomeOperatore);
        Scanner s = new Scanner(System.in);
        try {
            while (s.hasNext()) {
                String[] in = s.nextLine().split(" ");
                switch (in[1]) {
                    case "add":
                        if (in[2] == "Prepagata")
                            o.add(new UtenzaPrepagata(in[0], getFullName(Arrays.copyOfRange(in, 3, in.length))));
                        else if (in[2].startsWith("Soglia")) {
                            int i = Integer.parseInt(in[2].split("-")[1]);
                            o.add(new UtenzaSoglia(in[0], getFullName(Arrays.copyOfRange(in, 3, in.length)), i));
                        } else
                            System.out.println("Tipo di Utenza non riconosciuto");
                        break;
                    case "load":
                        if (o.getByNumber(in[0]).getClass() == UtenzaPrepagata.class)
                            ((UtenzaPrepagata) o.getByNumber(in[0])).ricarica(Integer.parseInt(in[2]));
                        else
                            System.out.println("Tipo di Utenza non valido per l'operazione di ricarica");
                        System.exit(0);
                        break;
                    case "call":
                        o.getByNumber(in[0]).chiama(Integer.parseInt(in[2]));
                        break;
                    case "reset":
                        if (o.getByNumber(in[0]).getClass() == UtenzaSoglia.class)
                            ((UtenzaSoglia) o.getByNumber(in[0])).reset();
                        else
                            System.out.println("Tipo di Utenza non valido per l'operazione di reset");
                        System.exit(0);
                        break;

                    default:
                        System.out.println("comando non riconosciuto");
                        break;
                }
            }
        } catch (IndexOutOfBoundsException | NumberFormatException e) {
            System.out.println("Input non valido");
        } catch (NullPointerException | IllegalArgumentException | UtenzaNonValidaException
                | TempoEsauritoException e) {
            System.out.println(e.getClass() + ": " + e.getMessage());
        }
    }

    private static String getFullName(String[] nomi) {
        // REQUIRES: nomi not null and nomi.length >= 1
        // EFFECTS: ritorna nomi concatenati da spazi
        String nome = "";
        for (String string : nomi) {
            nome += string + " ";
        }
        return nome;
    }

}
