package Lab7;

public class LineItem {
    private Product product;
    private int quantity;
    private int buyPrice;

    public LineItem(Product prod, int q, int p) {
        product = prod;
        quantity = q;
        buyPrice = p;
    }

    public Product getProduct() {
        return (product);
    }

    public int getQuantity() {
        return (quantity);
    }

    public int calculateAmount() {
        int cal = getQuantity() * buyPrice;
        return (cal);
    }

    public int getBuyPrice() {
        return (buyPrice);
    }

    @Override
    public String toString() {
        return (quantity + " of " + product.getpName() + " @= " + buyPrice);
    }
}
