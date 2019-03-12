package com.main;

import java.util.List;
import java.util.Scanner;

import com.implementation.ProductImpl;
import com.pojo.Product;
import com.requirement.ProductInterface;

public class ProductMain {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to Product App V1.0");
		System.out.println("=========================");
		int ch = 0;
		ProductInterface pd = new ProductImpl();
		do {
			System.out.println("1) Add Product");
			System.out.println("2) Show all Products");
			System.out.println("3) Update Product Quantity by ID");
			System.out.println("4) Delete Product by ID");
			System.out.println("5) Get Product by ID");
			System.out.println("6) Show Products by Name");
			System.out.println("7) Show Products by Quantity");
			System.out.println("8) EXIT");
			System.out.print("Enter you choice: ");
			ch = input.nextInt();
			switch (ch) {
			case 1:
				System.out.print("Enter product id: ");
				int id = input.nextInt();
				System.out.print("Enter product name: ");
				String name = input.next();
				System.out.print("Enter product price: ");
				double price = input.nextDouble();
				System.out.print("Enter product quantity: ");
				int quantity = input.nextInt();
				while (quantity > 50 || quantity < 0) {
					System.out.println("Quantity must be between 0 to 50");
					System.out.print("Enter product quantity: ");
					quantity = input.nextInt();
				}
				Product product = new Product(id, name, price, quantity);
				if (pd.addProduct(product)) {
					System.out.println("Product with details " + product + " added successfully");
				} else {
					System.out.println("Error adding product");
				}
				break;
			case 2:
				List <Product> productList = pd.getAllProducts();
				if (productList != null) {
					System.out.println("Printing details of " + productList.size() + " products: ");
					for (int i = 0; i < productList.size(); i++) {
						System.out.println(productList.get(i));
					}
				} else {
					System.out.println("No products to show");
				}
				break;
			case 3:
				System.out.print("Enter product id to update its quantity: ");
				int id1 = input.nextInt();
				System.out.print("Enter new quantity for product " + id1 + ": ");
				int quantity1 = input.nextInt();
				while (quantity1 > 50 || quantity1 < 0) {
					System.out.println("Quantity must be between 0 to 50");
					System.out.print("Enter new product quantity: ");
					quantity1 = input.nextInt();
				}
				if (pd.updateProductQuantityById(id1, quantity1)) {
					System.out.println("Product with id " + id1 + "'s quantity updated successfully");
				} else {
					System.out.println("Product with id " + id1 + " not found");
				}
				break;
			case 4:
				System.out.print("Enter id of product to be deleted: ");
				int idd = input.nextInt();
				if (pd.deleteProductById(idd)) {
					System.out.println("Product with id " + idd + " deleted");
				} else {
					System.out.println("Product with id " + idd + " not found");
				}
				break;
			case 5:
				System.out.print("Enter product id to get details: ");
				int id2 = input.nextInt();
				Product p = pd.getProductById(id2);
				if (p != null) {
					System.out.println("Product details for id " + id2 + " is: ");
					System.out.println(p);
				} else {
					System.out.println("No product found with id " + id2);
				}
				break;
			case 6:
				System.out.print("Enter product name to show products: ");
				String name1 = input.next();
				List <Product> productByName = pd.getProductsByName(name1);
				if (productByName.size() > 0) {
					System.out.println("Printing details of " + name1 + " products: ");
					for (int i = 0; i < productByName.size(); i++) {
						System.out.println(productByName.get(i));
					}
				} else {
					System.out.println("No products to show");
				}
				break;
			case 7:
				System.out.print("Enter product quantity to show products: ");
				int quantity2 = input.nextInt();
				List<Product> productByQty = pd.getProductsByQuantity(quantity2);
				if (productByQty.size() > 0) {
					System.out.println("Printing details of products with " + quantity2 + " quantity: ");
					for (int i = 0; i < productByQty.size(); i++) {
						System.out.println(productByQty.get(i));
					}
				} else {
					System.out.println("No products to show");
				}
				break;
			case 8:
				System.out.println("Product App Exiting");
				break;
			default:
				System.out.println("Enter a valid choice");
			}
		} while (ch != 8);
	}

}
