package Simulazioni.Esame4Jun;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        String s1= args[0];
        String s2= args[1];
        int r1=0;
        int r2=0;
        Team[] teams= new Team[2];
        Scanner s= new Scanner(System.in);
        ArrayList<Player> giocatori = new ArrayList<>();

        for (int i=0; i<2; i++){
            teams[i]= new Team(args[i]);
            System.out.printf("Inserisci i giocatori della squadra: %s\n\tportiere,<numero>,<frazione parate>,<nome>\n\tgiocatore,<numero>,<attacco>,<difesa>,<nome>\n",args[i]); 

            while(teams[i].countPlayers()<5){
                String[] line = s.nextLine().split(",");
                try {
                    switch (line[0]) {
                        case "giocatore":
                        teams[i].add(new FieldPlayer(Integer.parseInt(line[2]), Integer.parseInt(line[3]), line[4], Integer.parseInt(line[1])));
                            break;
                        case "portiere":
                        teams[i].add(new Goalie(line[3], Integer.parseInt(line[1]), Double.parseDouble(line[2])));
                            break;
                        default:
                            break;
                    }
                } catch (IllegalArgumentException | TeamException e) {
                    System.out.println("\t"+e.getMessage());
                }
            }
        }

        System.out.println(teams[0] + "\n" + teams[1]);

        try {
            System.out.printf("Risultato: %d : %d", teams[0].score(teams[1]), teams[1].score(teams[2]));
        } catch (TeamException e) {
            System.out.println(e.getMessage());
        }
    }
}
