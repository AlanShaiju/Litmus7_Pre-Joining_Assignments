package com.litmus7.school;

/**
 * This program implements the DTO class 'Student'
 * It is used to retrieve the data for different students from 
 * the user and display it.
 * 
 * @author Alan Shaiju Kurian
 * @version 2.0
 * @since 2025-06-19
 */

import com.litmus7.school.dto.Student;

public class StudentApp {

	public static void main(String arg[]) {
		Student student1 = new Student();
		student1.inputDetails();
		Student student2 = new Student();
		student2.inputDetails();
		Student student3 = new Student();
		student3.inputDetails();
		student1.printReportCard();
		student2.printReportCard();
		student3.printReportCard();

	}
}
