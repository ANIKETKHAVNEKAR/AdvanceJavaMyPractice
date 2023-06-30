package apps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DMLStatement {

	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String jdbcUrl = "jdbc:mysql://localhost:3306/test";
			con = DriverManager.getConnection(jdbcUrl,"root","root");
			
			stmt = con.createStatement();
			
			int n = stmt.executeUpdate("update emp12 set sal = 9999 where empno = 7934");
			
			System.out.println(n + " records updated");
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				stmt.close();
				con.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}

	}

}
