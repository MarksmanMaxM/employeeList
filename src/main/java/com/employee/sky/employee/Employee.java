package com.employee.sky.employee;

import java.util.Objects;

public class Employee {
    private String firstName;
    private String lastName;


    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setName(String name) {
        this.firstName = name;
    }

    public void setlastName(String lastName) {
        this.lastName = lastName;
    }


    public String getfirstName() {
        return this.firstName;
    }


    public String getlastName() {
        return this.lastName;
    }

    @Override
    public String toString() {
        return "ФИО: " + firstName + " " + lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }
}
