package com.hotelmanagement.view.order;

import java.util.Scanner;

import com.hotelmanagement.controller.orders.OrderManagement;

public class ViewOrder {
	Scanner scan = new Scanner(System.in);
	OrderManagement orderManagement = new OrderManagement();
	String phoneNumber;

	private int getItemId() {
		System.out.println("Enter the item Id");
		int itemId = scan.nextInt();
		return itemId;
	}
	private int getItemQuantity() {
		System.out.println("Enter the item Quantity");
		int itemQuantity = scan.nextInt();
		return itemQuantity;
	}
	private int getOrderId() {
		System.out.println("Enter the Order Id");
		int orderId = scan.nextInt();
		return orderId;
	}

	public void orderDetails(String PhoneNumber) {
		this.phoneNumber = PhoneNumber;
		int choice;
		do {
		System.out.println("1) order");
		System.out.println("2) Delete order");
		System.out.println("3) Display Orders");
		System.out.println("4) Exit");
		System.out.println("Entert the Option :");
		choice = scan.nextInt();
		init(choice);}while(choice<4);
	}
	
	private void init(int choice) {

		switch (choice) {
		case 1: {
			orderManagement.orderDoThis(1, getItemId(), -1, getItemQuantity(),phoneNumber);
			break;

		}
		case 2: {
			orderManagement.orderDoThis(2, -1, getOrderId(), -1,null);
			break;
		}
		case 3: {
			orderManagement.orderDoThis(3, -1, -1, -1, phoneNumber);
			break;
		}
//		case 4: {
//			menuManagement.doThis(4, -1, null);
//			break;
//		}
//		case 5: {
//			System.out.println("Thank You");
//			Admin admin = new Admin();
//			admin.menu();
//			break;
//		}case 6:
//			
//
//			break;
		}

	}
}
