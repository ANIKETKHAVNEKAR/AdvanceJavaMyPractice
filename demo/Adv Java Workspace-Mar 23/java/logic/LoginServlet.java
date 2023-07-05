package logic;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/logincheck")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		con = (Connection)config.getServletContext().getAttribute("jdbccon");
		
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				PrintWriter out = response.getWriter();
				String uid = request.getParameter("uid");
				String pwd = request.getParameter("pwd");
				
//				if(uid.equalsIgnoreCase("Bakul") && pwd.equalsIgnoreCase("aniket")) {
//					out.print("login successfull");
//				}else {
//					out.print("login unsuccesfull");
//				}
				PreparedStatement ps = null;
				ResultSet rs = null ;
				try {
					ps = con.prepareStatement("select * from shoppingdb.users where u_id=? and password=?");
					ps.setString(1, uid);
					ps.setString(2, pwd);
					
					rs = ps.executeQuery();
					if(rs.next()) {
						RequestDispatcher rd = request.getRequestDispatcher("/home");
						
					}
					else {
						response.sendRedirect("/ShoppingApp/login.jsp");
					}
					
					
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				} finally {
					try {
						rs.close();
						ps.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				
			}
		
		
	}


