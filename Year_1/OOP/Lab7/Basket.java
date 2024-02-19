package Lab7;

import java.util.ArrayList;

public class Basket {
    private ArrayList<LineItem> items = new ArrayList<>();

    public void showItemsInBasket() {
        System.out.println("This basket contains");
        for(int i = 0; i < items.size(); i++)
            System.out.println(items.get(i).toString());
    }

    public void putInBasket(LineItem item) {
        items.add(item);
    }

    public void printInvoice() {
        System.out.println("invoice header");
        int sum = 0;

        for (LineItem line : items) {
            System.out.println(line.getProduct().getpName() + " x " + line.getQuantity() + " " + line.calculateAmount());
            sum += line.calculateAmount();
        }
        System.out.println("Total is " + sum + "******");
    }

    public void buyNow(LineItem item) {
        items.add(item);
        System.out.println("invoice header");
        System.out.println(item.getProduct().getpName() + " x " + item.getQuantity() + " " + item.calculateAmount());
        System.out.println("Total is " + item.calculateAmount() + "******");
    }
}
