import java.time.LocalDate;

public class Commedia extends Film {

    public Commedia(int id, String titolo, LocalDate dataNoleggio)
            throws IllegalArgumentException, NullPointerException {
        super(id, titolo);
        setDataNoleggio(dataNoleggio);
        setPenaleGiornaliera(2.5);
    }

    @Override
    public String toString() {
        return super.toString().replace("Film", "Commedia");
    }

}
