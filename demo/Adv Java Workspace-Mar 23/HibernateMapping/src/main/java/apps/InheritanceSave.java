package apps;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import entities.*;

public class InheritanceSave {

	public static void main(String[] args) {
		//create the service
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
								
		//read the info hibernate.cfg.xml file
		Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
								
		//actually conn to database
		SessionFactory sf = metadata.getSessionFactoryBuilder().build();	

		Session session = sf.openSession();
				
		Emp e1 = new SalariedEmp(1, "Amit",10000 , 2300);
		Emp e2 = new ContractEmp(2, "Vaibhav", 34, 850);
				
		Transaction tr =session.beginTransaction();
		
		session.save(e1);
		session.save(e2);
		
		tr.commit();
		
		System.out.println("Emps saved");

		session.close();
				
		sf.close();		// TODO Auto-generated method stub

	}

}
