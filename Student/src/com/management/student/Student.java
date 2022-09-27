package com.management.student;

public class Student {
	
	private int studentId;
	private String studentName;
	private String emailId;
	private String phoneNumber;
	private int age;
	private String city;
	
	public Student()
	{
		
	}
	public Student(String studentName, String emailId, int age, String phoneNumber, String city) {
		super();
		this.studentName = studentName;
		this.emailId = emailId;
		this.age = age;
		this.phoneNumber = phoneNumber;
		this.city = city;
	}
	
	
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", emailId=" + emailId
				+ ", phoneNumber=" + phoneNumber + ", age=" + age + ", city=" + city + "]";
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	
}
