import java.util.Scanner;

public class Auto {

    final int capacitaSerbatoio; // così che questo parametro, neanche per sbaglio, non si puo cambiare
    final int velocitaMassima; // così che questo parametro, neanche per sbaglio, non si puo cambiare
    int velocitaCorrente;
    final double consumoMedio; // così che questo parametro, neanche per sbaglio, non si puo cambiare

    public static void main(String[] args) {

        int capacitaSerbatoio = 0, velocitaMassima = 0, consumoMedio = 0;
        Scanner s = new Scanner(System.in);
        double distanzaTotale = 0, kmDaFare = 0;
        double tempoNecessarioInOre = 0;

        try {
            capacitaSerbatoio = Integer.parseInt(args[0]);
            velocitaMassima = Integer.parseInt(args[1]);
            consumoMedio = Integer.parseInt(args[2]);
        } catch (NumberFormatException e) {
            System.out.println("formato sbagliato numeri da riga di comando");
        }
        Auto macchina = new Auto(capacitaSerbatoio, velocitaMassima, consumoMedio);

        System.out.println("Inserisci una tratta (<L. riforniti> <km da fare> <velocità>)");
        while (s.hasNext()) {
            double litri = s.nextDouble();
            double km = s.nextDouble();
            int velocita = s.nextInt();

            try {
                macchina.riempiSerbatoio(litri);
                tempoNecessarioInOre = macchina.viaggia(km, velocita);
                System.out.println("Tempo necessario: " + convertiInOreMinuti(tempoNecessarioInOre));

                distanzaTotale += km;

            } catch (IllegalArgumentException | CarburanteInsufficienteException e) {
                System.out.println(e.getMessage());
            }

            System.out.println("Ti rimangono " + macchina.getLitriInSerbatoio() + "L di carburante");
            System.out.println("Inserisci una tratta (<L. riforniti> <km da fare> <velocita'>)");

        }

        System.out.println("\nHai percorso " + distanzaTotale + " km totali");

    }

    // COSTRUTTORI
    public Auto(int capacitaSerbatoio, int velocitaMassima, double consumoMedio) throws IllegalArgumentException {
        if (capacitaSerbatoio <= 0 || velocitaMassima <= 0 || consumoMedio <= 0) {
            throw new IllegalArgumentException("elemento inserito da riga di comando è minore o uguale a zero");
        }
        this.capacitaSerbatoio = capacitaSerbatoio;
        this.velocitaMassima = velocitaMassima;
        this.consumoMedio = consumoMedio;
    }

    // METODI
    public void riempiSerbatoio(double litri) throws IllegalArgumentException {
        if (litri < 0) {
            throw new IllegalArgumentException("non si possono inserire litri negativi");
        }
        this.litriInSerbatoio += litri;
    }

    public double viaggia(double km, int velocita)
            throws IllegalArgumentException, CarburanteInsufficienteException {
        if (km < 0)
            throw new IllegalArgumentException("Non puoi percorrere distanza negativa");
        if (velocita <= 0)
            throw new IllegalArgumentException("Non puoi andare a velocita' negativa o nulla");

        double litriConsumati = km / this.consumoMedio;
        consumaLitri(litriConsumati);

        try {
            setVelocitaCorrente(velocita);
        } catch (VelocitaMassimaSuperataException e) {
            this.velocitaCorrente = this.velocitaMassima;
        }

        return km / this.velocitaCorrente; // tempo impiegato
    }

    public double getLitriInSerbatoio() {
        return litriInSerbatoio;
    }

    public static String convertiInOreMinuti(double tempo) throws IllegalArgumentException {
        if (tempo < 0) {
            throw new IllegalArgumentException("non puoi impiegarci un tempo negativo");
        }

        int ore = (int) tempo;
        int minuti = (int) ((tempo - (double) ore) * 60);
        return ore + " ore e " + minuti + " minuti";

    }

    public void consumaLitri(double litri) throws IllegalArgumentException, CarburanteInsufficienteException {
        if (litri < 0)
            throw new IllegalArgumentException("Impossibile consumare un numero negativo di litri");

        if (this.litriInSerbatoio - litri < 0)
            throw new CarburanteInsufficienteException("Non hai carburante sufficiente");

        this.litriInSerbatoio -= litri;

    }

    public void setVelocitaCorrente(int velocitaCorrente)
            throws IllegalArgumentException, VelocitaMassimaSuperataException {
        if (velocitaCorrente <= 0) {
            throw new IllegalArgumentException("Non puoi andare a velocita' negativa o nulla");
        }
        if (velocitaCorrente >= this.velocitaMassima) {
            throw new VelocitaMassimaSuperataException(
                    "L'auto non va cosi' veloce. velocita' limitata a " + this.velocitaMassima + "km/h");
        }
        this.velocitaCorrente = velocitaCorrente;

    }
}
