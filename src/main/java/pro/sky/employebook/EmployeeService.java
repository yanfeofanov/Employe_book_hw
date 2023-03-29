package pro.sky.employebook;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    List<Employee> employees = new ArrayList<>();


    public List<Employee> getInfo() {
        return new ArrayList<>(employees);
    }

    public Employee addEmployee(String firstName, String lastName) {
        employees.add(new Employee(firstName, lastName));
        int index = employees.indexOf(new Employee(firstName, lastName));
        return employees.get(index);
    }

    public Employee removeEmployee(String firstName, String lastName) {
        int index = employees.indexOf(new Employee(firstName, lastName));
        if(index == -1){
            throw new EmployeeNotFoundException("Такого сотрудника нет");
        }
        Employee e = employees.get(index);
        employees.remove(e);
        return e;
    }

    public Employee findEmployee(String firstName, String lastName) {
        int index = employees.indexOf(new Employee(firstName, lastName));
        if(index == -1){
            throw new EmployeeNotFoundException("Такого сотрудника нет");
        }
        return employees.get(index);
    }


}
