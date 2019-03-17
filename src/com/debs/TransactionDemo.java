package com.debs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionDemo
{
	 private static String SQLQuery1 = "insert into orders1 values (?,?,?,?)";
	 private static String SQLQuery2 = "insert into orders2 values (?,?,?)";
	 
	 public static void main(String[] args) throws Exception
	 {
	  Connection con=null;
	try
	{
	  con=DriverManager.getConnection("jdbc:oracle:thin:hr/hr4@localhost:1524/pdb1"); 
	  con.setAutoCommit(true); 

	  InsertIntoOrders2(con,11,852,76);
	  //InsertIntoOrders1(con,11,"ythjklouitescvhnnb",852,76);

	  //con.commit();
	}catch(SQLException e){ System.out.println("SQL Exception "+e.getMessage()); }// con.rollback();}
	 catch(Exception e) { System.out.println("Other Exception "+e.getMessage()); }//con.rollback(); }
	 
	finally
	{
	showTable(con,"orders1");
	showTable(con,"orders2"); 
	 if(con!= null)
	 con.close();
	}
	}

	 public static void InsertIntoOrders1(Connection con,int orderid,String status,int custid,float ordertol) throws SQLException
	 {
	  PreparedStatement pst=con.prepareStatement(SQLQuery1); 
	  pst.setInt(1,orderid);
	  pst.setString(2,status);
	  pst.setInt(3,custid);
	  pst.setFloat(4,ordertol);

	  pst.executeUpdate(); 
	  System.out.println("Record inserted into Orders1 successfully"); 
	  pst.close(); 
	} 

	 public static void InsertIntoOrders2(Connection con,int orderid,int custid,float ordertol) throws SQLException
	 {
	  PreparedStatement pst=con.prepareStatement(SQLQuery2); 
	  pst.setInt(1,orderid);
	   pst.setInt(2,custid);
	  pst.setFloat(3,ordertol);

	  pst.executeUpdate(); 
	  System.out.println("Record inserted into Orders2 successfully"); 
	  pst.close(); 
	} 
	 

	public static void showTable(Connection con,String Tablename) throws SQLException
	{
	  Statement st=con.createStatement();
	  ResultSet rs=st.executeQuery("select * from "+Tablename);

	  if(Tablename.equalsIgnoreCase("orders1"))
	{
	 System.out.println("Orders1 Records");
	  while(rs.next())
	{
	 System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3)+"\t"+rs.getFloat(4));
	}   
	}
	else
	{
	  System.out.println("Orders2 Records");
	  while(rs.next())
	{
	 System.out.println(rs.getInt(1)+"\t"+rs.getInt(2)+"\t"+rs.getFloat(3));
	}

	}
	 
	rs.close();
	st.close(); 
	}
	}