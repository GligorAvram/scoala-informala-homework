package ro.week5;

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
