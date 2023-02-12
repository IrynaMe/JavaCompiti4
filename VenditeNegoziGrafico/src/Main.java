import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("____________ Gestione vendite ____________");

        Negozi negozi1 = new Negozi();
        Negozi negozi2 = new Negozi();
        Negozi negozi3 = new Negozi();
        Negozi negozi4 = new Negozi();
        Negozi negozi5 = new Negozi();


        GestioneNegozi gestioneNegozi = new GestioneNegozi();

        gestioneNegozi.aggiungiNegozio(negozi1);
        gestioneNegozi.aggiungiNegozio(negozi2);
        gestioneNegozi.aggiungiNegozio(negozi3);
        gestioneNegozi.aggiungiNegozio(negozi4);
        gestioneNegozi.aggiungiNegozio(negozi5);

        //menu
        boolean flag = true;

        do {
            System.out.println("-----------------------------------------");
            System.out.println("Inserisci il numero operazione");
            System.out.println("-----------------------------------------");
            System.out.println("1 -> Comprare Prodotto");
            System.out.println("2 -> Stampare grafico Negozi");
            System.out.println("3 -> Stampa info dal file infoNegozi.txt ordinato per Negozi");
            System.out.println("4 -> Stampa info dal file infoNegozi.txt in ordine cronologico");
            System.out.println("0 - Chiudi il programma");
            String scelta = scanner.next();
            switch (scelta) {
                case "1":
                    gestioneNegozi.compraProdotto();
                    break;
                case "2":
                    gestioneNegozi.stampaAsterischi();
                    break;
                case "3":
                    gestioneNegozi.stampaTerminaleDalFile();
                    break;
                case "4":
                    gestioneNegozi.stampaCronologica();
                    break;
                case "0":
                    System.exit(0);
                    System.out.println("Il programma in chiusura");
                    break;
                default:
                    System.out.println("Scelta operazione errata");
            }
        }
        while (flag);


    }//

}//