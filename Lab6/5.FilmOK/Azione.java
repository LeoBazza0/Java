import java.time.LocalDate;

public class Azione extends Film {

    public Azione(int id, String titolo, LocalDate dataNoleggio)
            throws IllegalArgumentException, NullPointerException {
        super(id, titolo);
        setDataNoleggio(dataNoleggio);
        setPenaleGiornaliera(3.0);
    }

    @Override
    public String toString() {
        return super.toString().replace("Film", "Commedia");
    }
}
