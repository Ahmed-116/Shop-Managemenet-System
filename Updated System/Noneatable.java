public class Noneatable extends Product {
    private String material;
    public Noneatable(String name,double price,int ammount, String material) {
        super(name,price,ammount);
        this.material = material;
    }
    public String getMaterial() {
        return material;
    }
    public void setMaterial(String material) {
        this.material = material;
    }
    public void displayDetails() {
        super.display();
        System.out.println("Material used: "+ material);
        System.out.println();
    }
}
