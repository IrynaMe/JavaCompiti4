import java.util.ArrayList;

public class Negozi {
    private ArrayList<Prodotti> listaMerciVenduti = new ArrayList<>();
    private float importoTotale = 0;


    public void aggiungiMerci(Prodotti prodotto) {
        listaMerciVenduti.add(prodotto);
    }

   public float getImportoTotale() {
        for (Prodotti elemento : listaMerciVenduti) {
            importoTotale += elemento.getPrezzo();
        }
        return importoTotale;
    }

}//


