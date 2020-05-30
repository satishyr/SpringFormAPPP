package in.nit.dao;

import java.util.List;

import in.nit.bo.EmployeeBO;
import in.nit.bo.EmployeeResultBO;

public interface EmployeeDAO {
	
	public List<EmployeeResultBO>  find(EmployeeBO bo);

	
	

}
