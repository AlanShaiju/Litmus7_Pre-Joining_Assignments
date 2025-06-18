package com.litmus7.school.dto;

import java.util.Scanner;

/**
 * This file consists of the 'Student' class and it acts as a DTO class used to
 * store student details such as name, rollnumber, marks of 5 subjects.
 * 
 * @author Alan Shaiju Kurian
 * @version 2.0
 * @since 2025-06-19
 */
public class Student {

	/**
	 * This class lays the foundation for the basic details associated with a
	 * student it also has methods that can be used to retrieve student details as
	 * well as the marks associated with the student.
	 * 
	 * @param name       : Stores the name of the student
	 * @param rollNumber : Stores the rollnumber associated with a student
	 * @param marks[]    : stores the marks for 5 different subject the student has
	 *                   received
	 */
	private String name;
	private int rollNumber;
	private int marks[] = new int[5];

	public void inputDetails() {
		/**
		 * This method is used to store the details into the local variables of the
		 * class. It stores details of the students, such as name, rollnumber, and the
		 * marks associated with the student for 5 subjects
		 */
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter student name:");
		name = scanner.nextLine();
		System.out.print("Enter student ID:");
		rollNumber = scanner.nextInt();
		System.out.println("Enter student marks in 5 subjects:");
		for (int i = 0; i < 5; i++) {
			System.out.print("Enter marks for subject " + (i + 1) + " :");
			marks[i] = scanner.nextInt();
		}
	}

	public float calculateTotal() {
		/**
		 * This method is used to calculate the total marks associated with a student
		 * 
		 * @return Returns the total marks of the student
		 */
		float total = 0;
		for (int n : marks) {
			total += n;
		}
		return total;
	}

	public float calculateAverage() {
		/**
		 * // This method is used to calculate the average marks associated with a
		 * student
		 * 
		 * @return average of the student.
		 */
		float average = calculateTotal();
		average = (float) (average / 5);
		return average;
	}

	enum Grade {
		A, B, C, D, F
	}

	public Grade getGrade() {
		/**
		 * This methods computes the grade of the student based on the average achieved
		 * by the student
		 * 
		 * @return The grade of the student is returned.
		 */
		float average = calculateAverage();

		if (average >= 90) {
			return Grade.A;
		} else if (average >= 75) {
			return Grade.B;
		} else if (average >= 60) {
			return Grade.C;
		} else if (average >= 50) {
			return Grade.D;
		} else
			return Grade.F;
	}

	public void printReportCard() {
		/**
		 * This method is used to display the details such as name, rollnumber, marks
		 * per subject, total marks, average, and grade associated with the student.
		 */
		System.out.println("--- Student Report Card ---");
		System.out.println("Student Name:" + name);
		System.out.println("Student Roll Number:" + rollNumber);
		System.out.println("Total Marks:" + calculateTotal());
		System.out.println("Average Marks:" + calculateAverage());
		System.out.println(getGrade());
	}
}
