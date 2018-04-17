package com.sefakkahriman.employeecontentprovider.data;

import com.sefakkahriman.employeecontentprovider.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeFactory {

    public static List<Employee> createLegendGroups() {

        List<Employee> employeeList = new ArrayList<>();

        employeeList.add(new Employee(1, "John", "504 000 0001"));
        employeeList.add(new Employee(2, "Mike", "504 000 0002"));
        employeeList.add(new Employee(3, "John", "504 000 0003"));
        employeeList.add(new Employee(4, "Rose", "504 000 0004"));
        employeeList.add(new Employee(5, "Julie", "504 000 0005"));
        employeeList.add(new Employee(6, "Martin", "504 000 0006"));

        return employeeList;
    }
}
