package listnerBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


@WebListener
public class ShoppingAppListner implements ServletContextListener {
	Connection con;

    public void contextDestroyed(ServletContextEvent sce)  { 
    	// disconnect connection 
    	
    	
    }

	
    
    
    public void contextInitialized(ServletContextEvent sce)  { 
//      Established connection make connection available to all servlets 
//  	as servlet level context level attribute 
    	
    	String driver = sce.getServletContext().getInitParameter("diverclass");
    	String url = sce.getServletContext().getInitParameter("url");
    	String user = sce.getServletContext().getInitParameter("user");
    	String password = sce.getServletContext().getInitParameter("password");
    	
    	try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			System.out.println("Connection established ");
			sce.getServletContext().setAttribute("jdbc", con);
			System.out.println("context level attt");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
	
}
