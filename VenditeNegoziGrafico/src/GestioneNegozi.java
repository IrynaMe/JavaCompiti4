
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class GestioneNegozi {
    private ArrayList<Negozi> listaNegozi = new ArrayList<>();
    final int DIVISORE = 100;

    ScrittoreLettore scrittoreLettore = new ScrittoreLettore();

    public void registraVenditeSulFile(Prodotti prodotto, String numNegozio) {
        String testo = "Negozio " + numNegozio + ": " + prodotto.toString();
        try {
            scrittoreLettore.scriviFileWriter("infoNegozi.txt", testo);
        } catch (IOException e) {
            System.out.println("Non possibile scrivere sul file: " + e.getMessage());
        }
    }

    public void stampaTerminaleDalFile() {
        try {
            scrittoreLettore.leggiFileReader("infoNegozi.txt");
        } catch (IOException e) {
            System.out.println("Impossibile leggere il file " + e.getMessage());
        }
    }

    public void stampaCronologica() {
        try {
            scrittoreLettore.leggiFileReaderCronologico();
        } catch (IOException e) {
            System.out.println("Non possibile leggere il file: " + e.getMessage());
        }
    }


    public void aggiungiNegozio(Negozi negozio) {
        listaNegozi.add(negozio);
    }

    public void compraProdotto() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("-----------------------------------------");
        System.out.println("Scrivi il nome del merce");
        String sceltaMerce = scanner.next();
        System.out.println("-----------------------------------------");
        System.out.println("Inserisci l'importo");
        int sceltaImporto = scanner.nextInt();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd 'alle ore:' HH:mm:ss");
        String oreVenduto = LocalDateTime.now().format(formatter);

        Prodotti prodottoVenduto = new Prodotti(sceltaMerce, sceltaImporto, oreVenduto);

        System.out.println("-----------------------------------------");
        System.out.println("Scegli il negozio: inserisci il numero da 1 a 5");
        String sceltaNegozio = scanner.next();
        registraVenditeSulFile(prodottoVenduto, sceltaNegozio);

        switch (sceltaNegozio) {
            case "1":
                listaNegozi.get(0).aggiungiMerci(prodottoVenduto);
                break;
            case "2":
                listaNegozi.get(1).aggiungiMerci(prodottoVenduto);
                break;
            case "3":
                listaNegozi.get(2).aggiungiMerci(prodottoVenduto);
                break;
            case "4":
                listaNegozi.get(3).aggiungiMerci(prodottoVenduto);
                break;
            case "5":
                listaNegozi.get(4).aggiungiMerci(prodottoVenduto);
                break;
            default:
                System.out.println("Scelta operazione errata");
        }
    }


    public void stampaAsterischi() {
        int indice = 1;
        for (Negozi negozio : listaNegozi) {
            System.out.print("Negozio " + indice++ + ": ");
            int numAsterischi = (int) negozio.getImportoTotale() / DIVISORE;
            for (int i = 0; i < numAsterischi; i++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }

}//


