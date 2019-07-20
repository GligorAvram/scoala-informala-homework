package ro.week5;

import java.util.Scanner;

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
                System.out.println("add veggie or ani?");
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
                    System.out.println("how many?");
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
