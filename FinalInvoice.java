package Projects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Product {
    private String name;
    private int quantity;
    private double pricePerItem;

    public Product(String name, int quantity, double pricePerItem) {
        this.name = name;
        this.quantity = quantity;
        this.pricePerItem = pricePerItem;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPricePerItem() {
        return pricePerItem;
    }

    public double getTotalPrice() {
        return quantity * pricePerItem;
    }
}

public class FinalInvoice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter customer name:");
        String customerName = sc.nextLine();

        List<Product> products = new ArrayList<>();

        while (true) {
            System.out.println("Enter product name:");
            String productName = sc.nextLine();

            System.out.println("Enter quantity:");
            int quantity = sc.nextInt();

            System.out.println("Enter price per item:");
            double pricePerItem = sc.nextDouble();

            sc.nextLine(); 

            products.add(new Product(productName, quantity, pricePerItem));

            System.out.println("Do you want to add another product? (yes/no)");
            String addAnother = sc.nextLine();

            if (!addAnother.equalsIgnoreCase("yes")) {
                break;
            }
        }

        // Printing the invoice
        System.out.println("\n===== INVOICE =====");
        System.out.println("Customer Name: " + customerName);
        System.out.println("-------------------------------");
        System.out.println("Product\t\tQuantity\tPrice");
        System.out.println("-------------------------------");
        double totalAmount = 0;
        for (Product product : products) {
            System.out.printf("%-15s\t%d\t\t$%.2f%n", product.getName(), product.getQuantity(), product.getTotalPrice());
            totalAmount += product.getTotalPrice();
        }
        System.out.println("-------------------------------");
        System.out.printf("Total Amount:\t\t\t$%.2f%n", totalAmount);
    }
}

