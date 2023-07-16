package apps;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import entities.Emp;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class CriteriaQueryDemo {

	public static void main(String[] args) {
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		
		Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
		
		//actually conn to database
		SessionFactory sf = metadata.getSessionFactoryBuilder().build();
		
		Session session = sf.openSession();
		
		//select * from myemp
		/*
		//1. create a buider
		CriteriaBuilder builder =  session.getCriteriaBuilder();
		
		//2. create criteria query from builder
		CriteriaQuery<Emp> cquery = builder.createQuery(Emp.class);
		
		//specifying from clause
		Root<Emp> root = cquery.from(Emp.class);
		
		//specifying select clause
		cquery.select(root);
		
		Query q = session.createQuery(cquery);
		
		List<Emp> emps = q.getResultList();
		
		for(Emp e : emps)
			System.out.println(e);
		*/
		
		//select empid,salary from myemp
		/*
		//1. create a buider
		CriteriaBuilder builder =  session.getCriteriaBuilder();
				
		//2. create criteria query from builder
		CriteriaQuery<Object[]> cquery = builder.createQuery(Object[].class);
		
		//specifying from clause
		Root<Emp> root = cquery.from(Emp.class);
			
		//specifying select clause
		cquery.multiselect(root.get("empid"),root.get("salary"));
		
		Query q = session.createQuery(cquery);
				
		List<Object[]> emps = q.getResultList();
				
		for(Object[] e : emps)
			System.out.println(e[0]+" : "+e[1]);
		*/
		
		//select empid,salary from myemp where salary > 13000
		//1. create a buider
		CriteriaBuilder builder =  session.getCriteriaBuilder();
		
		//2. create criteria query from builder
		CriteriaQuery<Object[]> cquery = builder.createQuery(Object[].class);
		
		//specifying from clause
		Root<Emp> root = cquery.from(Emp.class);
			
		//specifying select clause
		cquery.multiselect(root.get("empid"),root.get("salary"));
		cquery.where(builder.gt(root.get("salary"), 13000.00f));
				
		Query q = session.createQuery(cquery);
				
		List<Object[]> emps = q.getResultList();
				
		for(Object[] e : emps)
			System.out.println(e[0]+" : "+e[1]);
	}

}
