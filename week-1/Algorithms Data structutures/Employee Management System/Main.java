package com.employeeManagement.system;

public class Main {
    public static void main(String[] args) {

        Management management = new Management();
        management.addEmployee(new Employee(101, "Shalini", "Asst Manager", 65000));
        management.addEmployee(new Employee(102, "Veda", "HR", 59000));

        System.out.println();

        management.displayEmployees();

        System.out.println();

        management.updateEmployee(102, "Veda", "Manager", 1095364);

        System.out.println();

        System.out.println(management.getEmployee(102));

        System.out.println();

        management.deleteEmployee(101);

        System.out.println();

        management.displayEmployees();
    }
}