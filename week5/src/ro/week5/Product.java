package ro.week5;

public abstract class Product implements Cloneable {
    //initialized with bogus values because they don't seem to be used. this can be changed if needed.
    int price = 100, weight = 1;
    String validityDate = "06.06.2006";
    //used for keeping track of the items similar to this one in stock
    private int stock = 0;
    private int id;

    public void setStock(int quantity) {
        int x = stock + quantity;
        if (x < 0) {
            stock = 0;
        } else {
            stock = x;
        }
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getID() {
        return id;
    }

    public int getStock() {
        return stock;
    }
}
