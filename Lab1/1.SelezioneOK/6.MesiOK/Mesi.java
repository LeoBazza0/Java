public class Mesi {
    public static void main(String[] args) {
        String mese = args[0];
        switch (mese) {
            case "novembre" , "aprile",  "giugno", "settembre": 
            System.out.println("il numero di giorni di "+mese+" è 30");
            break;
            case "febbraio": 
            System.out.println("il numero di giorni di "+mese+" è 28");
            break;
            case "gennaio", "marzo", "maggio", "luglio", "agosto", "ottobre", "dicembre":
            System.out.println("il numero di giorni di "+mese+" è 31");
            break;
        }
    }
}

