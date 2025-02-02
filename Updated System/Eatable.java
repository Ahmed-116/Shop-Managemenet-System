import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Eatable extends Product {
    private String expiryDate;


    public Eatable(String name, double price,int ammount, String expiryDate) {
        super(name, price,ammount);
        this.expiryDate = expiryDate;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public void displayDetails() {
          super.display();
        System.out.println("Expiry Date: " + expiryDate);
        System.out.println();
    }

//    public boolean isExpired() {
//        try {
//
//
//            LocalDateTime dateTime = LocalDateTime.now();
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//            LocalDateTime expiry = LocalDateTime.parse(expiryDate, formatter);
//            return expiry.isBefore(dateTime);
//        }
//        catch (Exception e) {
//            System.out.println("Invalid expiry date format for product: \n" + getName());
//            return false;
//        }
//    }
public boolean isExpired() {
    try {
        if (expiryDate == null || expiryDate.isEmpty()) {
            return false; // No expiry date means it's not expired.
        }

        // Parse and compare expiry date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate expiry = LocalDate.parse(expiryDate, formatter);
        return expiry.isBefore(LocalDate.now()); // Check if expiry is before today's date.
    } catch (Exception e) {
        System.out.println("Error parsing expiry date: " + e.getMessage());
        return false; // If parsing fails, assume it's not expired.
    }
}

}
