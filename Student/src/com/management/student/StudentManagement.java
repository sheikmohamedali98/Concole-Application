package com.management.student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManagement {

	static Scanner scan = new Scanner(System.in);
	static StudentDetailsImplemetation  studentDetails = new StudentDetailsImplemetation();
	static Student student = new Student();
	static List<Student> list = new ArrayList<>();
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int choice;
		outer:
		do {
			System.out.println("1)ADD Student Details");
			System.out.println("2)Update Student Details");
			System.out.println("3)Display Student Details");
			System.out.println("4)Find Student Details");
			System.out.println("5)Delect Student Details");
			System.out.println("6)Exit ");
			System.out.println();
			System.out.println("Enter the Choice");
			 choice = scan.nextInt();
			switch(choice) {
			case 1:
				student = ConnetToMain.studentAdd();
				if(studentDetails.addStudent(student)) {
					System.out.println("Added Sucessfully");
				}else {
					System.out.println("failed");
				}
				break;
				
			case 2:
				student = ConnetToMain.studentUpdate();
				if(studentDetails.updateStudent(student, student.getStudentId())) {
					System.out.println("Update Sucessfully ");
				}else {
					System.out.println("failed ");
					System.out.println(student.getStudentId());
				}
				
				
				break;
			case 3:
				list =  studentDetails.displayStudent();
				System.out.printf("%15s %20s %20s %20s %20s %20s\n", "student_id", "student_name", "email_id","phone_number","age","city ");  

				for(int index = 0;index<list.size();index++) {
					ConnetToMain.displayFormate(list.get(index));
				}
				break;
			case 4:
				int sid = ConnetToMain.returnId();
				student = studentDetails.findStudent(sid);
				System.out.printf("%15s %20s %20s %20s %20s %20s\n", "student_id", "student_name", "email_id","phone_number","age","city ");  

				ConnetToMain.displayFormate(student);
//					System.out.println(student.toString());
//					System.out.println("sucessfull");
			
				break;
			case 5:
				int id = ConnetToMain.returnId();
				if(studentDetails.DeleteStudent(id)) {
					System.out.println("delet sucess");
				}else {
					System.out.println("failed");
				}
				break;
			default:
				break outer;
			
			
			
			}
			 
			 
			
		}while(choice<=5);
		
		
		

	}

}
