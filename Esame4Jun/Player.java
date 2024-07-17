package Simulazioni.Esame4Jun;
public abstract class Player  { // implements Comparable<Player>{
    
    public String nome;
    public int numeroMaglia;

    //COSTRUTTORE
    public Player (String nome, int numeroMaglia) throws IllegalArgumentException {
        //MODIFIES: this
        //EFFECTS: inizializza this
        // lancia IllegalArgumentException se il nome è null o vuoto o il numero è <0
        if (nome==null || numeroMaglia<0 || nome.equals(""))
            throw new IllegalArgumentException("nome o numero maglia invalidi");
        
        this.nome=nome;
        this.numeroMaglia=numeroMaglia;
    }
    
    //OVERRIDE
    @Override
    public String toString() {
        return "[ " + numeroMaglia + " ] " + nome;
    };
/* 
    @Override
    public int compareTo(Player p) {
        if (p==null)
            throw new NullPointerException("giocatore nullo");
        return Integer.compare(numeroMaglia, p.numeroMaglia);   
    }
*/
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if(!(obj instanceof Player))
			return false;
        if (((Player) obj).numeroMaglia == numeroMaglia)
            return true;
        return false; 
    };

    @Override
    public Player clone() {
        try {
            return (Player) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }

    }
}
