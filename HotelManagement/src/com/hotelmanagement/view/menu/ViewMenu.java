package com.hotelmanagement.view.menu;

import java.util.Scanner;
import java.util.function.IntToDoubleFunction;

import com.hotelmanagement.admin.Admin;
import com.hotelmanagement.controller.menu.MenuManagement;
import com.hotelmanagement.model.menu.Menu;

public class ViewMenu {
	Scanner scan = new Scanner(System.in);
	Menu menu;
	static MenuManagement menuManagement = new MenuManagement();

	public ViewMenu() {

	}

	private Menu addMenu() {
		menu = new Menu();
//		System.out.println("Enter The item Number");
//		int itemNumber = scan.nextInt();
//		menu.setItemId(itemNumber);
		
		System.out.println("Enter the item Name");
		String itemName = scan.next();
		menu.setItemName(itemName);
		System.out.println("Enter the item Price");
		Double itemPrice = scan.nextDouble();
		menu.setItemPrice(itemPrice);
		return menu;
	}

	private int idScanner() {
		System.out.println("Enter The item Number");
		int itemNumber = scan.nextInt();
		menu.setItemId(itemNumber);
		return itemNumber;
	}
//	   
//	   public static void main(String[] args) {
//		   
//		   int choce = scan.nextInt();
//		   MenuManagement menuManagement = new MenuManagement();
//		   ViewMenu viewMenu = new ViewMenu();
//		  menuManagement.init(choce, viewMenu.addMenu(), 0);
//		   
//	   }

	public void adminMenu() {
		int choice;
		do {
		System.out.println("1) Add Items");
		System.out.println("2) update Items");
		System.out.println("3) Delete Items");
		System.out.println("4) Display Items");
		System.out.println("5) Exit");
		System.out.println("Entert the Option :");
		choice = scan.nextInt();
		init(choice);}while(choice<6);

	}

	private void init(int choice) {

		switch (choice) {
		case 1: {
			menuManagement.doThis(1, -1, addMenu());
			break;

		}
		case 2: {
			menuManagement.doThis(2, idScanner(), addMenu());
			break;
		}
		case 3: {
			menuManagement.doThis(3, idScanner(), null);
			break;
		}
		case 4: {
			menuManagement.doThis(4, -1, null);
			break;
		}
		case 5: {
			System.out.println("Thank You");
			Admin admin = new Admin();
			admin.menu();
			break;
		}case 6:
			

			break;
		}

	}

}
