package com.hotelmanagement.admin;

import java.util.Scanner;

import com.hotelmanagement.controller.menu.MenuManagement;
import com.hotelmanagement.view.customer.ViewCustomer;
import com.hotelmanagement.view.menu.ViewMenu;

public class Admin {
	MenuManagement menuManagement = new MenuManagement();
	Scanner scan = new Scanner(System.in);
	ViewMenu viewMenu = new ViewMenu();
	ViewCustomer viewCustomer = new ViewCustomer();

	public static void main(String[] args) {
		Admin admin = new Admin();
		admin.menu();

	}

	public void menu() {
		int choice;
		do {
		System.out.println("Welcome Resturent Management");
		System.out.println("1) Hotel Details");
		System.out.println("2) Admin ");
		System.out.println("3) Customer");
		System.out.println("4) Exit");
		System.out.println("Enter the Choice ");
		 choice = scan.nextInt();
		chooseOptionMenu(choice);
		}while(choice<5);
	}

	private void chooseOptionMenu(int choice) {
		
		switch (choice) {
		case 1:

			break;
		case 2:
			viewMenu.adminMenu();
			break;
		case 3:
			viewCustomer.CustomerMenu();
			break;
		case 4:
			System.out.println("Thank you");
			break;

		}

	}

}
