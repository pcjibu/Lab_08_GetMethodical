import java.util.Scanner;

public class CheckOut {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double totalCost = 0.0;

        do {
            double price = SafeInput.getRangedDouble(scanner, "Enter the item price ($0.50 - $10.00)", 0.5, 10.0);
            totalCost += price;
        } while (SafeInput.getYNConfirm(scanner, "Do you have more items to add (Y/N)?"));

        System.out.printf("Total Cost: $%.2f%n", totalCost);
    }
}
