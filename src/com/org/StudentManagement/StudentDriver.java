package com.org.StudentManagement;

import java.util.Scanner;

public class StudentDriver {
	private static boolean flag = true;

	public StudentDriver() {
		while (flag) {
			int option = getOption();
			operation(option);
		}
	}

	private void operation(int option) {
		switch (option) {
		case 1:
			new InsertStudentData();
			break ;

		case 2:
			new UpdateStudentData();
			break ;

		case 3:
			new DeleteStudentData();
			break ;

		case 4:
			new DisplayStudentData();
			break ;

		case 5:
			System.out.println("\n." + "\n.." + "\n..." + "... Exited");
			System.exit(0);
			break ;

		default:
			System.out.println("WRONG INPUT !!! TRY AGAIN ...");
			break ;
		}
	}

	private int getOption() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\n\n<----- STUDENT DATABASE ------>");
		System.out.println("Choose Option to perform Operation: ");
		System.out.println("'1' -----> Insert Data");
		System.out.println("'2' -----> Update Data");
		System.out.println("'3' -----> Delete Data");
		System.out.println("'4' -----> Display Data");
		System.out.println("'5' -----> EXIT");
		System.out.print("\nINPUT: --> ");
		int option = sc.nextInt();
		return option;
	}

	public static void main(String[] args) {
		new StudentDriver();
	}

}
