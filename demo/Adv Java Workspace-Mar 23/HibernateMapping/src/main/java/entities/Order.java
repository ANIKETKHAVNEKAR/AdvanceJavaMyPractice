package entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name="orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int oid;
	
	@Column
	String cname;
	
	@OneToMany(mappedBy = "order")
	@Cascade(value = CascadeType.ALL)
	Set<OrderItem> items;

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(String cname, Set<OrderItem> items) {
		super();
		this.cname = cname;
		for( OrderItem oi : items )
			oi.setOrder(this);
		this.items = items;
	}

	public Order(String cname) {
		super();
		this.cname = cname;
	}

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public Set<OrderItem> getItems() {
		return items;
	}

	public void setItems(Set<OrderItem> items) {
		for( OrderItem oi : items )
			oi.setOrder(this);
		this.items = items;
	}
	
	
	
	
}
