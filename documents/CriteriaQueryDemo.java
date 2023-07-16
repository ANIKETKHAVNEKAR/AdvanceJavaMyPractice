package apps;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import entities.Order;

public class CriteriaQueryDemo {

	public static void main(String[] args) {
StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		
		//read info from xml file
		Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
		
		//establish connection to database
		SessionFactory sf = metadata.getSessionFactoryBuilder().build();
		
		//create session
		Session session = sf.openSession();
		
		
		
		/*CriteriaBuilder cb  = session.getCriteriaBuilder();
		CriteriaQuery<Order> cquery= cb.createQuery(Order.class);
		Root<Order> root= cquery.from(Order.class); */
		//cquery.select(root);
		//cquery.multiselect(root.get("oid"),root.get("cname")).where(cb.gt(root.get("oid"),5));
		//cquery.select(root).where(cb.gt(root.get("oid"),5));
		
		CriteriaBuilder cb  = session.getCriteriaBuilder();
		CriteriaQuery<Long> cquery= cb.createQuery(Long.class);
		Root<Order> root= cquery.from(Order.class);
		cquery.select(cb.count(root));
		Query q = session.createQuery(cquery);
		System.out.println(q.getSingleResult());
	}

}
