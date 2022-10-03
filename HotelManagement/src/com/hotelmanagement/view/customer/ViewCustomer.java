package com.hotelmanagement.view.customer;

import java.util.Scanner;

import com.hotelmanagement.admin.Admin;
import com.hotelmanagement.controller.customer.CustomerManagement;
import com.hotelmanagement.model.customer.Customer;
import com.hotelmanagement.view.order.ViewOrder;

public class ViewCustomer {
	
	Scanner scan = new Scanner(System.in);
	Customer customer;
	CustomerManagement customerManagement = new CustomerManagement();
	
	private Customer addCustomer() {
		customer = new Customer();
//		System.out.println("Enter The item Number");
//		int customerId = scan.nextInt();
//		customer.setCustomerId(customerId);
		scan.nextLine();
		System.out.println("Enter the Customer Name ");
		String customeName = scan.nextLine();
		customer.setCustomerName(customeName);
		System.out.println("Enter the Customer Phone Number");
		String phoneNumber = scan.nextLine();
		customer.setCustomerPhoneNumber(phoneNumber);
		return customer;
	}
	
	private int idScanner() {
		System.out.println("Enter The Customer Number");
		int customerId = scan.nextInt();
//		customer.setCustomerId(customerId);;
		return customerId;
	}
	
	private String phoneNumber() {
		System.out.println("Enter the Phone Number");
		String phoneNumber = scan.nextLine();
		return phoneNumber;
	}
	
	public void CustomerMenu() {
		int choice;
		do {
		System.out.println("1) New User");
		System.out.println("2) update Deatils");
		System.out.println("3) Existing customer");
		System.out.println("4) Exit");
		System.out.println("Entert the Option :");
		choice = scan.nextInt();
		scan.nextLine();
		init(choice);
		}while(choice<5);
		

	}
	
	
	
	private void init(int choice) {

		switch (choice) {
		//add customer
		case 1: {
			customerManagement.customerDoThis(1, -1, addCustomer(),"");
			break;

		}
		//update customer
		case 2: {
			customerManagement.customerDoThis(2, idScanner(),addCustomer(),"" );
			break;
		}
//		case 3: {
//			menuManagement.doThis(3, idScanner(), null);
//			break;
//		}
//		case 4: {
//			menuManagement.doThis(4, -1, null);
//			break;
//		}
//		case 5: {
//			menuManagement.doThis(5, -1, null);
//			break;
//		}
		case 3:
			String phoneNumber = phoneNumber();
			customerManagement.customerDoThis(3, -1, null, phoneNumber);
			ViewOrder viewOrder = new ViewOrder();
			viewOrder.orderDetails(phoneNumber);
			break;
		case 4:
			
			System.out.println("Thank you");
			Admin admin = new Admin();
			admin.menu();
			break;
			
			
		case 5 :
			customerManagement.customerDoThis(4, -1, null, phoneNumber());
			break;
		}
		
		

	}

}
