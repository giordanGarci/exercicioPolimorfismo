package aplication;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {
	public static void main(String[] args) {

		List<Product> products = new ArrayList<>();

		Locale.setDefault(Locale.US);
		Scanner scan = new Scanner(System.in);

		System.out.print("Enter the number of products: ");
		int n = scan.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.println("Product #" + i + " data: ");
			System.out.print("Common, used or imported (c/u/i)? ");
			char p = scan.next().charAt(0);
			scan.nextLine();
			System.out.print("Name: ");
			String name = scan.nextLine();
			System.out.print("Price: ");
			Double price = scan.nextDouble();
			if (p == 'c') {
				products.add(new Product(name, price));
			} else if (p == 'i') {
				System.out.println("Customs fee: ");
				Double customsFee = scan.nextDouble();
				products.add(new ImportedProduct(name, price, customsFee));
			} else {
				System.out.println("Manufacture date (DD/MM/YYYY): ");
				LocalDate date = LocalDate.parse(scan.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				products.add(new UsedProduct(name, price, date));
			}

		}
		
		System.out.println();
		System.out.println("PRICE TAGS: ");
		for(Product p : products) {
			System.out.println(p.priceTag());
		}
	}
}
