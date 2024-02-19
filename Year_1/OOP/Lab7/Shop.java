package Lab7;

import java.util.ArrayList;

import java.util.ArrayList;
import java.util.Map;

import javax.sound.sampled.Line;

public class Shop {
    private String name;
    private Catalog catalog = new Catalog();
    private ArrayList<Basket> ordersToday = new ArrayList<>();

    public Shop(String n) {
        name = n;
        catalog.add(new Drink("mix veggies", "refreshing"), 22);
        catalog.add(new Drink("lactasoy", "less hungry"), 15);
        catalog.add(new Noodles("mama", "classic"), 9);
        catalog.add(new Noodles("korean", "i can afford"), 33);
        // duplicate won't update
        catalog.add(new Noodles("mama", "duplicate"), 11);
        showCatalog();
    }

    private void showCatalog() {
        catalog.showCatalog();

    }

    public Basket newCustomerArrives() {
        
        return new Basket();
    }

    public LineItem generateLineItem(String pName, int q) { // add to UML
        

        return new LineItem(catalog.getProduct(pName), q, catalog.getPrice(pName));
    }

    public LineItem generateBuyNowItem(String pName) {

        return new LineItem(catalog.getProduct(pName), 1, catalog.getPrice(pName));
    }

    public void getPayment(Basket b) {
        b.printInvoice();
        ordersToday.add(b);
    }

    public void dailySalesReport() {

    }

}