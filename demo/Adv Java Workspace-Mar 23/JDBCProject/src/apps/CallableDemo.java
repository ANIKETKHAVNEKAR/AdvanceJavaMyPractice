package apps;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class CallableDemo {

	public static void main(String[] args) throws Exception 
	{
		
		
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/test";
		//2. Establish the connection
		Connection con = DriverManager.getConnection(jdbcUrl, "root", "root");
		System.out.println("connection established");
		
		CallableStatement cs = con.prepareCall("{call getSalary(?,?)}");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter emp no : ");
		int eno = Integer.parseInt(br.readLine());
		
		cs.setInt(1, eno);
		cs.registerOutParameter(2, Types.FLOAT);
		
		cs.execute();
		
		System.out.println("Salary : "+cs.getFloat(2));
		
		cs.close();
		con.close();
		br.close();

	}

}






