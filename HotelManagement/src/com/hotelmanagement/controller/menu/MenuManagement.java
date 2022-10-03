package com.hotelmanagement.controller.menu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;
import static java.lang.System.out;

import com.hotelmanagement.model.menu.Menu;
import com.hotelmanagement.server.Server;

public class MenuManagement {
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	Scanner scan = new Scanner(System.in);

	private static final String ADD_MENU = "INSERT INTO  Menu (item_id,item_name,item_price) values (?,?,?)";
	private static final String UPDATE_MENU = "UPDATE Menu SET item_name= ?,item_price = ? WHERE item_id = ?";
	private static final String DELETE_MENU = "DELETE FROM Menu WHERE item_id = ?";
	private static final String FIND_MENU = "SELECT * FROM Menu WHERE item_id = ?";
	private static final String DISPLAY_MENU = "SELECT * FROM Menu";

	public MenuManagement() {
		try {
			connection = DriverManager.getConnection(Server.URL, Server.USERNAME, Server.PASSWORD);
		} catch (SQLException e) {

//			e.printStackTrace();
			System.out.println(e.toString());
			System.out.println("Unnable to connect Server to Sql");
		}
	}

	private boolean addMenu(Menu menu) {
		int count = 0;

		try {
			preparedStatement = connection.prepareStatement(ADD_MENU);
			preparedStatement.setInt(1, menu.getItemId());
			preparedStatement.setString(2, menu.getItemName());
			preparedStatement.setDouble(3, menu.getItemPrice());
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

	private boolean updateMenu(Menu menu,int itemId) {
		int count = 0;

		try {
			preparedStatement = connection.prepareStatement(UPDATE_MENU);
			preparedStatement.setString(1, menu.getItemName());
			preparedStatement.setDouble(2, menu.getItemPrice());
			preparedStatement.setInt(3, itemId);
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

	private List<Menu> displayMenu() {
		List<Menu> menu = new ArrayList<>();
		Menu menuAll = null;

		try {
			preparedStatement = connection.prepareStatement(DISPLAY_MENU);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				menuAll = new Menu();

				menuAll.setItemId(resultSet.getInt(1));
				menuAll.setItemName(resultSet.getString(2));
				menuAll.setItemPrice(resultSet.getDouble(3));
				menu.add(menuAll);

			}
		} catch (SQLException e) {
			System.out.println("Invalid Query or table is empty");
			e.printStackTrace();
		}
		return menu;
	}

	private Menu findItem(int itemId) {
		int count = 0;
		Menu menuAll = null;

		try {
			preparedStatement = connection.prepareStatement(FIND_MENU);
			preparedStatement.setInt(1, itemId);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				menuAll = new Menu();
				menuAll.setItemId(itemId);
				menuAll.setItemName(resultSet.getString(2));
				menuAll.setItemPrice(resultSet.getDouble(3));
			}
		} catch (SQLException e) {
			System.out.println("Invalid Query or table is empty");
			e.printStackTrace();
		}

		return menuAll;
	}

	private boolean deleteMenu(int itemId) {
		int count = 0;
		try {
			preparedStatement = connection.prepareStatement(DELETE_MENU);
			preparedStatement.setInt(1, itemId);
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

	public void doThis(int operationType, int itemId, Menu menu) {
		switch (operationType) {
		case 1: {
			if (addMenu(menu)) {
				System.out.println("sucess");
			} else {
				System.out.println("failed");
			}
			break;
		}
		case 2: {
			if (updateMenu(menu,itemId)) {
				System.out.println("sucess");
			} else {
				System.out.println("failed");
			}
			
			break;
		}
		case 3: {
			if (deleteMenu(itemId)) {
				System.out.println("sucess");
			} else {
				System.out.println("failed");
			}
			break;
		}
		case 4: {
			
			List<Menu> list = displayMenu();
			System.out.printf("%15s %20s %20s \n", "Item Number", "Item Name", "Item Price");  
			System.out.println();
			for(int index = 0;index<list.size();index++) {
			displayFormate(list.get(index));
			}
			
			break;
		}
		case 5: {
			return;
		}
		default: {
			out.println("Invalid input");
		}
		}
	}
	private  void displayFormate(Menu menu) {
		  
		Formatter fmt = new Formatter();  
		
		fmt.format("%10s %7s %17s %3s %20f %3s ",menu.getItemId(),"|",menu.getItemName(),"|" ,menu.getItemPrice(),"|");  
	  
		System.out.println(fmt);    
	}
}
