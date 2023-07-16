package apps;

import entities.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class CompositionSave {

	public static void main(String[] args) 
	{

		//create the service
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
				
		//read the info hibernate.cfg.xml file
		Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
				
		//actually conn to database
		SessionFactory sf = metadata.getSessionFactoryBuilder().build();	

		Session session = sf.openSession();
		
		Address add = new Address("Kothrud","Pune","411038");
		Student st = new Student("Bakul",add);
		
		Transaction tr= session.beginTransaction();
		session.save(st);
		tr.commit();
		
		System.out.println("Student saved");
		
		session.close();
		sf.close();
		
	}

}
