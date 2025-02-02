public class Product {

    private String name;
    private double price;
    private int ammount;
    private String id;
    private static int counter;

    public Product(String name, double price, int ammount) {
        setName(name);
        this.price = price;
        this.ammount = ammount;
        this.id = String.format("%04d", counter++);
    }

    public Product(String name, double price) {
        this(name, price, 0);
    }

    public Product(String name) {
        this(name, 0);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = String.format("%-15s", name);
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmmount() {
        return ammount;
    }

    public void setAmmount(int ammount) {
        this.ammount = ammount;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("%s %s %-10.2f %-10d",id,name,price,ammount);
    }
}