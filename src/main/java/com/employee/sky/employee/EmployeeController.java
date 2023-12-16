package com.employee.sky.employee;

import com.employee.sky.employee.Exceptions.EmployeeAlreadyAddedException;
import com.employee.sky.employee.Exceptions.EmployeeNotFoundException;
import com.employee.sky.employee.Exceptions.EmployeeStorageIsFullException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @GetMapping("/add")
    public String addEmployee(@RequestParam("firstname") String firstname, @RequestParam("lastname") String lastname) {


        Employee employee = new Employee(firstname, lastname);
        EmployeeServiceImpl employeeServiceImpl = new EmployeeServiceImpl();

        try {
            if (employeeServiceImpl.addEmployee(employee) == -1) {
                throw new EmployeeStorageIsFullException();
            }
            if (employeeServiceImpl.addEmployee(employee) == 0) {
                throw new EmployeeAlreadyAddedException();
            }
        } catch (EmployeeStorageIsFullException e) {
            return "Превышен лимит сотрудников";
        } catch (EmployeeAlreadyAddedException e) {
            return "Этот сотрудник уже есть";
        }

        return "Сотрудник добавлен";

    }

    @GetMapping("/remove")
    public String remEmployee(@RequestParam("firstname") String firstname, @RequestParam("lastname") String lastname) {
        Employee employee = new Employee(firstname, lastname);
        EmployeeServiceImpl employeeServiceImpl = new EmployeeServiceImpl();
        return employeeServiceImpl.removeEmployee(employee);
    }

    @GetMapping("/seach")
    public String seachEmployee(@RequestParam("firstname") String firstname, @RequestParam("lastname") String lastname) {
        Employee employee = new Employee(firstname, lastname);
        EmployeeServiceImpl employeeServiceImpl = new EmployeeServiceImpl();
        try {
            if (employeeServiceImpl.seachEmployee(employee) == -1) {
                throw new EmployeeNotFoundException();
            }
        } catch (EmployeeNotFoundException e) {
            return "Сотрудник не найден";
        }
        return "Сотрудник найден";
    }

    @GetMapping("/print")
    public String printBrowser () {

        EmployeeServiceImpl employeeServiceImpl = new EmployeeServiceImpl();
        return employeeServiceImpl.printing();
    }







}
