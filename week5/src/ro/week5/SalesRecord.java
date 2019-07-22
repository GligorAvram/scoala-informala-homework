package ro.week5;

/**
 * Clasa folosita pentru a crea un record despre ceea ce a fost vandut p baza id-ului si cantitatea vanzarii.
 */
public class SalesRecord {
    private int id, quantity;

    public SalesRecord(int id, int quantity) {
        this.id = id;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "SalesRecord{" +
                "id=" + id +
                ", quantity=" + quantity +
                '}';
    }
}
