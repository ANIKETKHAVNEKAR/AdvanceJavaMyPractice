package apps;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionTest {

	public static void main(String[] args)throws Exception 
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		String jdbcUrl = "jdbc:mysql://localhost:3306/test";
		Connection con = DriverManager.getConnection(jdbcUrl, "root", "root");
		System.out.println("Connection established");

	}

}
