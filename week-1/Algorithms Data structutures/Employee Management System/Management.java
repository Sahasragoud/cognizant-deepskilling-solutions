package com.employeeManagement.system;

import java.util.HashMap;

public class Management {

    private HashMap<Integer, Employee> employees = new HashMap<>();

    // Add Employee
    public void addEmployee(Employee employee) {

        if (employees.containsKey(employee.getEmployeeId())) {
            System.out.println("Employee ID already exists.");
            return;
        }

        employees.put(employee.getEmployeeId(), employee);
        System.out.println("Employee added successfully.");
    }

    // Update Employee
    public void updateEmployee(int employeeId, String name, String position, double salary) {

        Employee employee = employees.get(employeeId);

        if (employee == null) {
            System.out.println("Employee not found.");
            return;
        }

        employee.setName(name);
        employee.setPosition(position);
        employee.setSalary(salary);

        System.out.println("Employee updated successfully.");
    }

    // Delete Employee
    public void deleteEmployee(int employeeId) {

        if (employees.remove(employeeId) != null) {
            System.out.println("Employee deleted successfully.");
        } else {
            System.out.println("Employee not found.");
        }
    }

    // Search Employee
    public Employee getEmployee(int employeeId) {

        Employee employee = employees.get(employeeId);

        if (employee == null) {
            System.out.println("Employee not found.");
        }

        return employee;
    }

    // Display Inventory
    public void displayEmployees() {

        if (employees.isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        }

        for (Employee employee : employees.values()) {
            System.out.println(employee);
        }
    }
}