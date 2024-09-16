package com.ecom.service;


import com.ecom.data.*;


public class CartServiceImpl implements CartService {
    private Inventory inventory;
    private ShoppingCart cart = new ShoppingCart();

    public CartServiceImpl(Inventory inventory) {
        this.inventory = inventory;
    }

    @Override
    public void addProductToCart(int productId, int quantity) throws Exception {
        Product product = inventory.getProductById(productId);
        if (product.getQuantity() < quantity) {
            throw new Exception("Product is currently out of stock, please check back later");
        }
        cart.addItem(product, quantity);
        System.out.println("Below Product has been added to cart.");
		System.out.println("ID | Name |  Price | Quantity ");
		System.out.println("------------------------------------------------------------------------");
        System.out.println(product.getProductId() + " | " +product.getProductName()+ " | " +product.getPrice()+ " | " +quantity);
        System.out.println("------------------------------------------------------------------------");
		System.out.println("End of Display\n");
        int stockCount = product.getQuantity() - quantity;
        inventory.updateProductQuantity(productId, stockCount);
    }

   
    
  
    @Override
    public ShoppingCart viewCart() {
        return cart;
    }

    @Override
    public void checkout() {
        System.out.println(cart);
        System.out.println("Thank you for shopping with us!");
        cart = new ShoppingCart(); // To Clear the cart after checkout
    }

	@Override
	public void removeProductFromCartByName(String productName, int quantity) throws Exception {
	    ViewCartItem item = cart.getItemByProductName(productName);
	    if (item != null) {
	        if (quantity >= item.getQuantity()) {
	        	  System.out.println("Below Product has been removed from cart.");
	              System.out.println(productName+ " | " +quantity);
	              System.out.println("------------------------------------------------------------------------");
	      		System.out.println("End of Display\n");
	            cart.removeItemByName(productName);
	        } else {
	        	  item.setQuantity(item.getQuantity() - quantity);
	        	  System.out.println("Product quantity has been updated.");
	            
	        }
	    } else {
	        throw new Exception("Product not found in the cart.");
	    }
	}
	
	public void removeProductFromCartById(int productId, int quantity) throws Exception {
	    ViewCartItem item = cart.getItemByProductId(productId);
	    if (item != null) {
	        if (quantity >= item.getQuantity()) {
	        	 System.out.println("Below Product has been removed cart.");
	              System.out.println("ProductID : "+ productId+ " | Quantity : " +quantity);
	              System.out.println("------------------------------------------------------------------------");
	      		System.out.println("End of Display\n");
	            cart.removeItemById(productId);
	        } else {
	            item.setQuantity(item.getQuantity() - quantity);
	            System.out.println("Product quantity has been updated.");
	        }
	    } else {
	        throw new Exception("Product not found in the cart.");
	    }
	}
	
	
}
