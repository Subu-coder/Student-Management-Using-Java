package com.org.StudentManagement;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class DeleteStudentData {
	public DeleteStudentData() {
		try {
			FileInputStream fis = new FileInputStream("E:\\JAVA\\Student Database Entry\\lib\\StudentProp.properties");
			Properties prop = new Properties();
			prop.load(fis);
			
			Class.forName(prop.getProperty("driver"));
			Connection con = DriverManager.getConnection(prop.getProperty("url"),prop);
			Statement stmt = con.createStatement();

			Scanner sc = new Scanner(System.in);
			System.out.println("Enter ID You want to delete (to delete all data enter '*' )");
			int id = sc.nextInt();
			int data = stmt.executeUpdate("delete from studentdetails where id ="+id);
			if(data == 0) {
				System.out.println(id+" ID not Found");
			}
			else {
				System.out.println(id + " ID deleted");
			}

		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new DeleteStudentData();
	}
}
