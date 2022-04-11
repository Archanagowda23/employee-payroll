package com.bridgelabz.payroll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeePayrollService {

    public enum IOService {
        CONSOLE_IO, FILE_IO, DB_IO, REST_IO;
    }

    private List<EmployeePayrollData> employeePayrollList;

    public EmployeePayrollService() {

    }

    public EmployeePayrollService(List<EmployeePayrollData> employeePayrollList) {

        this.employeePayrollList = employeePayrollList;
    }

    public static void main(String[] args) {

        Scanner SC = new Scanner(System.in);

        ArrayList<EmployeePayrollData> employeePayrollList = new ArrayList<EmployeePayrollData>();

        EmployeePayrollService employeePayrollService = new EmployeePayrollService(employeePayrollList);

        employeePayrollService.readEmployeeData(SC);

        employeePayrollService.write();
    }

    private void write() {

        System.out.println("Given Employee Data is : " + employeePayrollList);
    }

    private void readEmployeeData(Scanner scanner) {

        System.out.println("Enter your name : ");
        String name = scanner.nextLine();

        System.out.println("Enter your ID : ");
        int id = scanner.nextInt();

        System.out.println("Enter your salary : ");
        double salary = scanner.nextDouble();

        EmployeePayrollData empData = new EmployeePayrollData(id, salary, name);

        employeePayrollList.add(empData);
    }

    public long countEntries(IOService fileIo) {

        return new EmployeePayrollFileIOService().countEntries(employeePayrollList);
    }
}
