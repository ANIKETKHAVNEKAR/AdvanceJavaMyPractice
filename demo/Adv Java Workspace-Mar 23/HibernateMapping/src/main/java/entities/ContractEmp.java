package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="contract")
@PrimaryKeyJoinColumn(name="empid")
public class ContractEmp extends Emp {
	@Column
	float extraHours;
	
	@Column
	float chargesPerHour;

	public ContractEmp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ContractEmp(int eid, String name, float extraHours, float chargesPerHour) {
		super(eid, name);
		this.extraHours = extraHours;
		this.chargesPerHour = chargesPerHour;
	}

	public float getExtraHours() {
		return extraHours;
	}

	public void setExtraHours(float extraHours) {
		this.extraHours = extraHours;
	}

	public float getChargesPerHour() {
		return chargesPerHour;
	}

	public void setChargesPerHour(float chargesPerHour) {
		this.chargesPerHour = chargesPerHour;
	}
	
	
	
	
}
