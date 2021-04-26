package com.te.jdbc;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class EmployeeJdbcTest {

	@Test
	void testInsertEmp() {
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ems?user=root&password=root");
		EmployeeJdbc empj=new EmployeeJdbc();
		empj.insertEmp(10, "kaveri", 44500.0);
		String query="select * from Employee";
		stmt=con.createStatement();
		 rs=stmt.executeQuery(query);
		 assertEquals(10, rs.getInt(1));
		 assertEquals("kaveri", rs.getString(2));
		 assertEquals(44500.0, rs.getDouble(3));
	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	@Test
	void testSelectAllEmp() {
		EmployeeJdbc empj=new EmployeeJdbc();

		ArrayList<Object> obj=empj.selectAllEmp();
		assertEquals(obj!=null, false);
	}
	
	@Test
	void testUpdate() {
		
		Connection con=null;
		Statement stmt=null;
		
		try {
		
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ems?user=root&password=root");
			EmployeeJdbc empj=new EmployeeJdbc();
			empj.update(56789.0, 10);
			String query="select * from Employee";
			stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			assertEquals("56789", rs.getString(2));
	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}



	@Test
	void testDeleteEmp() {
		

		Connection con=null;
		Statement stmt=null;
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ems?user=root&password=root");
		EmployeeJdbc empj=new EmployeeJdbc();
		empj.deleteEmp(10);
		String query="select * from Employee";
		stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery(query);
		assertEquals(rs.next(), false);
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	


}
