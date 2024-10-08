package com.ecom.service;

import com.ecom.data.Product;

public class ViewCartItem {

	private Product product;
	private int quantity;

	public ViewCartItem(Product product, int quantity) {
		this.product = product;
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotalPrice() {
		return product.getPrice() * quantity;
	}

	@Override
	public String toString() {
		return String.format("Product: %s, Quantity: %d, Total Price: %.2f", product.getProductName(), quantity,
				getTotalPrice());
	}
}
