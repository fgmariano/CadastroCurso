package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBResourceManager {
	private static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static String JDBC_URL = "jdbc:mysql://localhost/alunos";
	private static String USER = "root";
	private static String PASSWORD = "root";
	
	private static DBResourceManager instancia;
	private Connection con;
	
	private DBResourceManager() throws ClassNotFoundException, SQLException { 
		Class.forName( JDBC_DRIVER );
		con = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
	}
	
	public static DBResourceManager getInstance() throws ClassNotFoundException, SQLException {
		if (instancia == null) { 
			instancia = new DBResourceManager();
		}
		return instancia;		
	}

	public Connection getCon() {
		return con;
	}
}
