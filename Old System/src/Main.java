import java.util.Scanner;
public class Main {

public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     Shop shop = new Shop();
     while(true) {
         System.out.println("");
         System.out.println("..............................");
         System.out.println("Enter 1 to add Product\nEnter 2 to view Products\nEnter 3 to sell Product\nEnter 4 to delete Product\nEnter 5 to edit Product : ");
         System.out.println("");
         System.out.println("..............................");
         System.out.println("");
         int choice = sc.nextInt();
         switch(choice) {
             case 1:
                 shop.addProduct();

                 break;
                 case 2:
                     shop.viewItems();
                     break;
                  case 3:
                     shop.sellProduct();
                      break;
                  case 4:
                      shop.deleteProduct();
                      break;
                   case 5:
                       shop.editProduct();
                       break;
             default:
                 System.exit(0);
         }

     }

}
}