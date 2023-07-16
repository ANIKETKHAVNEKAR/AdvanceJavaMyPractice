package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name="salaried")
@PrimaryKeyJoinColumn(name = "empid")
public class SalariedEmp extends Emp {
	@Column
	float salary;
	
	@Column
	
	float bonus;

	public SalariedEmp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SalariedEmp(int eid, String name, float salary, float bonus) {
		super(eid, name);
		this.salary = salary;
		this.bonus = bonus;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public float getBonus() {
		return bonus;
	}

	public void setBonus(float bonus) {
		this.bonus = bonus;
	}
	
	
	
	

}
