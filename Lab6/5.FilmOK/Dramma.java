import java.time.LocalDate;

public class Dramma extends Film {

    // COSTRUTTORI SUPER
    public Dramma(int id, String titolo, LocalDate dataNoleggio) throws IllegalArgumentException, NullPointerException {
        super(id, titolo);
        setDataNoleggio(dataNoleggio);
    }

    @Override
    public String toString() {
        return super.toString().replace("Film", "Film Drammatico");
    }
}
