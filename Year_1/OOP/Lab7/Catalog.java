package Lab7;

import java.util.HashMap;

public class Catalog {
    private HashMap<String, Product> productList;
    private HashMap<String, Integer> priceList;

    public Catalog() {
        productList = new HashMap<>();
        priceList = new HashMap<>();
    }

    public void add(Product product, int price) {
        for (String i : productList.keySet())
            if (i.equals(product.getpName()))
                price = priceList.get(i);
        
        productList.put(product.getpName(), product);
        priceList.put(product.getpName(), price);
        
    }

    public void showCatalog() {
        System.out.println("Welcome to CS-groceries");
        for(String i : priceList.keySet())
            System.out.println(i+" @ "+ priceList.get(i));
    }

    public int getPrice(String productName) {
        return (priceList.get(productName));
    }

    public Product getProduct(String productName) {
        return (productList.get(productName));
    }
}
