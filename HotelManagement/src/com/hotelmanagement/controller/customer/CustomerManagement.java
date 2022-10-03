package com.hotelmanagement.controller.customer;

import static java.lang.System.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hotelmanagement.controller.menu.MenuManagement;
import com.hotelmanagement.model.customer.Customer;
import com.hotelmanagement.model.menu.Menu;
import com.hotelmanagement.server.Server;

public class CustomerManagement {

	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	private static final String ADD_CUSTOMER = "INSERT INTO  Customer (customer_id,customer_name,customer_phoneNumber) values (?,?,?)";
	private static final String UPDATE_CUSTOMER = "UPDATE Customer SET customer_name = ?,customer_phoneNumber=? WHERE customer_id = ?";
	private static final String DELETE_CUSTOMER = "DELETE FROM Customer WHERE customer_id = ?";
	private static final String FIND_CUSTOMER = "SELECT * FROM Customer WHERE customer_id = ?";
	private static final String DISPLAY_CUSTOMER = "SELECT * FROM Customer";
	private static final String LOGIN_CUSTOMER = "SELECT customer_phoneNumber FROM customer";
	

	public CustomerManagement() {
		try {
			connection = DriverManager.getConnection(Server.URL, Server.USERNAME, Server.PASSWORD);
		} catch (SQLException e) {

//			e.printStackTrace();
			System.out.println(e.toString());
			System.out.println("Unnable to connect Server to Sql");
		}
	}

	private boolean addCustomer(Customer customer) {
		int count = 0;

		try {
			preparedStatement = connection.prepareStatement(ADD_CUSTOMER);
			preparedStatement.setInt(1, customer.getCustomerId());
			preparedStatement.setString(2, customer.getCustomerName());
			preparedStatement.setString(3, customer.getCustomerPhoneNumber());
			count = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("unable to Excute Qurey");
			e.printStackTrace();
		}

		if (count > 0) {
			return true;
		}
		return false;
	}

	private boolean updateCustomer(Customer customer, int customerId) {
		int count = 0;

		try {

			preparedStatement = connection.prepareStatement(UPDATE_CUSTOMER);
			preparedStatement.setString(1, customer.getCustomerName());
			preparedStatement.setString(2, customer.getCustomerPhoneNumber());
			preparedStatement.setInt(3, customerId);
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

	private Customer findCustomer(int customerId) {
		int count = 0;
		Customer customerAll = null;

		try {
			preparedStatement = connection.prepareStatement(FIND_CUSTOMER);
			preparedStatement.setInt(1, customerId);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				customerAll = new Customer();
				customerAll.setCustomerId(resultSet.getInt(1));
				customerAll.setCustomerName(resultSet.getString(2));
				customerAll.setCustomerPhoneNumber(resultSet.getString(3));
			}
		} catch (SQLException e) {
			System.out.println("Invalid Query or table is empty");
			e.printStackTrace();
		}

		return customerAll;
	}

	private List<Customer> displayCustomer() {
		List<Customer> customer = new ArrayList<>();
		Customer customerAll = null;

		try {
			preparedStatement = connection.prepareStatement(DISPLAY_CUSTOMER);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				customerAll = new Customer();

				customerAll.setCustomerId(resultSet.getInt(1));
				customerAll.setCustomerName(resultSet.getString(2));
				customerAll.setCustomerPhoneNumber(resultSet.getString(3));
				customer.add(customerAll);

			}
		} catch (SQLException e) {
			System.out.println("Invalid Query or table is empty");
			e.printStackTrace();
		}
		return customer;
	}

	private boolean DeleteCustomer(int customerId) {
		int count = 0;
		try {
			preparedStatement = connection.prepareStatement(DELETE_CUSTOMER);
			preparedStatement.setInt(1, customerId);
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

	private boolean userLogin(String phoneNumber) {
	
		boolean status = false;
		try {
			preparedStatement = connection.prepareStatement(LOGIN_CUSTOMER);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				if (resultSet.getString(1).equals(phoneNumber)) {
                   status = true;
                   return status;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;

	}
	
	

	public void customerDoThis(int operationType, int customerId, Customer customer, String PhoneNumber) {

		switch (operationType) {
		case 1: {
			if (addCustomer(customer)) {
				System.out.println("sucess");
			} else {
				System.out.println("failed");
			}
			break;
		}
		case 2: {
			if (updateCustomer(customer, customerId)) {
				System.out.println("sucess");
			} else {
				System.out.println("failed");
			}

			break;
		}
//		case 3: {
//			if ((customerId)) {
//				System.out.println("sucess");
//			} else {
//				System.out.println("failed");
//			}
//			break;
//		}
//		case 4: {
//			customerId(PhoneNumber);
//			break;
//		}
		case 3: {
			
			if(userLogin(PhoneNumber)) {
				System.out.println("Login sucess");
				MenuManagement menuManagement = new MenuManagement();
				menuManagement.doThis(4, 0, null);
			}else {
				System.out.println("failed");
			}
			break;
		}
		default: {
			out.println("Invalid input");
		}
		}
	}

}
