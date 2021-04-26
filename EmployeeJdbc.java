package com.te.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeJdbc  implements Jdbc{

	
	
	@Override
	public void insertEmp(int id, String name, Double sal) {
		Connection con=null;
		PreparedStatement stmt=null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ems?user=root&password=root");
		String query="insert into employee values(?,?,?)";
		stmt=con.prepareStatement(query);
		stmt.setInt(1, id);
		stmt.setString(2, name);
		stmt.setDouble(3, sal);
		stmt.execute();
	
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	
	@Override
	public ArrayList<Object> selectAllEmp() {

		ArrayList<Object> ob=null;
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ems?user=root&password=root");
			String query="select * from employee";
			stmt=con.createStatement();
			rs=stmt.executeQuery(query);

			while(rs.next()) {
				System.out.println(rs.getInt("id"));
				System.out.println(rs.getString("name"));
				System.out.println(rs.getInt("sal"));
				System.out.println("..........");
			}		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ob;
	}


	@Override
	public void update(double sal, int id) {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement stmt=null;
		
		try {
		
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ems?user=root&password=root");
			String query="update employee set sal=? where id=?";
			stmt=con.prepareStatement(query);
			stmt.setDouble(1, sal);
			stmt.setInt(2, id);
			stmt.execute();
	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	@Override
	public void deleteEmp(int id) {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement stmt=null;
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ems?user=root&password=root");
		String query="delete from employee where id=?";
		stmt=con.prepareStatement(query);
		stmt.setInt(1, id);
		stmt.execute();
		
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
}
