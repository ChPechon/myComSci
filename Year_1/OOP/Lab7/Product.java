package Lab7;

public abstract class Product {
    protected String pName;
    protected String desc;

    public Product(String pName, String desc) {
        this.pName = pName;
        this.desc = desc;
    }

    public String getpName() {
        return (pName);
    }

    public String getDesc() {
        return (desc);
    }
}
