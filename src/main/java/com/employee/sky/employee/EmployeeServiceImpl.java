package com.employee.sky.employee;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final int LIMIT = 10;

    List<Employee> empList = new ArrayList<>();

    public EmployeeServiceImpl() {
        this.empList.add(new Employee("Иван", "Иванов"));
        this.empList.add(new Employee("Семён", "Семёнов"));
        this.empList.add(new Employee("Пётр", "Петров"));
        this.empList.add(new Employee("Владимир", "Владимиров"));
        this.empList.add(new Employee("Сидор", "Сидоров"));
        this.empList.add(new Employee("Гавриил", "Гаврилов"));
    }

    @Override
    public int addEmployee(Employee employee) {
        if (this.empList.contains(employee)) {
            System.out.println(this.empList.get(0));
            System.out.println(this.empList.contains(employee));
            return 0;
        }

        if (this.empList.size() + 1 > LIMIT) {
            return -1;
        }

        this.empList.add(employee);
        return 1;
    }

    @Override
    public String removeEmployee(Employee employee) {
        if (this.empList.remove((Employee) employee)) {
            return "Сотрудник удалён";
        } else {
            return "Сотрудник не удалён";
        }
    }

    @Override
    public int seachEmployee(Employee employee) {
        if (this.empList.contains(employee)) {
            return 1;
        } else {
            return -1;
        }

    }

    public String printing() {
        return this.empList.toString();
    }







}
