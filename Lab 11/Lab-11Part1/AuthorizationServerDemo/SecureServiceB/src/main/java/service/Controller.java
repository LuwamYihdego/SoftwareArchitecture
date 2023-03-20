package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {


//	@GetMapping("/salary")
//	public String getGetSalary() {
//		return "95.000";
//	}

	@GetMapping("/employee")
	public String getEmployeeInfo() {
		return "Brhane, phone: 123456";
	}

}

