package in.nit.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import in.nit.command.EmployeeCommand;
import in.nit.dto.EmployeeDTO;
import in.nit.dto.EmployeeResultDTO;
import in.nit.service.EmployeeService;

@Controller
public class SearchEmployeeController {

	@Autowired
	private EmployeeService service;

	@RequestMapping("/welcome.htm")
	public String showHome() {
		return "search_employee";
	}

	@RequestMapping("/search_emps.htm")
	public String searchEmployees(Map<String, Object> map, @ModelAttribute EmployeeCommand cmd, BindingResult br) {

		System.out.println("start with contr");
		EmployeeDTO dto = null;

		List<EmployeeResultDTO> listRDTO = null;
		dto = new EmployeeDTO();
		// convert cmd to dto
		BeanUtils.copyProperties(cmd, dto);
		// use service

		listRDTO = service.search(dto);
		// keep result as model attribute
		map.put("listRDTO", listRDTO);

		return "show_results";

	}
}
