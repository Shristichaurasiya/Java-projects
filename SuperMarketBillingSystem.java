import java.util.ArrayList;
import java.util.Scanner;

// Item class to represent each product in the supermarket
class Item {
    private String name;
    private double price;
    private int quantity;

    public Item(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}

// ShoppingCart class to manage items added for billing
class ShoppingCart {
    private ArrayList<Item> items;

    public ShoppingCart() {
        items = new ArrayList<>();
    }

    // Add item to the shopping cart
    public void addItem(Item item) {
        items.add(item);
    }

    // Calculate total amount to be paid
    public double calculateTotal() {
        double total = 0.0;
        for (Item item : items) {
            total += item.getPrice() * item.getQuantity();
        }
        return total;
    }

    // Print the bill with details of items and total amount
    public void generateBill() {
        System.out.println("\n--------------- Bill ---------------");
        System.out.println("Item\t\tPrice\tQuantity");
        System.out.println("------------------------------------");
        for (Item item : items) {
            System.out.println(item.getName() + "\t$" + item.getPrice() + "\t" + item.getQuantity());
        }
        System.out.println("------------------------------------");
        System.out.println("Total Amount:\t$" + calculateTotal());
        System.out.println("------------------------------------\n");
    }
}

// Main class to run the supermarket billing system
public class SupermarketBillingSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ShoppingCart cart = new ShoppingCart();

        while (true) {
            System.out.println("Enter item name (or 'done' to finish):");
            String itemName = scanner.nextLine();
            if (itemName.equals("done")) {
                break;
            }
            
            System.out.println("Enter price:");
            double price = Double.parseDouble(scanner.nextLine());
            
            System.out.println("Enter quantity:");
            int quantity = Integer.parseInt(scanner.nextLine());

            Item item = new Item(itemName, price, quantity);
            cart.addItem(item);
        }

        cart.generateBill();
        scanner.close();
    }
}
