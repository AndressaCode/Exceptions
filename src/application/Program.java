package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Account;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("Inform account data ");
		System.out.print("Number: ");
		int number = sc.nextInt();
		System.out.print("Inform Holder name: ");
		sc.nextLine();
		String holder = sc.nextLine();
		System.out.print("Initial balance: ");
		double balance = sc.nextDouble();
		System.out.print("Withdraw limit: ");
		double withdrawLimit = sc.nextDouble();

		Account account = new Account(number, holder, balance, withdrawLimit);
		System.out.println(account);

		System.out.println();
		System.out.print("Inform quantity to withdraw: ");
		double quantity = sc.nextDouble();

		try {
			account.withdraw(quantity);
			System.out.printf("New balance: %.2f", account.getBalance());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		sc.close();

	}

}
