package com.ecom.service;

import com.ecom.data.*;

import java.util.ArrayList;
import java.util.List;


public class ShoppingCart {
	private List<ViewCartItem> items = new ArrayList<>();;

	public List<ViewCartItem> getItems() {

		return items;
	}

	public void setItems(List<ViewCartItem> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		viewCart();
		return "\nTotal Price =" + getTotal();
	}

	public void viewCart() {
		for (ViewCartItem item : items) {
			System.out.println(item);
		}

	}

	public void addItem(Product product, int quantity) {
		int stockCount = product.getQuantity();
		for (ViewCartItem item : items) {
			try {
				if (item.getProduct().getProductId() == product.getProductId()) {
					item = new ViewCartItem(product, quantity);

				}
			} catch (NullPointerException e) {
				System.out.println("Product is out of stock" + e);
			}

		}
		items.add(new ViewCartItem(product, quantity));
		stockCount = stockCount - quantity;
		product.setQuantity(stockCount);
	}

	public double getTotal() {
		double total = 0;
		for (ViewCartItem item : items) {
			total += item.getTotalPrice();
		}
		// items.clear();
		return total;
	}
	
	public ViewCartItem getItemByProductId(int productId) {
	    for (ViewCartItem item : items) {
	        if (item.getProduct().getProductId() == productId) {
	            return item;
	        }
	    }
	    return null;
	}

	public ViewCartItem getItemByProductName(String productName) {
	    for (ViewCartItem item : items) {
	        if (item.getProduct().getProductName().equalsIgnoreCase(productName)) {
	            return item;
	        }
	    }
	    return null;
	}
	
	public void removeItemById(int productId) {
	    items.removeIf(item -> item.getProduct().getProductId() == productId);
	}

	public void removeItemByName(String productName) {
	    items.removeIf(item -> item.getProduct().getProductName().equalsIgnoreCase(productName));
	}
}
