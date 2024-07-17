package Simulazioni.Esame4Jun;

import java.util.ArrayList;
import java.util.Iterator;

public class Team implements Iterable<Player> {

    public String nome;
    public ArrayList<Player> componenti= new ArrayList<>();

    public Team (String nome) throws IllegalArgumentException {
    //MODIFIES: this
    //EFFECTS: inizializza this
    // lancia IllegalArgumentExcption se nome nullo o vuoto
    if (nome==null || nome.equals(""))
        throw new IllegalArgumentException("nome del team non può essere nullo o vuoto");
    this.nome=nome; 
    }


    public void add (Player p) throws IllegalArgumentException, TeamException{
        //MODIFIES: this
        //EFFECTS: aggiunge p a componenti
        //lancia teamException se ci sono errori
        if (p==null)
            throw new IllegalArgumentException("team nullo");

        if (componenti.size()==5)
            throw new TeamException("ERR: ci sono gia 5 giocatori");

        if (p instanceof Goalie)
            if (countPlayers(Goalie.class)>0)
                throw new TeamException("ERR: portiere esiste già");

        if (p instanceof FieldPlayer)
            if(countPlayers(FieldPlayer.class) > 3)
                throw new TeamException("ERR: troppi Field Players");

        if (componenti.contains(p))    
                throw new TeamException ("giocatore esiste già");

        componenti.add(p.clone());
        
        assert repOk();
    }

    public int countPlayers(){
        return componenti.size();
    }

    public <T> int countPlayers(Class<T> playerClass){
        //REQUIRES: playerClass deve essere Player o sottoclasse
        //EFFECTS: data una classe c conta quanti players della stessa classe ci sono nell'arraylist componenti 
        int i=0;
        for (Player p: componenti){
             if ( playerClass.isInstance(p))
                i++;
        }
           return i;
    }

    public Goalie getGoalie() throws TeamException{
        for (Player p : componenti){
            if (p instanceof Goalie) {
                return (Goalie) p;
            }
        }
        throw new TeamException ("non c'è il portiere");
    }

    public int score (Team t) throws TeamException { 
        //t è quello che gli do, componenti è quello che gli metto prima del punto (quindi un altro team)

        //
        // EFFECTS: restituisce i goal segnati al team t
	    //          lancia IllegalArgumentException se t==null 
	    //          lancia TeamException se t o this non sono completi
    if(t == null)
        throw new IllegalArgumentException("ERR: t null");
    if(t.componenti.size() != 5 || componenti.size() != 5)
        throw new TeamException("ERR: incomplete teams"); 
    
    int s1=0;
    int s2=0; 

    for (Player p : componenti)
        if (p instanceof FieldPlayer)
            s1+=((FieldPlayer) p).getPuntAtt();
    
    for (Player p : t.componenti) 
        if (p instanceof FieldPlayer)
            s2+=((FieldPlayer) p).getPuntDif();
            
    //(s1.a - s2.d) * (1 - s2.p)
    int returnValue=0;
    returnValue=(int) ((s1 - s2) * (1-t.getGoalie().getFrazParate()));

    return returnValue;
}

@Override
public Iterator<Player> iterator() {
    // componenti.sort(null);
    return new Iterator<Player>() {
        Iterator<Player> i = componenti.iterator();
        @Override
        public boolean hasNext() {
            return i.hasNext();
        };
        @Override
        public Player next(){
            return i.next();
        }
    };
}

    @Override
	public String toString() {
		String res = "Squadra: " + nome + "\n";
		for(Player p : this)
			res += "\t" + p + "\n";
		return res;
	}

public boolean repOk(){
    if(nome == null || nome.equals(""))
			return false;

		if(componenti.size() > 5)
			return false;

		if(countPlayers(Goalie.class) > 1)
			return false;

		if(countPlayers(FieldPlayer.class) > 4)
			return false;

		for(Player p : componenti)
			if(componenti.indexOf(p) != componenti.lastIndexOf(p))
				return false;

		return true;
}


}