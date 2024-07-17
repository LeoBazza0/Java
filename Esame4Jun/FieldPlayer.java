package Simulazioni.Esame4Jun;
public class FieldPlayer extends Player{

    public double puntAtt;
    public double puntDif;

    public FieldPlayer (double puntAtt, double puntDif, String nome, int numeroMaglia) throws IllegalArgumentException {
        //MODIFIES: this
        //EFFECTS: inizializza this
        //lancia IllegalArgumentException se il punteggio attacco o difesa non sta tra 0 e 10
        // lancia IllegalArgumentException se il nome è null o vuoto o il numero è <0
        super(nome, numeroMaglia);
        if (puntAtt<0 || puntAtt>10 || puntDif<0 || puntDif>10)
            throw new IllegalArgumentException ("punteggio attacco e/o difesa devono essere compresi tra 0 e 10");
        this.puntAtt=puntAtt;
        this.puntDif=puntDif; 
    }

    public double getPuntAtt() {
        return puntAtt;
    }
    
    public double getPuntDif() {
        return puntDif;
    }

    public String toString() {
        return super.toString()+" Field Player = punteggio Attacco: "+ puntAtt + "; punteggio Difesa: " + puntDif;
    };
}
