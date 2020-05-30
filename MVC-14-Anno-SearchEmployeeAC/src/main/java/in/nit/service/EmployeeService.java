package in.nit.service;

import java.util.List;

import in.nit.dto.EmployeeDTO;
import in.nit.dto.EmployeeResultDTO;

public interface EmployeeService {

	public List<EmployeeResultDTO> search(EmployeeDTO dto);
}
