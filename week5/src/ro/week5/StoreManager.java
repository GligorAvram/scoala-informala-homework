package ro.week5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Clasa care administreaza magazinul. Are metode pentru a adauga si scoate produse din stoc si pentru a afisa stocul
 * si lista de vanzari de-a lungul timpului.
 *
 * @author Gligor Avram
 * @version 1.0.1
 */

public class StoreManager {
    private Map<String, List<SalesRecord>> sellRecords = new HashMap<String, List<SalesRecord>>();
    public List<Product> stock = new ArrayList<>();
    private int id = 0;

    /**
     * Verifica lista de produse si modifica cantitatea produsului daca produsul e in lista, iar daca nu e
     * il adauga in lista si ii desemneaza un ID nou
     *
     * @param p
     * @param quantity
     */
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

    /**
     * Printeaza lista cu stockul existent pentru punctul 2. Clientul urmeaza sa selectioneze
     * produsul dorit pe baza ID-ului.
     */
    public void displayStock() {
        for (int i = 0; i < stock.size(); i++) {
            System.out.println(stock.get(i));
        }
    }

    /**
     * Logica pentru a scoate produse din stoc cand sunt vandute si a recorda vanzarea.
     * Verifica daca exista in lista produsul dorit si daca in urma vanzarii raman 0 sau mai multe
     * produse in stoc vanzarea merge mai departe. Altfel clientul e atentionat ca
     * vanzarea nu s-a efectuat.
     *
     * @param index
     * @param quantity
     * @param date
     */
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

    /**
     * Recordeaza produsele vandute intr-un HashMap bazat pe data vanzarii introdusa de client
     *
     * @param date
     * @param s
     */
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

    /**
     * Printeaza lista de date disponibile pentru a fi listate cand se doreste verificarea istoricului de vanzari
     */
    public void getRecordsList() {
        for (String key :
                sellRecords.keySet()) {
            System.out.println(key);
        }
    }

    /**
     * Listeaza toate vanzarile de la data introdusa va parametru
     *
     * @param date
     */
    public void getSalesRecord(String date) {
        if (sellRecords.containsKey(date)) {
            for (SalesRecord s : sellRecords.get(date)
            ) {
                System.out.println(s.toString());
            }
        }
    }

    /**
     * returneaza un produs din lista
     *
     * @param index
     */
    public Product getProdFromList(int index) {
        return stock.get(index);
    }
}
