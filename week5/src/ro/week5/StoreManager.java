package ro.week5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StoreManager {
    private Map<String, List<SalesRecord>> sellRecords = new HashMap<String, List<SalesRecord>>();
    public List<Product> stock = new ArrayList<>();
    private int id = 0;

    public void addToStock(Product p, int quantity) {
        if (stock.indexOf(p) != -1) {
            stock.get(stock.indexOf(p)).setStock(quantity);
        } else {
            p.setId(id);
            id++;
            stock.add(p);
            p.setStock(quantity);
        }
    }

    public void displayStock() {
        for (int i = 0; i < stock.size(); i++) {
            System.out.println(stock.get(i));
        }
    }

    public void sellProducts(int index, int quantity, String date) {
        for (int i = 0; i < stock.size(); i++) {
            if (stock.get(i).getID() == index) {
                if (stock.get(i).getStock() - quantity >= 0) {
                    SalesRecord s = new SalesRecord(stock.get(i).getID(), quantity);
                    recordSale(date, s);
                    stock.get(i).setStock(-quantity);
                } else {
                    System.out.println("sale did not go through, check the quantities of your order");
                }
            }
        }
    }

    private void recordSale(String date, SalesRecord s) {
        if (sellRecords.containsKey(date)) {
            if (sellRecords.get(date) == null) {
                List<SalesRecord> l = new ArrayList<>();
                l.add(s);
                sellRecords.put(date, l);
            } else {
                sellRecords.get(date).add(s);
            }
        } else if (!sellRecords.containsKey((date))) {
            List<SalesRecord> dailySales = new ArrayList<>();
            dailySales.add(s);
            sellRecords.put(date, dailySales);
        }
    }

    public void getRecordsList() {
        for (String key :
                sellRecords.keySet()) {
            System.out.println(key);
        }
    }

    public void getSalesRecord(String date) {
        if (sellRecords.containsKey(date)) {
            for (SalesRecord s : sellRecords.get(date)
            ) {
                System.out.println(s.toString());
            }
        }
    }

    public Product getProdFromList(int index) {
        return stock.get(index);
    }
}
