package ro.week5;

import java.util.Scanner;

/**
 * Tema 5 cu urmatoarele cerinte:
 * <p>
 * <p>
 * A farm sells animal and vegetable products at the local store.
 * All products have on their packaging the price, validity date and weight.
 * The animal products in the store are the following: milk, eggs and various other products made out of milk (such as cheese, yogurt, sour cream).
 * All animal products have on their packaging storage temperature.
 * All vegetal products have a name and describe on their packaging a list of vitamins they contain.
 * <p>
 * Please create a program which simulates the operations at a store.
 * The store has a list of item in stock.
 * Each item refers to a product and has a stock number (could be 0 if it's out of stock).
 * A product is identified uniquely by an ID.
 * <p>
 * When you run the program it should display a list of options:
 * <p>
 * -------------------------------------------------------------
 * <p>
 * 1. Create product and add it to stock
 * <p>
 * 2. Sell product
 * <p>
 * 3. Display daily sales report
 * <p>
 * 4. Exit
 * <p>
 * Choose an option:
 * <p>
 * -------------------------------------------------------------
 * <p>
 * <p>
 * When the user chooses 1, the program displays:
 * <p>
 * -------------------------------------------------------------
 * <p>
 * Product type (1 - animal; 2 - vegetable):
 * <p>
 * -------------------------------------------------------------
 * <p>
 * <p>
 * Based on the user's choice, give him/her the opportunity to input all the relevant properties, create the product and add it to the stock.
 * <p>
 * <p>
 * When the user chooses 2, the program displays a table (don't worry about the table's appearance, just display the data in a readable format) with the products.
 * Give the user the chance to input the product's ID and quantity.
 * The system validates the order first: searches for the product that it exists and if it exists makes sure that it's in stock.
 * If the order is valid, saves the order, with the date when it was placed (date format could be (String): "yyyy-MM-dd"), product ID and quantity.
 * <p>
 * When the user chooses 3, give him/her the chance to enter a date (in the same format used for orders) and display a list with all the orders from that date.
 * <p>
 * When the users chooses 4 the program ends.
 * <p>
 * <p>
 * Important note:
 * - if you don't manage to create and work with the program menu described above, just create programmatically (write the Java code to instantiate) a list of products of various types; then place a few orders; then display the daily report for a particular date.
 * <p>
 * Notes:
 * - we're interested in the interfaces/classes involved in this system and their relationships
 * - write some basic behavior on your classes
 * - commit and push the project to your GitHub account
 * - submit your GitHub pullRequest URL
 * <p>
 * Suggestions:
 * - use lists (https://docs.oracle.com/javase/8/docs/api/java/util/List.html) - get used to constantly checking the Javadoc for info on interfaces/classes/methods
 * <p>
 * - try to use best practices in OOP; extra kudos to you if you program against interfaces (e.g. the type of the variable pointing to the list should be List<MyClass>, but the instance's type should be ArrayList<MyClass>)
 * - try to access methods in a polymorphic fashion where suitable
 * <p>
 * Codul nu e protejat impotriva imputurilor invalide.
 *
 * @author Gligor Avram
 * @version 1.0.1
 */

public class Store {
    public static void main(String[] args) {
        StoreManager manager = new StoreManager();
        Scanner sc = new Scanner(System.in);
        String menuSelector = null;
        String menu = "1. Create product and add it to stock\n" +
                "\n" +
                "2. Sell product\n" +
                "\n" +
                "3. Display daily sales report\n" +
                "\n" +
                "4. Exit\n" +
                "\n" +
                "Choose an option: ";
        do {
            System.out.println(menu);
            menuSelector = sc.next();
            while (!(menuSelector.equals("1") || menuSelector.equals("2") || menuSelector.equals("3") || menuSelector.equals("4"))) {
                System.out.println("Please choose a valid option from the list above");
                menuSelector = sc.next();
            }


            if (menuSelector.equals("1")) {
                System.out.println("Add a vegetable or an animal product?");
                menuSelector = sc.next();
                if (menuSelector.equals("1")) {
                    System.out.println("Name of the product: ");
                    String name = sc.next();
                    System.out.println("Vitamins of the product: ");
                    //type them in one string please. wasted an hour just to find out nextLine() is broken.
                    String vit = sc.next();
                    System.out.println("How many would you like to add?");
                    while (!sc.hasNextInt()) {
                        sc.next();
                        System.out.println("Type in a number");
                    }
                    int quantity = sc.nextInt();
                    Product p = new leGumes(name, vit);
                    manager.addToStock(p, quantity);
                } else if (menuSelector.equals("2")) {
                    System.out.println("1. milk 2. eggs 3. others");
                    int animalSelector = sc.nextInt();
                    System.out.println("how many would you like to add?");
                    int quantity = sc.nextInt();
                    switch (animalSelector) {
                        case 1:
                            Product m = new Milk();
                            manager.addToStock(m, quantity);
                            break;
                        case 2:
                            Product e = new Eggs();
                            manager.addToStock(e, quantity);
                            break;
                        case 3:
                            Product o = new Other();
                            manager.addToStock(o, quantity);
                            break;
                    }
                }
                //previne iesirea din program daca ultimul input e 4
                menuSelector = "done";

            } else if (menuSelector.equals("2")) {
                manager.displayStock();
                System.out.println("ID of your purchase: ");
                int id = sc.nextInt();
                System.out.println("Quantity of products to buy: ");
                int quantity = sc.nextInt();
                System.out.println("Please input a delivery date");
                String date = sc.next();
                manager.sellProducts(id, quantity, date);

            } else if (menuSelector.equals("3")) {
                manager.getRecordsList();
                System.out.println("type the date you'd like to retrieve the products for");
                String date = sc.next();
                manager.getSalesRecord(date);
            }


        }
        while (!menuSelector.equals("4"));
    }
}
