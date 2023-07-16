package dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import models.*;
public class EmpDAO {

	@Autowired
	HibernateTemplate template;
	
	public List<Emp> getAll()
	{
		return template.loadAll(Emp.class);
	}
	
	public int save(Emp e)
	{
		return (int)template.save(e);
	}
	
	public Emp getEmp(int empid)
	{
		return template.load(Emp.class, empid);
	}
	
	
}
