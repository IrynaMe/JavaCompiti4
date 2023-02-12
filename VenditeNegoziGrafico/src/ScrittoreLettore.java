import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ScrittoreLettore {

    //scrittore
    public void scriviFileWriter(String path, String testo) throws IOException {
        //gestiamo creazione del Oggetto di tipo File se non esiste
        File dati = new File(path);
        dati.createNewFile();
        FileWriter fileWriter =  new FileWriter(dati,true);
        fileWriter.write(testo);
        fileWriter.flush();
        fileWriter.close();
    }

    //lettore
    public void leggiFileReader(String path) throws IOException {
        List<String> lista = new ArrayList<>();
        File file = new File("infoNegozi.txt");
        FileReader lettore = new FileReader(file);
        String codice = "";
        int indice = lettore.read();
        while (indice != -1) {
            if (indice != '\n') {
                char letto = (char) indice;
                codice = codice + letto;
            }
            if (indice == '\n') {
                lista.add(codice);
                codice = "";
            }
            indice = lettore.read();
        }
        Collections.sort(lista);
        System.out.println("____________ Lista delle vendite ordinata per Negozi ____________");
        for (String elementi : lista) {
            System.out.println(elementi);
        }
        lettore.close();
    }

    public void leggiFileReaderCronologico() throws IOException {
        File dati = new File("infoNegozi.txt");
        FileReader fileReader = null;
        fileReader = new FileReader(dati);
        char[] testo = new char[2000];
        fileReader.read(testo);
        int dimensione = testo.length;
        System.out.println("_____________ Lista delle vendite in modo cronologico _____________");
        for (int i = 0; i < dimensione; i++) {
            if (testo[i] != '\u0000') {
                System.out.print(testo[i]);
            }
        }
        fileReader.close();
    }


}//