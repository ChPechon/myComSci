package Lab7;

public class Drink extends Product {
    public Drink(String n, String d) {
        super(n, d);
    }

    @Override
    public String toString() {
        return ("ProductName=" + pName + ", desc=" + desc + "]");
    }
}
