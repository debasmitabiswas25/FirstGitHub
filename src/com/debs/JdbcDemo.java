package com.debs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDemo {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		Connection con=PropFileDUtil.myConnection();
		//Connection con=DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1524/PDB1", "hr", "hr5");
		Statement st=con.createStatement();
		
		ResultSet rs=st.executeQuery("select city from locations where city like 'S%'");
				
				//("select name from v$pdbs");
		
		while(rs.next())
		{
			System.out.println(rs.getString(1));
		}
		
       con.close();
	}

}
