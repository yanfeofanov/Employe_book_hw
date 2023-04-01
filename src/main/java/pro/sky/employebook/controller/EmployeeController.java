package pro.sky.employebook.controller;

import org.springframework.web.bind.annotation.*;
import pro.sky.employebook.models.Employee;
import pro.sky.employebook.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public String getEmployeeInfo() {
        return "hello !";
    }

    @GetMapping(path = "/add")
    public Employee addEmployee(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        return employeeService.addEmployee(firstName, lastName);
    }

    @GetMapping(path = "/remove")
    public Employee removeEmployee(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {

        return employeeService.removeEmployee(firstName, lastName);
    }

    @GetMapping(path = "/find")
    public Employee findEmployee(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        return employeeService.findEmployee(firstName, lastName);
    }

    @GetMapping(path = "/show")
    public List<Employee> showEmp(){
        return employeeService.getEmployees();
    }





}
