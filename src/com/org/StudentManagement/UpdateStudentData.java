package com.org.StudentManagement;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class UpdateStudentData {

	private int id;
	private Connection con;
	private Statement stmt;
	private boolean flag = true;
	private Scanner sc = new Scanner(System.in);

	public UpdateStudentData() {

		try {
			FileInputStream fis = new FileInputStream("E:\\JAVA\\Student Database Entry\\lib\\StudentProp.properties");
			Properties prop = new Properties();
			prop.load(fis);
			
			Class.forName(prop.getProperty("driver"));
			con = DriverManager.getConnection(prop.getProperty("url"),prop);
			stmt = con.createStatement();

		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
		}

		while (flag) {
			int op = option();

			if (op == 5) {
				System.out.println("------Exited-----");
				flag = false;
			} else if (op == 4) {
				updateData(4);
			} else if (op == 3) {
				updateData(3);

			} else if (op == 2) {
				updateData(2);

			} else if (op == 1) {
				updateData(1);

			} else {
				System.out.println("WRONG INPUT !!!");
			}

		}
	}

	private void updateData(int i) {
		switch (i) {

		case 1:
			System.out.println("Enter new Name:");
			String newName = sc.next();
			try {
				stmt.executeUpdate("update studentdetails set name='" + newName + "' where id= " + id);
				System.out.println("Name Updated");
				flag = doContinue();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;

		case 2:
			System.out.println("Enter new Age:");
			int newAge = sc.nextInt();
			try {
				stmt.executeUpdate("update studentdetails set age='" + newAge + "' where id= " + id);
				System.out.println("Age Updated");
				flag = doContinue();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;

		case 3:
			System.out.println("Enter new Mobile:");
			Long newMobile = sc.nextLong();
			try {
				stmt.executeUpdate("update studentdetails set phone='" + newMobile + "' where id= " + id);
				System.out.println("Mobile Updated");
				flag = doContinue();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;

		case 4:
			System.out.println("Enter new Email:");
			String newEmail = sc.next();
			try {
				stmt.executeUpdate("update studentdetails set email='" + newEmail + "' where id= " + id);
				System.out.println("Email Updated");
				flag = doContinue();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;

		default:
			System.out.println("Wrong Input !!!");
		}
	}

	private boolean doContinue() {
		// TODO Auto-generated method stub
		System.out.println("Do You Want To Continue ? [Y/N] ");
		char f = sc.next().charAt(0);
		if (f == 'Y' || f == 'y') {
			return true;
		} else if (f == 'N' || f == 'n') {
			return false;
		} else {
			return doContinue();
		}
	}

	private int option() {
		System.out.println("\n\nMention ID: ");
		id = sc.nextInt();

		System.out.println("\nWhat Do You want to update ?");
		System.out.println("1 -----> Name:");
		System.out.println("2 -----> Age:");
		System.out.println("3 -----> Phone:");
		System.out.println("4 -----> Email:");
		System.out.println("5 -----> Exit:");

		int op = sc.nextInt();

		return op;

	}

	public static void main(String[] args) {
		new UpdateStudentData();
	}
}
