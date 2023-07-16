package apps;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import beans.*;
public class DIApp {

	public static void main(String[] args) 
	{
		ApplicationContext ctx = new ClassPathXmlApplicationContext("appContext.xml");
		Emp e = (Emp)ctx.getBean("emp");  //existing bean instance in the spring container
		Emp e1 = (Emp)ctx.getBean("emp");
		if(e == e1)
		{
			System.out.println("references are equal");
		}
		else
		{
			System.out.println("references are not equal");
		}
		
		System.out.println(e.toString());  //business logic method

	}

}
