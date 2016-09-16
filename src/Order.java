import java.util.ArrayList;
import java.util.Scanner;

public class Order {
	public static void main(String[] args) {
		System.out.println("Menu:");
		System.out.println("1.Cola: 50p");
		System.out.println("2.Coffee: £1");
		System.out.println("3.Cheese Sandwich: £2");
		System.out.println("4.Steak Sandwich: £4.50");

		Scanner in = new Scanner(System.in);

		System.out.print("Which item would you like?");

		String order = in.nextLine();
		ArrayList<String> list = new ArrayList<String>();
		while (!order.equals("x")) {

			list.add(order);
			System.out.print("You entered " + order + ", would you like another item? Enter x to finish order.");
			order = in.nextLine();
		}
		double total = 0;
		boolean service = false;
		int serviceCharge = 10;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).equals("1")) {
				total += 0.5;
			} else if (list.get(i).equals("2")) {
				total += 1;
			} else if (list.get(i).equals("3")) {
				total += 2;
				service = true;
			} else if (list.get(i).equals("4")) {
				total += 4.5;
				service = true;
				serviceCharge = 20;
			}
		}
		if (service) {
			double servicePrice = total * serviceCharge / 100;
			String result = String.format("%.2f", servicePrice);

			System.out.println("A service charge of " + serviceCharge + "% has been added to your order.");
			System.out.println("Service charge amount: £" + result);
			System.out.println("Total pre tax: £" + String.format("%.2f", total));
			total += servicePrice;
		}
		System.out.println("Your total is: £" + String.format("%.2f", total));
	}
}
