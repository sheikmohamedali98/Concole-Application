package com.management.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDetailsImplemetation implements StudentDetailsDAO {
	
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	
	private static final String  ADD_STUDENT ="INSERT INTO  student (student_name,email_id,phone_number ,age ,city) values (?,?,?,?,?)"; 
	private static final String  UPDATE_STUDENT ="UPDATE student SET student_name = ?,email_id = ?,phone_number = ?,age = ?,city =? WHERE student_id = ?";
	private static final String  DELETE_STUDENT ="DELETE FROM student WHERE student_id = ?";
	private static final String  DETAIL_STUDENT ="SELECT * FROM student WHERE student_id = ?";
	private static final String  DISPLAY_STUDENT ="SELECT * FROM student";
	
	
	StudentDetailsImplemetation(){
		
		try {
			connection = DriverManager.getConnection(Server.URL,Server.USERNAME, Server.PASSWORD);
		} catch (SQLException e) {
			
//			e.printStackTrace();
			System.out.println(e.toString());
			System.out.println("Unnable to connect Server to Sql");
		}
	}


	@Override
	public boolean addStudent(Student s) {
		 int count = 0;
		
		try {
			preparedStatement = connection.prepareStatement(ADD_STUDENT);
			preparedStatement.setString(1,s.getStudentName());
			preparedStatement.setString(2, s.getEmailId());
			preparedStatement.setString(3, s.getPhoneNumber());
			preparedStatement.setInt(4, s.getAge());
			preparedStatement.setString(5, s.getCity());
			count = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("unable to Excute Qurey");
			e.printStackTrace();
		}
		
		if(count>0) {
			return true;
		}
		return false;
	}


	@Override
	public boolean updateStudent(Student s,int studentId) {
		int count = 0;
		
		
		try {
			System.out.println(studentId);
			preparedStatement = connection.prepareStatement(UPDATE_STUDENT);
			preparedStatement.setString(1, s.getStudentName());
			preparedStatement.setString(2, s.getEmailId());
			preparedStatement.setString(3, s.getPhoneNumber());
			preparedStatement.setInt(4, s.getAge());
			preparedStatement.setString(5, s.getCity());
			preparedStatement.setInt(6, studentId);
			count = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(count>0) {
			return true;
		}
		
		return false;
	}


	@Override
	public List<Student> displayStudent() {
		List<Student> student = new ArrayList<>();
		Student studentsAll = null;
		
		try {
			preparedStatement = connection.prepareStatement(DISPLAY_STUDENT);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				studentsAll = new Student();
				studentsAll.setStudentId(resultSet.getInt(1));
				studentsAll.setStudentName(resultSet.getString(2));
				studentsAll.setEmailId(resultSet.getString(3));
				studentsAll.setPhoneNumber(resultSet.getString(4));
				studentsAll.setAge(resultSet.getInt(5));
				studentsAll.setCity(resultSet.getString(6));
				student.add(studentsAll);
				
			}
		} catch (SQLException e) {
			System.out.println("Invalid Query or table is empty");
			e.printStackTrace();
		}
		
		
		return student;
	}


	@Override
	public Student findStudent(int StudentId) {
		int count = 0;
	Student studentsAll = null;
		
		try {
			preparedStatement = connection.prepareStatement(DETAIL_STUDENT);
			preparedStatement.setInt(1, StudentId);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				studentsAll = new Student();
//				studentsAll.setStudentId(resultSet.getInt(1));
				studentsAll.setStudentName(resultSet.getString(2));
				studentsAll.setEmailId(resultSet.getString(3));
				studentsAll.setPhoneNumber(resultSet.getString(4));
				studentsAll.setAge(resultSet.getInt(5));
				studentsAll.setCity(resultSet.getString(6));
				studentsAll.setStudentId(StudentId);
	
				
			}
		} catch (SQLException e) {
			System.out.println("Invalid Query or table is empty");
			e.printStackTrace();
		}
		
			return studentsAll;
	}


	@Override
	public boolean DeleteStudent(int StudentId) {
		int count = 0; 
		try {
			preparedStatement = connection.prepareStatement(DELETE_STUDENT);
			preparedStatement.setInt(1, StudentId);
			count = preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(count >0)
		{
			return true;
		}
		return false;
	}


	
	

}
