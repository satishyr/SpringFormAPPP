package in.nit.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.nit.bo.EmployeeBO;
import in.nit.bo.EmployeeResultBO;
import in.nit.dao.EmployeeDAO;
import in.nit.dto.EmployeeDTO;
import in.nit.dto.EmployeeResultDTO;

@Service("/empService")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO dao;

	@Override
	public List<EmployeeResultDTO> search(EmployeeDTO dto) {

		List<EmployeeResultDTO> listRDTO = new ArrayList();
		List<EmployeeResultBO> listRBO = null;
		EmployeeBO bo = null;

		bo = new EmployeeBO();

		BeanUtils.copyProperties(bo, dto);

		listRBO = dao.find(bo);

		listRBO.forEach(rbo -> {
			EmployeeResultDTO rdto = new EmployeeResultDTO();
			BeanUtils.copyProperties(rbo, rdto);

			listRDTO.add(rdto);

		});
		return listRDTO;
	}//method

}//class
