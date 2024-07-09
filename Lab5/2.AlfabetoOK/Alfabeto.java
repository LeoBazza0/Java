import java.util.Iterator;
import java.util.NoSuchElementException;

public class Alfabeto implements Iterator<Character> {

    // ATTRIBUTI
    char let1, let2, letNow;

    // COSTRUTTORI
    public Alfabeto() {
        let1 = 'a';
        let2 = 'z';
        letNow = let1;
    }

    public Alfabeto(char let1, char let2) throws IllegalArgumentException {
        if (!isValidLetter(let1))
            throw new IllegalArgumentException("il primo carattere non è valido");
        if (!isValidLetter(let2))
            throw new IllegalArgumentException("il secondo carattere non è valido");
        if (let1 > let2)
            throw new IllegalArgumentException("la prima lettera è successiva alla seconda");
        this.let1 = let1;
        this.let2 = let2;
        this.letNow = let1;
        assert repOk();
    }

    // MAIN
    public static void main(String[] args) {
        Alfabeto a = null;
        try {
            a = new Alfabeto(args[0].charAt(0), args[1].charAt(0));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
        while (a.hasNext()) {
            System.out.println(a.next());
        }
    }

    // METODI

    public boolean isValidLetter(char l) {
        if (l < 'a' || l > 'z')
            return false;
        return true;
    }

    // REPOK
    public boolean repOk() {
        if (let1 < 'a' || let1 > 'z')
            return false;
        if (let2 < 'a' || let2 > 'z')
            return false;
        if (letNow < let1 || letNow > let2)
            return false;
        if (let1 > let1)
            return false;
        return true;
    }

    // OVERRIDE
    @Override
    public Character next() throws NoSuchElementException { // <- metodo necessario per fare un iteratore standalone
        if (!hasNext())
            throw new NoSuchElementException("Non ci sono elementi successivi");
        assert repOk();
        return this.letNow++;
    }

    @Override
    public boolean hasNext() { // <- metodo necessario per fare un iteratore standalone
        if (letNow <= let2)
            return true;
        return false;
    }

}
