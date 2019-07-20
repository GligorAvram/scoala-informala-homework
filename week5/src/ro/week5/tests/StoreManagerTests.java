package ro.week5.tests;

import org.junit.Test;
import ro.week5.*;

import static org.junit.Assert.assertEquals;

public class StoreManagerTests {

    @Test
    public void testLeGumesToStock() {
        StoreManager s = new StoreManager();
        Product l1 = new leGumes("caca", "a b c");
        Product l2 = new leGumes("pipi", "a b");
        Product l3 = new leGumes("caca", "a b");
        Product l4 = new leGumes("caca", "a b c");
        s.addToStock(l1, 10);
        s.addToStock(l2, 10);
        s.addToStock(l3, 10);
        s.addToStock(l4, 10);
        int x = s.stock.size();
        assertEquals(3, x);
    }

    @Test
    public void testAnimalsToStock() {
        StoreManager s = new StoreManager();
        Product a1 = new Milk();
        Product a2 = new Eggs();
        Product a3 = new Milk();
        Product a4 = new Other();
        s.addToStock(a1, 10);
        s.addToStock(a2, 10);
        s.addToStock(a3, 10);
        s.addToStock(a4, 10);
        int x = s.getProdFromList(0).getStock();
        assertEquals(20, x);
    }

    @Test
    public void sellFromStock() {
        StoreManager s = new StoreManager();
        Product a1 = new Milk();
        Product a2 = new Eggs();
        Product a3 = new leGumes("Carrots", "AB12C");
        Product a4 = new Other();
        s.addToStock(a1, 10);
        s.addToStock(a2, 10);
        s.addToStock(a3, 10);
        s.addToStock(a4, 10);


        s.sellProducts(0, 1, "11.06.2011");
        s.sellProducts(1, 2, "11.06.2012");
        s.sellProducts(2, 3, "11.06.2013");
        s.sellProducts(3, 4, "11.06.2014");

        int x = s.getProdFromList(0).getStock();
        int y = s.getProdFromList(1).getStock();
        int z = s.getProdFromList(2).getStock();
        int a = s.getProdFromList(3).getStock();
        assertEquals(9, x);
        assertEquals(8, y);
        assertEquals(7, z);
        assertEquals(6, a);
    }

    @Test
    public void sellTooMuch() {
        StoreManager s = new StoreManager();
        Product a1 = new Milk();
        Product a2 = new Eggs();
        Product a3 = new leGumes("Carrots", "AB12C");
        Product a4 = new Other();
        s.addToStock(a1, 10);
        s.addToStock(a2, 10);
        s.addToStock(a3, 10);
        s.addToStock(a4, 10);
        s.sellProducts(0, 99, "11.06.2011");
        s.sellProducts(1, 99, "11.06.2012");
        s.sellProducts(2, 99, "11.06.2013");
        s.sellProducts(3, 99, "11.06.2014");

        int x = s.getProdFromList(0).getStock();
        int y = s.getProdFromList(1).getStock();
        int z = s.getProdFromList(2).getStock();
        int a = s.getProdFromList(3).getStock();
        assertEquals(10, x);
        assertEquals(10, y);
        assertEquals(10, z);
        assertEquals(10, a);
    }

    @Test
    public void getRecordsListTest() {
        StoreManager s = new StoreManager();
        Product a1 = new Milk();
        Product a2 = new Eggs();
        Product a3 = new leGumes("Carrots", "AB12C");
        Product a4 = new Other();
        s.addToStock(a1, 10);
        s.addToStock(a2, 10);
        s.addToStock(a3, 10);
        s.addToStock(a4, 10);
        s.sellProducts(0, 1, "00.00.0000");
        s.sellProducts(1, 2, "11.11.1111");
        s.sellProducts(2, 3, "22.22.2222");
        s.sellProducts(3, 4, "33.33.3333");

        s.getRecordsList();
    }

    @Test
    public void getSalesRecordTest() {
        StoreManager s = new StoreManager();
        Product a1 = new Milk();
        Product a2 = new Eggs();
        Product a3 = new leGumes("Carrots", "AB12C");
        Product a4 = new Other();
        s.addToStock(a1, 10);
        s.addToStock(a2, 10);
        s.addToStock(a3, 10);
        s.addToStock(a4, 10);
        s.sellProducts(0, 1, "1");
        s.sellProducts(0, 1, "1");
        s.sellProducts(1, 2, "2");
        s.sellProducts(2, 3, "1");
        s.sellProducts(3, 4, "2");

        s.getSalesRecord("1");
        s.getSalesRecord("Nimic");
        s.getSalesRecord("2");


    }

}
