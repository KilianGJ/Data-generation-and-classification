import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class GenerateInfoFiles {

    // Method to generate a sales file for a salesperson
    public static void createSalesMenFile(int randomSalesCount, String name, long id) throws IOException {
        String fileName = "sales_" + id + ".txt";
        FileWriter fileWriter = new FileWriter(fileName);
        Random random = new Random();

        // Enter seller information in the file
        fileWriter.write("CC: " + id + "\n---------------\n");

        // Generate random sales
        for (int i = 0; i < randomSalesCount; i++) {
            int productId = random.nextInt(1000); // random product id
            int quantity = random.nextInt(100) + 1; // Random quantity sold
            fileWriter.write(productId + " - " + quantity + "\n");
        }

        fileWriter.close();
        System.out.println("Sales file generated for the salesperson " + name + " with ID " + id);
    }

    // Method to generate a file with product information
    public static void createProductsFile(int productsCount) throws IOException {
        String fileName = "products.txt";
        FileWriter fileWriter = new FileWriter(fileName);
        Random random = new Random();

        // Generate random products
        for (int i = 0; i < productsCount; i++) {
            int productId = random.nextInt(1000); 
            String productName = "Product - " + productId; // Product name
            double price = random.nextDouble() * 100; // Random price
            fileWriter.write(productName + " - " + String.format("%.2f", price) + "\n");
        }

        fileWriter.close();
        System.out.println("Product file generated.");
    }

    // Method to generate a file with seller information
    public static void createSalesManInfoFile(int salesManCount) throws IOException {
        String fileName = "salesMen_info.txt";
        FileWriter fileWriter = new FileWriter(fileName);
        Random random = new Random();

        String[] firstNames = {"Juan", "Maria", "Carlos", "Ana", "Luis"};
        String[] lastNames = {"Perez", "Garcia", "Rodriguez", "Lopez", "Martinez"};

        // Generate random seller information
        for (int i = 0; i < salesManCount; i++) {
            String firstName = firstNames[random.nextInt(firstNames.length)];
            String lastName = lastNames[random.nextInt(lastNames.length)];
            long documentNumber = random.nextInt(1000000000); // Random document number
            fileWriter.write(" -- " + firstName + " " + lastName + "\nCC: " + documentNumber  + "\n\n");
        }

        fileWriter.close();
        System.out.println("Seller information file generated.");
    }

    // Main method to execute and generate files
    public static void main(String [] args) {
        try {
            // Generate seller file with 5 sellers
            createSalesManInfoFile(5);

            // Generate product file with 10 products
            createProductsFile(10);

            // Generate sales file for a seller with 20 random sales
            createSalesMenFile(20, "Juan Pérez", 123456789);
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}

