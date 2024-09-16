package com.ecom.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface InventoryImpl {
	
	Connection getConnection() throws Exception;
	
	Product fetchTable(ResultSet resultSet) throws SQLException;

	Product getProductById(int productId) throws Exception;

	List<Product> searchProducts(String partialName) throws Exception;

	void updateProductQuantity(int productId, int newQuantity) throws Exception;

	List<Product> listProducts() throws Exception;

}
