import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Shop shop = new Shop();
        shop.avalibleProducts();

        Scanner scanner = new Scanner(System.in);
        System.out.println("*********************************");
        System.out.println("---WELCOME TO THE AHMED MART --- ");
        System.out.println("*********************************\n");

        while (true) {

            System.out.println("_________________________");
            System.out.println("\nEnter 1 to addProduct:\nEnter 2 to deleteProduct:\nEnter 3 to displayProducts:\nEnter 4 to display Expired Products.\nEnter 5 to searchProduct:\nEnter 6 to Sell Product:\nEnter 7 to Display Revenue:\nEnter 8 to Edit Product.\nEnter 0 to Exit");
            System.out.println("_________________________");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    shop.addProduct();
                    break;
                case 2:
                    shop.deleteProduct();
                    break;

                case 3:

                    shop.displayProducts();
                    break;
                case 4:
                    shop.expiredProducts();
                    break;
                case 5:
                    shop.searchProduct();
                    break;
                case 6:
                    shop.sellProduct();
                    break;
                case 7:
                    shop.displayRevenue();
                    break;
                case 8:
                    shop.editProduct();
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
                    break;

            }
        }
    }
}
