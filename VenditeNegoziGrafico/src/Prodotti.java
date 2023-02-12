import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public class Prodotti {
    private String merce;
    private float prezzo;
    String oreVenduto;


    public Prodotti(String nomeMerce, float importo, String oreVenduto) {
        this.merce = nomeMerce;
        this.prezzo = importo;
        this.oreVenduto = oreVenduto;
    }

    @Override
    public String toString() {
        return "merce: " + merce +
                "         prezzo: " + prezzo +
                "         info di Vendita: " + oreVenduto +
                '\n';
    }

    public String getMerce() {
        return merce;
    }

    public float getPrezzo() {
        return prezzo;
    }
}
