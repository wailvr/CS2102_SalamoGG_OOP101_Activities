import java.util.Scanner;

public class Canteen {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int totalQuantityPurchased = 0;
		double totalAmountBeforeDeduction = 0;
		double totalDeduction = 0;

		System.out.println("=====  M E N U  =====");
		System.out.println("1. Burger      - $80.00");
		System.out.println("2. Pizza       - $120.00");
		System.out.println("3. Carbonara   - $100.00");
		System.out.println("4. Sandwich    - $70.00");
		System.out.println("5. Milk Tea    - $90.00");
		System.out.println();

		boolean continueOrdering = true;

		while (continueOrdering) {
			System.out.print("Enter item number: ");
			int itemNumber = input.nextInt();

			System.out.print("Enter quantity: ");
			int itemQuantity = input.nextInt();

			if (itemNumber < 1 || itemNumber > 5 || itemQuantity < 1 || itemQuantity > 10) {
				System.out.println("Invalid Input! Please enter a valid item and quantity. Thank you!\n");

				System.out.print("Do you want to order again? (Y/N): ");
				char repeatChoice = input.next().toUpperCase().charAt(0);
                System.out.println();

                if (repeatChoice != 'Y'){
                	break;
                }
                continue;
			}

			double itemPrice = 0.0;
			switch (itemNumber) {
				case 1:
					itemPrice = 80.00;
					break;
				case 2:
					itemPrice = 80.00;
					break;
				case 3:
					itemPrice = 80.00;
					break;
				case 4:
					itemPrice = 80.00;
					break;
				case 5:
					itemPrice = 80.00;
					break;
			}

			System.out.print("Are you a student? (Y/N): ");
			char studentInput = input.next().toUpperCase().charAt(0);
			boolean isStudent = (studentInput == 'Y');

			double subtotal = itemPrice * itemQuantity;

			double discountRate = 0.0;
			if (isStudent && subtotal >= 500.00) {
				discountRate = 0.15;
			} else if (isStudent) {
				discountRate = 0.10;
			} else if (subtotal >= 500.00) { 
				discountRate = 0.05;
			}

			double discountAmount = subtotal * discountRate;
			double totalOrder = subtotal - discountAmount;

			System.out.println();
			System.out.println("-------------------");
            System.out.printf("Subtotal: $%.2f%n", subtotal);
            System.out.printf("Discount: $%.2f%n", discountAmount);
            System.out.printf("Order total: $%.2f%n%n", totalOrder);
            System.out.println("-------------------");

            totalQuantityPurchased += itemQuantity;
            totalAmountBeforeDeduction += subtotal;
            totalDeduction += discountAmount;

            System.out.print("Do you want to order again? (Y/N): ");
			char continueChoice = input.next().toUpperCase().charAt(0);
            System.out.println();

            if (continueChoice != 'Y') {
            	continueOrdering = false;
            }
		}	

		double finalAmount = totalAmountBeforeDeduction - totalDeduction;

		System.out.println("\n===== ORDER SUMMARY =====");
        System.out.printf("Total items: %d%n", totalQuantityPurchased);
        System.out.printf("Total before discount: $%.2f%n", totalAmountBeforeDeduction);
        System.out.printf("Total discount: $%.2f%n", totalDeduction);
        System.out.printf("Final amount: $%.2f%n", finalAmount);
        System.out.println("-> Thank you for ordering!");

        input.close();
	}
}