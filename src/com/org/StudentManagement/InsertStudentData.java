package com.org.StudentManagement;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Random;
import java.util.Scanner;

public class InsertStudentData {

	String name, mail;
	int age;
	long phone;

	public InsertStudentData() {
		try {
			FileInputStream fis = new FileInputStream("E:\\JAVA\\Student Database Entry\\lib\\StudentProp.properties");
			Properties prop = new Properties();
			prop.load(fis);
			
			Class.forName(prop.getProperty("driver"));
			Connection con = DriverManager.getConnection(prop.getProperty("url"),prop);
			Statement stmt = con.createStatement();

			dataEntry();

			Random rnd = new Random();
			int id = 1000 + (rnd.nextInt(900) + 100);

			int loc = stmt.executeUpdate("insert into studentdetails values( " + id + ",'" + name + "'," + age + ","
					+ phone + ",'" + mail + "' )");

			System.out.println(loc + " data entered");

			con.close();
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
		}
	}

	private void dataEntry() {
		try{
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter Name:");
			name = sc.next();
			System.out.println("Enter Age:");
			age = sc.nextInt();
			System.out.println("Enter Phone Number:");
			phone = sc.nextLong();
			System.out.println("Enter E-Mail: ");
			mail = sc.next();
		} catch(Exception e) {
			e.printStackTrace();
		}
//		sc.close();
	}

	public static void main(String[] args) {
		new InsertStudentData();
	}

}
