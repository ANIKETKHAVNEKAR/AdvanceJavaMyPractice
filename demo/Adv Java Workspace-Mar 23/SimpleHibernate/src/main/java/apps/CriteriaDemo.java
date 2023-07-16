package apps;

import javax.persistence.criteria.CriteriaBuilder;

import java.util.List;

import javax.persistence.criteria.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import entities.*;

public class CriteriaDemo {

	public static void main(String[] args) {
		//create the service
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
						
		//read the info hibernate.cfg.xml file
		Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
						
		//actually conn to database
		SessionFactory sf = metadata.getSessionFactoryBuilder().build();
				
		//open the session
		Session session = sf.openSession();
		
		//create - select * from emp / from Emp
		/*
		//1.create criteriabuilder instance
		CriteriaBuilder cb = session.getCriteriaBuilder();
		
		//2.create criteriaquery instance
		CriteriaQuery<Emp> cquery = cb.createQuery(Emp.class);
		
		//3.specify the root(table from which the records)
		Root<Emp> root = cquery.from(Emp.class);
		
		//4 specify the properties to be selected
		cquery.select(root);
				
		//5. prepare the query from the criteria
		Query q = session.createQuery(cquery);
		
		//6. get the result(list) from the query
		List<Emp> emps = q.getResultList();
		
		for(Emp e : emps)
			System.out.println(e.getEmpid()+" : "+e.getEname());
		*/
		
		//select empid,ename from EMP
		//1.create criteriabuilder instance
		CriteriaBuilder cb = session.getCriteriaBuilder();
				
		//2.create criteriaquery instance
		CriteriaQuery<Object[]> cquery = cb.createQuery(Object[].class);
				
		//3.specify the root(table from which the records)
		Root<Emp> root = cquery.from(Emp.class);
				
		//4 specify the properties to be selected
		cquery.multiselect(root.get("empid"),root.get("ename"));
						
		//5. prepare the query from the criteria
		Query q = session.createQuery(cquery);
				
		//6. get the result(list) from the query
		List<Object[]> emps = q.getResultList();
				
		for(Object[] e : emps)
			System.out.println(e[0]+" : "+e[1]);
		
		
		session.close();
		
		sf.close();
	}

}
