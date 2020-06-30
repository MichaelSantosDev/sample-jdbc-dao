package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DB {
	
	private static Connection connection = null;
	
	public static Connection getConnection() {
		
		try {
			if(connection == null) {
				Properties p = loadProperties();
				String url = p.getProperty("dburl");
				connection = DriverManager.getConnection(url, p);
			}			
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
		}		
		return connection;
	}
	
	
	public static void closeConnection() {		
		try {			
			if(connection != null) {
				connection.close();				
			}			
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
		}	
		
	}
	
	
	
	private static Properties loadProperties() {
		
		try(FileInputStream fs = new FileInputStream("db.properties")){
			Properties properties = new Properties();
			properties.load(fs);
			return properties;			
			
		}catch(IOException e) {
			throw new DbException(e.getMessage());				
		}		
	}
	
	
	public static void closeStatement(Statement st) {		
		try {			
			if(st != null) {
				st.close();				
			}			
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
		}	
		
	}
	
	
	public static void closeResultSet(ResultSet rs) {		
		try {			
			if(rs != null) {
				rs.close();				
			}			
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
		}	
		
	}

}
