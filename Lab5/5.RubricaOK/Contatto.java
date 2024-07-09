import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Iterator;

public class Contatto {
    // OVERVIEW: classe contatto che tiene contiene il nome, il cognome, i numeri di
    // telefono e gli indirizzi email della persona

    // ATTRIBUTI
    String nome, cognome;
    ArrayList<String> numeri;
    ArrayList<String> emails;

    // COSTRUTTORI
    public Contatto(String nome, String cognome) throws NoSuchElementException, IllegalArgumentException {
        if (nome == null || cognome == null || nome.equals("") || cognome.equals(""))
            throw new IllegalArgumentException("elemento inserito non valido");
        this.nome = nome;
        this.cognome = cognome;
        this.emails = new ArrayList<>();
        this.numeri = new ArrayList<>();
    }

    // METODI
    public String getNome() {
        return this.nome;
    }

    public String getCognome() {
        return this.cognome;
    }

    public Contatto copiaContatto(String nome, String congome) {
        if (nome == null || nome.equals(""))
            throw new IllegalArgumentException("Non sono ammessi campi vuoti o nulli");
        if (cognome == null || cognome.equals(""))
            throw new IllegalArgumentException("Non sono ammessi campi vuoti o nulli");
        Contatto c = new Contatto(nome, cognome);
        for (String numero : numeri) {
            c.addNumero(numero);
        }
        for (String email : emails) {
            c.addEmail(email);
        }
        return c;

    }

    public void addEmail(String email) throws IllegalArgumentException {
        if (email == null || email.equals(""))
            throw new IllegalArgumentException("Non sono ammessi campi vuoti o nulli");
        this.emails.add(email);
        assert repOk();
    }

    public void deleteEmail(String email) throws IllegalArgumentException {
        if (email == null || email.equals(""))
            throw new IllegalArgumentException("Non sono ammessi campi vuoti o nulli");
        this.emails.remove(email);
        assert repOk();
    }

    public void addNumero(String numero) throws IllegalArgumentException {
        if (numero == null || numero.equals(""))
            throw new IllegalArgumentException("Non sono ammessi campi vuoti o nulli");
        this.numeri.add(numero);
        assert repOk();
    }

    public void deleteNumero(String numero) throws IllegalArgumentException {
        if (numero == null || numero.equals(""))
            throw new IllegalArgumentException("Non sono ammessi campi vuoti o nulli");
        this.numeri.remove(numero);
        assert repOk();

    }

    // REPOK
    private boolean repOk() {
        if (nome == null || nome.equals(""))
            return false;
        if (cognome == null || cognome.equals(""))
            return false;
        if (numeri == null)
            return false;
        for (String numero : numeri) {
            if (numero == null)
                return false;
        }
        if (emails == null)
            return false;
        for (String email : emails) {
            if (email == null)
                return false;
        }
        return true;
    }

    // OVERRIDE
    @Override
    public String toString() {
        String res = nome + " " + cognome;
        if (numeri.size() != 0) {
            res += "\n\ttel: ";
            for (String numero : numeri) {
                res += numero + " ";
            }
        }
        if (emails.size() != 0) {
            res += "\n\te-mail: ";
            for (String email : emails) {
                res += email + " ";
            }
        }
        return res;
    }

    // ITERATORI
    public Iterator<String> iteratorNumeri() {
        return new Iterator<String>() {
            Iterator<String> i = numeri.iterator();

            @Override
            public boolean hasNext() {
                return i.hasNext();
            }

            @Override
            public String next() {
                return i.next();
            }

        };
    }

    public Iterator<String> iteratorEmail() {
        return new Iterator<String>() {
            Iterator<String> k = emails.iterator();

            @Override
            public boolean hasNext() {
                return k.hasNext();
            }

            @Override
            public String next() {
                return k.next();
            }
        };
    }
}
