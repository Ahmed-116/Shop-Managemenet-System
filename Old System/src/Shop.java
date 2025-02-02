import java.util.Scanner;
public class Shop {
    Product[] pro=new Product[100];
    Scanner sc=new Scanner(System.in);
    public static int count=0;
     public static double revenue=0;
    {
        pro[0]=new Product("Laptop",100.00,20);
        pro[1]=new Product("Samsung Galaxy",150.00,20);
        pro[2]=new Product("Galaxy Samsung",120.00);
        pro[3]=new Product("Iphone");
        count+=4;
    }
    public void viewItems(){
        for (int i=0;i<count;i++){
            System.out.println(pro[i]);
        }
    }
    public void addProduct(){
        System.out.println("Enter product name:");
        String name=sc.nextLine();
        System.out.println("Enter product price:");
        double price=sc.nextDouble();
        System.out.println("Enter product quantity:");
        int quantity=sc.nextInt();
        sc.nextLine(); //to add 2nd product name
        pro[count++]=new Product(name,price,quantity);
        System.out.println("Product added");
    }
    public void sellProduct(){

         System.out.print("Enter Product ID: ");
         String id= sc.nextLine();
         int index=findProductById(id);
      
           if(index!=-1){
               revenue=revenue+pro[index].getPrice();
               if(pro[index].getAmmount()>0) {
                   pro[index].setAmmount(pro[index].getAmmount() - 1);
                   System.out.println("Product sold out");
                   System.out.println("Your current revenue is " + revenue);
               }
               else{

                   System.out.println("Out of stock");
               }
}
     else{
                System.out.println("Product not found..");
}

  }
     public void editProduct(){

         boolean update=false;
         int choice;
         System.out.print("Enter product ID:");
         String id=sc.nextLine();
         int index = findProductById(id);

        if(index!=1){
                  while(true){
             if(update){
                 break;
}
System.out.println("");
System.out.println("..............................");
               System.out.println("Enter 1 to edit product name\nEnter 2 to edit price\nEnter 3 to edit quantity\nEnter 4 if modification complete");
             
               System.out.println("..............................");
                             choice=sc.nextInt();
                      sc.nextLine();//Reason unknown why we use this

             switch(choice){

                    case 1:
                  
                   System.out.print("Enter new product name:");
                    String name=sc.nextLine();
                   pro[index].setName(name);
                      System.out.println("Product name updated:");
                        break;
                     case 2:
                    
                   System.out.print("Enter new product price:");
                    double price=sc.nextDouble();
                   pro[index].setPrice(price);
                      System.out.println("Product price updated:");
                         break;
                    case 3:
                      
                   System.out.print("Enter new product ammount:");
                    int ammount=sc.nextInt();
                   pro[index].setAmmount(ammount);
                      System.out.println("Product ammount updated:");
                       break;
                      case 4:
                      update =true;
                   System.out.println("Modification complete:");
                     break;
                        default:
                     
                          System.out.print("Invalid selection:");
                    
            
}

}
  
}

}
  public void deleteProduct(){
        System.out.print("Enter product ID:");
        String id=sc.nextLine();
        int index=findProductById(id);
        if(index!=-1){
            for (int i=index;i<count-1;i++)
                pro[i]=pro[i+1];

                System.out.println("Product removed");


            pro[count-1]=null;
             count--;
        }
        else{
            System.out.println("Product not found..");
        }
  }
   public int findProductById(String id){

            for(int i=0;i<count;i++){
                 if(id.equals(pro[i].getId())){
                     return i;
}
}
       return -1;

  }

}
