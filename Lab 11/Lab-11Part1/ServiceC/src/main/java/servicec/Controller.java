package servicec;

import org.springframework.web.bind.annotation.GetMapping;

public class Controller {
    @GetMapping("/salary")
    public String getEmployeeInfo() {
        return "120.000";
    }
}
