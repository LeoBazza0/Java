import java.util.ArrayList;
import java.util.Scanner;

public class Stanza {

    // VARIABILI
    final int capienza;
    int persone;

    // MAIN
    public static void main(String[] args) {
        ArrayList<Stanza> stanze = new ArrayList<>();
        Scanner s = new Scanner(System.in);

        for (String string : args) {
            try {
                int capienza = Integer.parseInt(string);
                stanze.add(new Stanza(capienza));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.exit(1);
            }
        }

        System.out.println("Create " + stanze.size() + " stanze");

        while (s.hasNext()) {
            String[] in = s.nextLine().split(" ");
            try {
                aggiornaStanze(stanze, Integer.parseInt(in[0]), in[1].charAt(0));
            } catch (IllegalArgumentException | StanzaNonEsisteException e) {
                System.out.println(e.getMessage());
            } catch (StanzaGiaPienaException | StanzaVuotaException e) {
                System.out.println(e.getMessage() + " " + Integer.parseInt(in[0]));
            }
        }

        System.out.println("\nNumero totale di persone presenti: " + contaPersone(stanze));

    }

    // COSTRUTTORI
    public Stanza(int capienza) throws IllegalArgumentException {
        if (capienza < 0) {
            throw new IllegalArgumentException("Non è possibile avere una stanza con capienza negativa");
        }
        this.capienza = capienza;
        this.persone = 0;
    }

    // METODI
    public int getNumPersone() {
        return persone;
    }

    public void addPersone() throws StanzaGiaPienaException {
        if (this.capienza == this.persone) {
            throw new StanzaGiaPienaException("Capienza massima raggiunta nella stanza");
        }
        this.persone++;
    }

    public void subPersone() throws StanzaVuotaException {
        if (this.persone == 0) {
            throw new StanzaVuotaException("Nessuno nella stanza");
        }
        this.persone--;
    }

    public static void aggiornaStanze(ArrayList<Stanza> stanze, int NumStanza, char operazione)
            throws IllegalArgumentException, StanzaNonEsisteException, StanzaGiaPienaException, StanzaVuotaException {

        if (stanze == null) {
            throw new IllegalArgumentException("Stanze non può essere un valore nullo");
        }
        if (NumStanza > stanze.size() || NumStanza <= 0) {
            throw new IllegalArgumentException("Stanza " + NumStanza + " non esiste");
        }

        switch (operazione) {
            case '+':
                stanze.get(NumStanza - 1).addPersone();
                break;
            case '-':
                stanze.get(NumStanza - 1).subPersone();
                break;
            default:
                throw new IllegalArgumentException("operazione " + operazione + " non riconosciuta");
        }
    }

    public static int contaPersone(ArrayList<Stanza> stanze) {
        int tot = 0;
        for (int i = 0; i < stanze.size(); i++) {
            tot += stanze.get(i).persone;
        }
        return tot;
    }
}
