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
	
	private static Connection coon = null;
	
	
	public static Connection getConnection() { // conectar com o banco de dados
		if (coon == null) {
			try {
				Properties props = loadProperties();
				String url = props.getProperty("dburl");
				coon = DriverManager.getConnection(url, props);
			}
			catch(SQLException e) {
				throw new DbException(e.getMessage());
			}
			
		}
		return coon;
	}
	
	public static void closeConnection() { // fechar a conexão com o banco de dados
		if (coon != null) {
			try {
				coon.close();
			}
			catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
			
		}
	}
	
	
	
	private static Properties loadProperties() {
		try (FileInputStream fs = new FileInputStream("db.properties")){
			Properties props = new Properties();
			props.load(fs); // carregar os dados de db.properties nesse obj props
			return props;
		} 
		catch (IOException e) {
			throw new DbException(e.getMessage());
		}
	}
	
	public static void closeStatement(Statement st) {
		if (st != null) {
			try {
				st.close();
			}
			catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
			
		}
	}
	
	public static void closeResultSet(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			}
			catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
			
		}
	}

}
