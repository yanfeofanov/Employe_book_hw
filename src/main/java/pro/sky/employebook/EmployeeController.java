package pro.sky.employebook;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    @GetMapping(path = "/hello")
    public String hello(){
        return "hello";
    }
}
