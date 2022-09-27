package com.management.student;

import java.util.List;

public interface StudentDetailsDAO {
	
	boolean addStudent(Student s);
	boolean updateStudent(Student s,int studentId);
	List<Student> displayStudent();
	Student findStudent(int StudentId);
	boolean DeleteStudent(int StudentId);

}
