package com.employee.sky.employee;

import com.employee.sky.employee.Exceptions.EmployeeAlreadyAddedException;
import com.employee.sky.employee.Exceptions.EmployeeNotFoundException;
import com.employee.sky.employee.Exceptions.EmployeeStorageIsFullException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    EmployeeServiceImpl employeeServiceImpl = new EmployeeServiceImpl();


    @GetMapping("/add")
    public String addEmployee(@RequestParam("firstname") String firstname, @RequestParam("lastname") String lastname) {


        Employee employee = new Employee(firstname, lastname);

        int check = employeeServiceImpl.addEmployee(employee);

        try {
            if (check == -1) {
                throw new EmployeeStorageIsFullException();
            }
            if (check == 0) {
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
        return employeeServiceImpl.removeEmployee(employee);
    }

    @GetMapping("/seach")
    public String seachEmployee(@RequestParam("firstname") String firstname, @RequestParam("lastname") String lastname) {
        Employee employee = new Employee(firstname, lastname);
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

        return employeeServiceImpl.printing();
    }







}
