import java.security.interfaces.EdECKey;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Calendario {

    // ATTRIBUTI
    ArrayList<Evento> eventi;

    // COSTRUTTORE
    public Calendario() {
        eventi = new ArrayList<Evento>();
        assert repOk();
    }

    // MAIN

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Date dataX = null;
        Calendario calendario = new Calendario();

        System.out.println("Inserisci +/-/* NomeEvento gg/mm/aaaa [offset] (termina con CTRL+D)");
        while (s.hasNext()) {
            String[] lineSplit = s.nextLine().split(" ");
            try {
                String[] lineIntDataSplit = lineSplit[1].split("/");
                dataX = new Date(Integer.parseInt(lineIntDataSplit[2]) - 1900,
                        Integer.parseInt(lineIntDataSplit[1]),
                        Integer.parseInt(lineIntDataSplit[0]));
            } catch (NumberFormatException e) {
                System.out.println("Data inserita in formato non valido");
            }

            Evento eventoN = new Evento(dataX, lineSplit[2]);
            try {
                switch (lineSplit[0]) {
                    case "+":
                        calendario.addEvento(lineSplit[2], dataX);
                        break;
                    case "-":
                        calendario.deleteEvento(lineSplit[2], dataX);
                        break;
                    case "*":
                        calendario.changeEvento(new Evento(dataX, lineSplit[2]), Integer.parseInt(lineSplit[3]));

                        break;
                    default:
                        System.out.println("Sintassi di input non valida");
                        break;
                }
            } catch (NumberFormatException | IndexOutOfBoundsException e) {
                System.out.println("Sintassi di input non valida");
            } catch (NullPointerException | EventoGiaEsistenteException | EventoNonEsitenteException
                    | IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

        }
        System.out.println(calendario);
    }

    // METODI

    public void addEvento(String name, Date data) throws NullPointerException, EventoGiaEsistenteException {
        // IN TEORIA FACCIO UN NUOVO EVENTO, FACCIO I VARI IF ELANCIO LE ECCEZIONI, E
        // POI ADD ALL'ARRAYLIST
        if (data == null || name == null)
            throw new NullPointerException("Parametro nullo non valido");
        if (name.equals(""))
            throw new IllegalArgumentException("Nome vuoto non valido");
        Evento e = new Evento(data, name);
        if (eventi.contains(e))
            throw new EventoGiaEsistenteException(name + " esiste già");
        eventi.add(e);
        assert repOk();
    }

    public void deleteEvento(String name, Date data) throws NullPointerException, EventoNonEsitenteException {
        if (data == null || name == null)
            throw new NullPointerException("Parametro nullo non valido");
        if (name.equals(""))
            throw new IllegalArgumentException("Nome vuoto non valido");
        Evento e = new Evento(data, name);
        if (!eventi.remove(e))
            throw new EventoNonEsitenteException("Evento non presente in calendario");

        assert repOk();
    }

    public void changeEvento(Evento e, int n) throws NullPointerException, EventoGiaEsistenteException {
        if (e == null)
            throw new NullPointerException("Evento non può essere nullo");

        eventi.add(e.copiaEvento(n)); // PERCHE' O SIGNUR FAI QUESTO? CHE MI SIGNIFICA?

        assert repOk();

    }

    // OVERRIDE
    public String toString() {
        String res = "Calendario: (\n";
        for (Evento evento : eventi) {
            res += "\t\t" + evento.toString() + "\n";
        }
        return res + ")";
    }

    // REPOK
    public boolean repOk() {
        if (eventi == null)
            return false;
        for (int i = 0; i < eventi.size(); i++) {
            for (int j = i + 1; j < eventi.size(); j++) {
                if (eventi.get(i).equals(eventi.get(j)))
                    return false;
            }
        }
        return true;
    }

}
