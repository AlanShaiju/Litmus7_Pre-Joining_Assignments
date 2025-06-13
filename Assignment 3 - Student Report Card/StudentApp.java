package com.litmus7.school;

import com.litmus7.school.dto.Student;

public class StudentApp {

	public static void main(String arg[]) {
		Student stud1= new Student();
		stud1.inputDetails();
		Student stud2= new Student();
		stud2.inputDetails();
		Student stud3= new Student();
		stud3.inputDetails();
		stud1.printReportCard();
		stud2.printReportCard();
		stud3.printReportCard();
	}
}
