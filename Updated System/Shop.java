import java.util.ArrayList;
import java.util.Scanner;

public class Shop {
    Product product;
    double revenue = 0;
    ArrayList<Product> products = new ArrayList<>();
    Scanner scan = new Scanner(System.in);


    public void avalibleProducts() {
        Eatable eatable = new Eatable("Cake", 230.5, 20, "23-05-2025");
        Eatable eatable1 = new Eatable("Butter", 450, 23, "20-09-2024");
        Noneatable noneatable = new Noneatable("Chair", 456.3, 34, "Plastic");
        products.add(eatable);
        products.add(noneatable);
        products.add(eatable1);

    }

    public void addProduct() {
        while (true) {
            System.out.println("Enter product name: ");
            String name = scan.nextLine();
            System.out.println("Enter product price: ");
            double price = scan.nextDouble();
            scan.nextLine();
            System.out.println("Enter the quantity of the product: ");
            int ammount = scan.nextInt();
            scan.nextLine();
            System.out.println("Is the Product eatable or not:(Y/N)");
            String isEatable = scan.nextLine();
            if (isEatable.equals("Y")) {
                System.out.println("Enter expiry date: ");
                String expiry = scan.nextLine();
                Eatable eatable = new Eatable(name, price, ammount, expiry);
                products.add(eatable);
                System.out.println("Product added");
            } else if (isEatable.equals("N")) {
                System.out.println("Enter Material name: ");
                String material = scan.nextLine();
                Noneatable noneatable = new Noneatable(name, price, ammount, material);
                products.add(noneatable);
                System.out.println("Product added");
            } else {
                System.out.println("Invalid input ");
                return;
            }

            System.out.println("Do you want to continue? (Enter No to return)");
            String choice = scan.nextLine();
            if (choice.equalsIgnoreCase("No")) {
                break;
            }



        }

    }

    public void displayProducts() {

        if (products.isEmpty()) {
            System.out.println("No products found");
        } else {
            System.out.println("\nEatable Products:");
            System.out.println("_ _ _ _ _ _ _ _ _ _");
            for (Product product : products) {
                if (product instanceof Eatable) {
                    Eatable eatable = (Eatable) product;
                    ((Eatable) product).displayDetails();
                    if (eatable.isExpired()) {
                        System.out.println("Product is expired.");
                    } else {
                        System.out.println("Product is not expired.");
                    }
                } else if (products.isEmpty()) {
                    System.out.println(" Eatables not found.");
                }
            }
            System.out.println("\nNone Eatable Products: ");
            System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _");
            for (Product product : products) {
                if (product instanceof Noneatable) {
                    ((Noneatable) product).displayDetails();
                } else if (products.isEmpty())
                    System.out.println("None Eatables not found.");
            }
        }
    }

    public void searchProduct() {
        System.out.println("Enter product name: ");
        String name = scan.nextLine();
        boolean found = false;

        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                System.out.println("Your Product:");
                if (product instanceof Eatable) {
                    ((Eatable) product).displayDetails();
                } else if (product instanceof Noneatable) {
                    ((Noneatable) product).displayDetails();
                }
                found = true;  // Set found to true when product is found
                break; // Exit loop after finding the product
            }
        }

        if (!found) {
            System.out.println("Product not found.");
        }
    }

    public void expiredProducts() {
        boolean expiredFound = false;

        System.out.println("\nChecking for expired products...\n");
        for (Product product : products) {
            if (product instanceof Eatable) {
                Eatable eatable = (Eatable) product;
                if (eatable.isExpired()) {
                    System.out.println("Expired Products:");
                    eatable.displayDetails();
                    expiredFound = true;
                }
            }
        }

        if (!expiredFound) {
            System.out.println("No expired products found.");
        }
    }


    public void sellProduct() {
        System.out.println("Enter product name: ");
        String name = scan.nextLine();
        boolean found = false;
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                if (product.getAmmount() > 0) {
                    System.out.println("Enter the quantity of Product you wanted:");
                    int quantity = scan.nextInt();
                    scan.nextLine();
                    if (quantity <= product.getAmmount()) {
                        revenue += product.getPrice() * quantity;
                        product.setAmmount(product.getAmmount() - quantity);
                        System.out.println("Product sold out.");
                        System.out.println("Revenue updated to " + revenue);
                    } else {
                        System.out.println("Not enough stock available.");
                    }
                } else {
                    System.out.println("Product is out of stock.");
                }
                found = true;
                break;

            }
        }
        if (!found) {
            System.out.println("Product not found.");
        }

    }

    public void displayRevenue() {
        System.out.println("\nYour Current Revenue is: " + revenue + "ruppes\n");
    }

    public void deleteProduct() {
        System.out.println("Enter product name to delete: ");
        String name = scan.nextLine();
        boolean found = false;

        try {
            for (Product product : products) {
                if (product.getName().equalsIgnoreCase(name)) {
                    products.remove(product); // Attempting removal
                    System.out.println("Product '" + name + "' removed successfully.");
                    found = true;
                    break; // Exit the loop
                }
            }
        } catch (Exception e) {
            System.out.println("An error occurred while removing the product. Try again.");
            return; // Exit the method gracefully
        }

        if (!found) {
            System.out.println("Product not found.");
        }
    }

    public void editProduct() {
        boolean update = false;
        System.out.println("Enter product name: ");
        String name = scan.nextLine();
        boolean found = false;
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                found = true;
                while (true) {
                    if (update) {
                        break;
                    }
                    System.out.println("____________________________");
                    System.out.println("Enter 1 to edit Product name:\nEnter 2 to edit Product quantity:\nEnter 3 to edit Product Price:");
                    if (product instanceof Eatable) {
                        System.out.print("Enter 4 to edit Product ExpiryDate:\n");
                    }
                    System.out.print("Enter 5 to edit Product Material:\nEnter 6 if Modification Complete:\n");
                    System.out.println("____________________________");
                    int choice = scan.nextInt();
                    scan.nextLine();
                    switch (choice) {
                        case 1:
                            System.out.println("Enter new product name: ");
                            name = scan.nextLine();
                            product.setName(name);
                            System.out.println("Product name updated successfully.\n");
                            break;
                        case 2:
                            System.out.println("Enter new product quantity: ");
                            int quantity = scan.nextInt();
                            scan.nextLine();
                            product.setAmmount(quantity);
                            System.out.println("Product quantity updated successfully.\n");
                            break;
                        case 3:
                            System.out.println("Enter new product price: ");
                            double price = scan.nextDouble();
                            scan.nextLine();
                            product.setPrice(price);
                            System.out.println("Product price updated successfully.\n");
                            break;
                        case 4:
                            if (product instanceof Eatable) {
                                System.out.println("Enter new Expiry date: ");
                                String expiry = scan.nextLine();
                                ((Eatable) product).setExpiryDate(expiry);
                                System.out.println("Product expiry updated successfully.\n");
                            } else {
                                System.out.println("Product has no expiry date.\n");
                            }
                            break;
                        case 5:
                            if (product instanceof Noneatable) {
                                System.out.println("Enter new Material: ");
                                String material = scan.nextLine();
                                ((Noneatable) product).setMaterial(material);
                                System.out.println("Product material updated successfully.\n");
                            } else {
                                System.out.println("No Material define for Eatable Product.\n");
                            }
                            break;
                        case 6:
                            update = true;
                            break;
                        default:
                            System.out.println("Invalid choice.\n");

                    }
                }


            }

        }
        if (!found) {
            System.out.println("Product not found.");
        }
    }
}
