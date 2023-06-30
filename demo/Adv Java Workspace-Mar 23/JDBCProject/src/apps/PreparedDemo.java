package apps;

import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.io.*;

public class PreparedDemo {

	public static void main(String[] args) throws Exception 
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/test";
		//2. Establish the connection
		Connection con = DriverManager.getConnection(jdbcUrl, "root", "root");
		System.out.println("connection established");
		
		PreparedStatement ps = con.prepareStatement("select * from emp where deptno = ? and sal > ?");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter dept no : ");
		int dept = Integer.parseInt(br.readLine());
		System.out.println("Enter min sal : ");
		float sal = Float.parseFloat(br.readLine());
		
		ps.setInt(1, dept);
		ps.setFloat(2, sal);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next())
		{
			System.out.print(rs.getInt(1)+" : ");
			System.out.print(rs.getFloat(6)+" : ");
			System.out.print(rs.getInt(8));
			System.out.println();
		}
		
		rs.close();
		ps.close();
		con.close();
		br.close();
		
	}

}







