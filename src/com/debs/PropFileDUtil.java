package com.debs;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import oracle.jdbc.pool.OracleConnectionPoolDataSource;
import oracle.jdbc.pool.OracleDataSource;


public class PropFileDUtil  {
	
	private static Properties properties = null;
	private static FileInputStream fis = null;
	private static String jdbcurl;
	private static String user;
	private static String pwd;
	private static OracleDataSource ds; 
	
	//OracleConnectionPoolDataSource ds; works fine with this also
	
	
	static 
	{
		try {
		fis=new FileInputStream("src\\DB.properties");
		properties=new Properties();
		properties.load(fis);
		
		jdbcurl=properties.getProperty("jdbcurl");
		user=properties.getProperty("username");
		pwd=properties.getProperty("password");
	
		} catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public static Connection myConnection() throws SQLException
	{
		
		ds = new OracleConnectionPoolDataSource();
	    ds.setURL(jdbcurl);
	    System.out.println(ds.getURL()); 
	    ds.setUser(user);
	    ds.setPassword(pwd);
	    
	    return ds.getConnection();
	}
	
	
}
