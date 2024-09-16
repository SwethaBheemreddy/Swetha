package com.ecom.data;

public class Product {
    private int productId;
    private String productName;
    private String productCategory;
    private String productSpec;
    private double price;
    private int quantity;
    
    
	public Product() {
		
	}
	public Product(int productId, String productName, String productCategory, String productSpec,
			double price, int quantity) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productCategory = productCategory;
		this.productSpec = productSpec;
		this.price = price;
		this.quantity = quantity;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public String getproductSpec() {
		return productSpec;
	}
	public void setproductSpec(String productSpec) {
		this.productSpec = productSpec;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		return productId + " |" +productName + " |" + productCategory + " |" + productSpec +  " |" + price
				+ " |" + quantity;
	}
	
	

    
}