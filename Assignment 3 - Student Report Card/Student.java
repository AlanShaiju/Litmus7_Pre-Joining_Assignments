package com.litmus7.school.dto;
import java.util.Scanner;
public class Student {
	String studentName;
	int studentRollNumber;
	int marks[]=new int[5];
	
	public void inputDetails() {
		Scanner sc =new Scanner(System.in);
		System.out.print("Enter student name:");
		studentName=sc.nextLine();
		System.out.print("Enter student ID:");
		studentRollNumber=sc.nextInt();
		System.out.println("Enter student marks in 5 subjects:");
		for(int i =0; i<5;i++) {
			System.out.print("Enter marks for subject "+(i+1)+" :");
			marks[i]=sc.nextInt();
		}	
	}
	public float calculateTotal() {
		float total=0;
		for(int i=0;i<marks.length;i++) {
			total+=marks[i];
		}
		return total;
	}
	public float calculateAverage() {
		float average=0;
		for(int i=0;i<marks.length;i++) {
			average+=marks[i];
		}
		average=(float)(average/5);
		return average;
	}
	public String getGrade() {
		float average=calculateAverage();
		if(average>=90) {
			return "Grade A";
		}
		else if(average>=75) {
			return "Grade B";
		}
		else if(average>=60) {
			return "Grade C";
		}
		else if(average>=50) {
			return "Grade D";
		}
		else
			return "Grade F";
		
	}
	public void printReportCard() {
		System.out.println("--- Student Report Card ---");
		System.out.println("Student Name:"+studentName);
		System.out.println("Student Roll Number:"+studentRollNumber);
		System.out.println("Total Marks:"+calculateTotal());
		System.out.println("Average Marks:"+calculateAverage());
		System.out.println(getGrade());
		
	}

}
