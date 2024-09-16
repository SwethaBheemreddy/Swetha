package com.ecom.app;

import com.ecom.data.*;
import com.ecom.service.*;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ECommerceApplication {
	private static CartService cartService;
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		Inventory inventory = new Inventory();
		cartService = new CartServiceImpl(inventory);

		while (true) {
			System.out.println("*************************************************************************\n");
			System.out.println("Welcome to the Shopping Festival:");
			System.out.println("Choose from the below menu options:");
			System.out.println("1. List all Available Products  | 2. Search for Products  | 3. Add Product to Cart");
			System.out.println("4. Remove Product from Cart     | 5. View Shopping Cart   | 6. Checkout");
			System.out.println("7. Exit");
			System.out.println("*************************************************************************\n");
			System.out.println("Enter your selection");
			int option = scanner.nextInt();
			scanner.nextLine();

			try {
				switch (option) {
				case 1:
					listProducts(inventory);
					break;
				case 2:
					searchProducts(inventory);
					break;
				case 3:
					addProductToCart();
					break;
				case 4:
					removeFromCart();
					break;
				case 5:
					viewCart();
					break;
				case 6:
					checkout();
					break;
				case 7:
					System.out.println("Signing out of the application...");
					return;
				default:
					System.out.println("Invalid option. Please try again.");
				}
			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
			}
		}
	}

	private static void listProducts(Inventory inventory) throws Exception {
		List<Product> products = inventory.listProducts();
		Iterator<Product> itr = products.iterator();
		System.out.println("Products available in stock\n");
		System.out.println("ID | Name | Category | Specifications \t| Price | Quantity");
		System.out.println("------------------------------------------------------------------------");
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
		System.out.println("------------------------------------------------------------------------");
		System.out.println("End of Display\n");
	}
	
	 private static void searchProducts(Inventory inventory) throws Exception {
	        System.out.print("Enter product name or ID: ");
	        String input = scanner.nextLine();
	        try {
	            int id = Integer.parseInt(input);
	            searchProductsById(inventory, id);
	        } catch (NumberFormatException e) {
	        	searchProductsByName(inventory, input);
	        }
	    }


	private static void searchProductsByName(Inventory inventory, String partialName) throws Exception {
			
		List<Product> products = inventory.searchProducts(partialName);
		Iterator<Product> itr = products.iterator();
		System.out.println("Products matching your search criteria\n");
		System.out.println("ID | Name | Category | Specifications \t| Price | Quantity");
		System.out.println("------------------------------------------------------------------------");
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
		System.out.println("------------------------------------------------------------------------");
		System.out.println("End of Display\n");
	}

	private static void searchProductsById(Inventory inventory, int id) throws Exception {
				
		Product product = inventory.getProductById(id);
		System.out.println("Products matching your search criteria\n");
		System.out.println("ID | Name | Category | Specifications \t| Price | Quantity");
		System.out.println("------------------------------------------------------------------------");
		System.out.println(product);
		System.out.println("------------------------------------------------------------------------");
		System.out.println("End of Display\n");
	}
	private static void addProductToCart() throws Exception {
		System.out.print("Enter product ID to add to cart: ");
		int productId = scanner.nextInt();
		System.out.print("Enter quantity: ");
		int quantity = scanner.nextInt();
		cartService.addProductToCart(productId, quantity);

	}
	
	 private static void removeFromCart() throws Exception {
	        System.out.print("Enter product ID or name to remove: ");
	        String input = scanner.nextLine();
	        System.out.print("Enter quantity to remove: ");
	        int quantity = scanner.nextInt();
	        try {
	            int productId = Integer.parseInt(input);
	            cartService.removeProductFromCartById(productId, quantity);
	        } catch (NumberFormatException e) {
	        	cartService.removeProductFromCartByName(input, quantity);
	        	
	        }
	    }

	

	private static void viewCart() {
		System.out.println("*** VIEW CART *** ");
		System.out.println(cartService.viewCart());
	}

	private static void checkout() {
		cartService.checkout();
	}
}