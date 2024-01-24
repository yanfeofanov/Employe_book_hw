package pro.sky.employebook.service;

import org.springframework.stereotype.Service;
import pro.sky.employebook.models.Employee;
import pro.sky.employebook.exception.EmployeeAlreadyAddedException;
import pro.sky.employebook.exception.EmployeeNotFoundException;
import pro.sky.employebook.exception.EmployeeStorageIsFullException;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    private static final int SIZE = 5;
    private final List<Employee> employees = new ArrayList<>(SIZE);


    public Employee addEmployee(String firstName, String lastName) {
        Employee e = new Employee(firstName, lastName);
        if (employees.size() < SIZE) {
            for (Employee emp : employees) {
                if (emp.equals(e)) {
                    throw new EmployeeAlreadyAddedException("Такой сотрудник уже есть");
                }
            }
            employees.add(e);
            return e;
        }
        throw new EmployeeStorageIsFullException("Список сотрудников полон");
    }

    public Employee removeEmployee(String firstName, String lastName) {
        int index = employees.indexOf(new Employee(firstName, lastName));
        if (index == -1) {
            throw new EmployeeNotFoundException("Такого сотрудника нет");
        }
        Employee e = employees.get(index);
        employees.remove(e);
        return e;
    }

    public Employee findEmployee(String firstName, String lastName) {
        int index = employees.indexOf(new Employee(firstName, lastName));
        if (index == -1) {
            throw new EmployeeNotFoundException("Такого сотрудника нет");
        }
        return employees.get(index);
    }

    public List<Employee> getEmployees() {
        return new ArrayList<>(employees);
    }


}
