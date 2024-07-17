package Simulazioni.Esame4Jun;
public class Goalie extends Player{
    
    public double frazParate;

    public Goalie (String nome, int numeroMaglia, double frazParate) throws IllegalArgumentException {
        //MODIFIES: this
        //EFFECTS: inizializza this
        // lancia illegalargumentExecption se frazione parate non è tra 0 e 1 
        // lancia IllegalArgumentException se il nome è null o vuoto o il numero è <0
        super(nome, numeroMaglia);
        if (frazParate<0 || frazParate>1)
            throw new IllegalArgumentException("frazione goal parati deve essere compreso tra 0 e 1 inclusi");
        this.frazParate=frazParate;
    }

    public double getFrazParate() {
        return frazParate;
    }

    @Override
    public String toString() {
        return super.toString()+" portiere = parate: | " + frazParate + " |";
    }

}
