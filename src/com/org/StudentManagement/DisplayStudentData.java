package com.org.StudentManagement;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DisplayStudentData {

	public DisplayStudentData() {
		try {
			FileInputStream fis = new FileInputStream("E:\\JAVA\\Student Database Entry\\lib\\StudentProp.properties");
			Properties prop = new Properties();
			prop.load(fis);
			
			Class.forName(prop.getProperty("driver"));
			Connection con = DriverManager.getConnection(prop.getProperty("url"),prop);
			Statement stmt = con.createStatement();
			ResultSet rst = stmt.executeQuery("select * from studentdetails");
			

			System.out.println("\n\n<<------------------------------------------------------>>\n");
			System.out.println("ID\tName\tAge\tPhone\t\tE-Mail");
			System.out.println("---\t-----\t---\t------\t\t-------");
			try {
				while(rst.next()) {
					System.out.print(rst.getInt("id")+"\t");
					System.out.print(rst.getString("name")+"\t");
					System.out.print(rst.getInt("age")+"\t");
					System.out.print(rst.getLong("phone")+"\t");
					System.out.println(rst.getString("email")+"\t");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("\n\n<<------------------------------------------------------>>");
			
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new DisplayStudentData();
	}

}
