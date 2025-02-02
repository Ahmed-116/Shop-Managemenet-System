public class Product {

    private String name;
    private double price;
    private int ammount ;
    private String id;
    public static int counter=0;
    public Product(String name, double price,int ammount) {
        this.name = name;
        this.price = price;
        this.ammount = ammount;
        this.id = String.format("%03d", ++counter);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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


    public void display(){
        System.out.println();
        System.out.println("("+id+")");
        System.out.println("Name: " + name);
        System.out.println("Price: " + price);
        System.out.println("Ammount: " + ammount);

    }
}
