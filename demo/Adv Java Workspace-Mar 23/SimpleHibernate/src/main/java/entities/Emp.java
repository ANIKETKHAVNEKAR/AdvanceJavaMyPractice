package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="emp")
@NamedQuery(name="getBySal",query = "select empid,ename from Emp where salary > :min and salary < :max")
public class Emp {
	
	@Id
	@Column(name="empid") 
	private int empid;
	
	@Column
	String ename;
	
	@Column
	int deptno;
	
	@Column
	float salary;

	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Emp(int empid, String ename, int deptno, float salary) {
		super();
		this.empid = empid;
		this.ename = ename;
		this.deptno = deptno;
		this.salary = salary;
	}

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}
	
	
	

}
