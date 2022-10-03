package com.hotelmanagement.controller.orders;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hotelmanagement.model.menu.Menu;
import com.hotelmanagement.model.order.Order;
import com.hotelmanagement.server.Server;

public class OrderManagement {

	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	private static final String ADD_ORDER = "INSERT INTO Orders (item_id,quantity,item_price,customer_id,item_name) VALUES (?,?,?,?,?)";
	private static final String DELETE_ORDER = "DELETE FROM Orders WHERE order_id = ?";
	private static final String PRICE_DETAILS = "SELECT item_price FROM Menu WHERE  item_id=?";
	private static final String CUSTOMER_ID = "SELECT customer_id FROM Customer WHERE customer_phoneNumber = ?";
	private static final String ITEM_DETAILS = "SELECT item_name FROM Menu WHERE  item_id=?";
	private static final String ORDER_DETAILS = "SELECT item_id,item_name,quantity,item_price FROM Orders WHERE customer_id = ?";

	public OrderManagement() {

		try {
			connection = DriverManager.getConnection(Server.URL, Server.USERNAME, Server.PASSWORD);
		} catch (SQLException e) {

//				e.printStackTrace();
			System.out.println(e.toString());
			System.out.println("Unnable to connect Server to Sql");
		}
	}

	private boolean customerOrder(int itemId, int itemQuantity, String phoneNumber) {
		int count = 0;
		Double itemPrice = itemQuantity * itemPrice(itemId);
		int customerId = customerId(phoneNumber);
		String itemName = itemName(itemId);
		try {
			preparedStatement = connection.prepareStatement(ADD_ORDER);
			preparedStatement.setInt(1, itemId);
			preparedStatement.setInt(2, itemQuantity);
			preparedStatement.setDouble(3, itemPrice);
			preparedStatement.setInt(4, customerId);
			preparedStatement.setString(5, itemName);
			count = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (count > 0) {
			return true;
		}
		return false;
	}

	private boolean deleteOrder(int orderId) {
		int count = 0;

		try {
			preparedStatement = connection.prepareStatement(DELETE_ORDER);
			preparedStatement.setInt(1, orderId);
			count = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (count > 0) {
			return true;
		}
		return false;
	}

	private Double itemPrice(int itemId) {
		Double itemPrice = 0.0;
		try {
			preparedStatement = connection.prepareStatement(PRICE_DETAILS);
			preparedStatement.setInt(1, itemId);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				itemPrice = resultSet.getDouble(1);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return itemPrice;
	}

	private String itemName(int itemId) {
		String itemName = "";
		try {
			preparedStatement = connection.prepareStatement(ITEM_DETAILS);
			preparedStatement.setInt(1, itemId);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				itemName = resultSet.getString(1);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return itemName;
	}

	private int customerId(String phoneNumber) {
		int customer_id = 0;

		try {
			preparedStatement = connection.prepareStatement(CUSTOMER_ID);
			preparedStatement.setString(1, phoneNumber);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				if (resultSet.getString(1).equals(phoneNumber)) {
					customer_id = resultSet.getInt(1);
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return customer_id;
	}

	private List<Order> displayOrder(String phoneNumber) {
		List<Order> order = new ArrayList<>();
		Order orderAll = null;
		int customerId = customerId(phoneNumber);

		try {
			preparedStatement = connection.prepareStatement(ORDER_DETAILS);
			preparedStatement.setInt(1, customerId);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				orderAll = new Order();
				orderAll.setItemId(resultSet.getInt(2));
				orderAll.setItemName(resultSet.getString(3));
				orderAll.setQuantity(resultSet.getInt(4));
				orderAll.setItemPrice(resultSet.getDouble(6));
				order.add(orderAll);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return order;

	}

	public void orderDoThis(int operationType, int itemId, int orderid, int quatity, String PhoneNumber) {
		switch (operationType) {
		case 1: {
			if (customerOrder(itemId, quatity, PhoneNumber)) {
				System.out.println("order Placed");
			} else {
				System.out.println("sorry order not placed");
			}

		}
			break;
		case 2: {
			if (deleteOrder(orderid)) {
				System.out.println("order Deleted sucess");
			} else {
				System.out.println("failed delete");
			}

		}
			break;
			
		case 3:
			System.out.println(displayOrder(PhoneNumber).toString());

			break;
		}
	}

}
