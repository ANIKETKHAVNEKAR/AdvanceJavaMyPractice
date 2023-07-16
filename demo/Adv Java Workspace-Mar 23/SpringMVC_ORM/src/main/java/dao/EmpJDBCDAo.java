package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import models.Emp;

public class EmpJDBCDAo {
	
	@Autowired
	JdbcTemplate jtemplate;
	
	
	public List<Emp> getAll()
	{
		//to convert result set into collection
		RowMapper<Emp> rm = new RowMapper<Emp>() {

			@Override
			public Emp mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				return new Emp(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getFloat(4));
			}	
			 
		};
		return jtemplate.query("select * from emp", rm );
		
		
	}
	
	public int save(Emp e)
	{
		return jtemplate.update("insert into emp values(?,?,?,?)", e.getEmpid(),e.getEname(),e.getDeptno(),e.getSalary());
	}
	

}







