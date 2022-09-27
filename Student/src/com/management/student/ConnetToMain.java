package com.management.student;

import java.util.Formatter;
import java.util.Scanner;

public class ConnetToMain {
	static Scanner scan = new Scanner(System.in);
	static Student s;
	public static Student studentAdd() {
		 s = new Student();
		System.out.println("Enter Student Name:");
		String name = scan.nextLine();
		s.setStudentName(name);
		System.out.println("Enter Student EmailId:");
		String email = scan.nextLine();
		s.setEmailId(email);
		System.out.println("Enter Student Phone Number:");
		String phone = scan.nextLine();
		s.setPhoneNumber(phone);
		System.out.println("Enter the Student age ");
		int age = scan.nextInt();
		s.setAge(age);
		System.out.println("Enter Student City:");
		String city = scan.next();
		s.setCity(city);
		
		
		return s;
	}
	
	public static int returnId() {
		System.out.println("Enter student id :");
		int id = scan.nextInt();
		return id;
	}
	
	public static Student studentUpdate() {
		s = new Student();
		System.out.println("Enter Student Name:");
		String name = scan.nextLine();
		s.setStudentName(name);
		System.out.println("Enter Student EmailId:");
		String email = scan.nextLine();
		s.setEmailId(email);
		System.out.println("Enter Student Phone Number:");
		String phone = scan.nextLine();
		s.setPhoneNumber(phone);
		System.out.println("Enter the Student age ");
		int age = scan.nextInt();
		s.setAge(age);
		System.out.println("Enter Student City:");
		String city = scan.next();
		s.setCity(city);
		System.out.println("Enter Student Id :");
		int studentId = scan.nextInt();
		s.setStudentId(studentId);
		return s;
		
	}
	
	public static void displayFormate(Student s) {
	  
		Formatter fmt = new Formatter();  
		
		fmt.format("%10s %7s %17s %3s %20s %3s %15s %3s %10d %3s %17s",s.getStudentId(),"|",s.getStudentName(),"|" ,s.getEmailId(),"|",s.getPhoneNumber(),"|",s.getAge(),"|",s.getCity());  
	  
		System.out.println(fmt);    
	}

	
}
