import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public abstract class Film {

    // ATTRIBUTI
    int id;
    String titolo;
    double penaleGiornaliera;
    LocalDate dataNoleggio;

    // COSTRUTTORI
    public Film(int id, String titolo) throws IllegalArgumentException {
        if (titolo == null || titolo.equals(""))
            throw new IllegalArgumentException("nome film nullo");
        this.id = id;
        this.titolo = titolo;
        this.penaleGiornaliera = 2.00;

        assert repOk();
    }

    // METODI
    public double calcolaPenaleRitardo() {
        LocalDate today = LocalDate.now();
        LocalDate ScadenzaNoleggio = dataNoleggio.plusDays(7);

        if (ScadenzaNoleggio.isBefore(today))
            return penaleGiornaliera * ScadenzaNoleggio.until(today, ChronoUnit.DAYS);
        return 0;
    }

    public LocalDate getDataNoleggio() {
        return dataNoleggio;
    }

    public void setDataNoleggio(LocalDate dataNoleggio) throws NullPointerException {
        if (dataNoleggio == null || dataNoleggio.equals(""))
            throw new NullPointerException("Data noleggio nulla");
        this.dataNoleggio = dataNoleggio;
        assert repOk();

    }

    public double getPenaleGiornaliera() {
        return penaleGiornaliera;
    }

    public void setPenaleGiornaliera(double penaleGiornaliera) throws IllegalArgumentException {
        if (penaleGiornaliera < 0)
            throw new IllegalArgumentException("penale giornaliera negativa");
        this.penaleGiornaliera = penaleGiornaliera;
        assert repOk();
    }

    // REPOK
    public boolean repOk() {
        if (titolo == null || titolo.equals(""))
            return false;
        if (dataNoleggio == null || dataNoleggio.equals(""))
            return false;
        return true;
    }

    // OVERRIDE
    @Override
    public String toString() {
        return "Film " + titolo + " noleggiato il " + dataNoleggio.toString();
    }
    // ITERATORI

}
