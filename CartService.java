package com.ecom.service;

public interface CartService {

	void addProductToCart(int productId, int quantity) throws Exception;

	void removeProductFromCartById(int productId, int quantity) throws Exception;
	 
	void removeProductFromCartByName(String productName, int quantity)  throws Exception;

	ShoppingCart viewCart();

	void checkout();

}
