package com.ecom.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Inventory implements InventoryImpl {
	private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	private static final String CONNECTION_STRING = "jdbc:mysql://127.0.0.1:3306/ecommerce";
	private static final String USER = "root";
	private static final String PASSWORD = "pass@word1";
	private static Product product = null;

	@Override
	public Connection getConnection() throws Exception {
		Class.forName(DRIVER_NAME);
		Connection connection = DriverManager.getConnection(CONNECTION_STRING, USER, PASSWORD);
		return connection;

	}

	public Product fetchTable(ResultSet resultSet) throws SQLException {
		int id = resultSet.getInt("product_id");
		String name = resultSet.getString("product_name").trim();
		String cat = resultSet.getString("product_category").trim();
		String spec = resultSet.getString("product_spec").trim();
		double price = resultSet.getDouble("product_price");
		int qty = resultSet.getInt("product_quantity");
		return new Product(id, name, cat, spec, price, qty);

	}

	@Override
	public Product getProductById(int productId) throws Exception {
		Product product = null;
		try {
			Connection connection = getConnection();
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM inventory WHERE product_id = ?");
			stmt.setInt(1, productId);
			ResultSet resultSet = stmt.executeQuery();
			if (resultSet.next()) {
				product = fetchTable(resultSet);
			} else {
				System.out.println("Product not found in database");
			}
			resultSet.close();
			stmt.close();
			connection.close();
		} catch (Exception e) {
			System.out.println("Exception occurred " + e);
		}
		return product;

	}

	@Override
	public List<Product> searchProducts(String partialName) throws Exception {
		List<Product> products = new ArrayList<>();
		Product product = null;
		try {
			Connection connection = getConnection();
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM inventory WHERE product_name LIKE ?");
			stmt.setString(1, "%" + partialName + "%");
			ResultSet resultSet = stmt.executeQuery();

			while (resultSet.next()) {
				product = fetchTable(resultSet);
				products.add(product);
			}
			resultSet.close();
			stmt.close();
			connection.close();
		} catch (Exception e) {
			System.out.println("Exception occurred " + e);
		}

		return products;
	}

	@Override
	public List<Product> listProducts() throws Exception {
		List<Product> products = new ArrayList<>();
		try {
			Connection connection = getConnection();
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM inventory");
			ResultSet resultSet = stmt.executeQuery();
			while (resultSet.next()) {
				product = fetchTable(resultSet);
				products.add(product);
			}
			resultSet.close();
			stmt.close();
			connection.close();
		} catch (Exception e) {
			System.out.println("Exception occurred " + e);

		}
		return products;
	}

	@Override
	public void updateProductQuantity(int productId, int newQuantity) throws Exception {

		try {
			Connection connection = getConnection();
			PreparedStatement stmt = connection
					.prepareStatement("UPDATE inventory SET product_quantity = ? WHERE product_id = ?");
			stmt.setInt(1, newQuantity);
			stmt.setInt(2, productId);
			stmt.executeUpdate();
			stmt.close();
			connection.close();
		} catch (Exception e) {
			System.out.println("Exception occurred " + e);

		}
	}
}
