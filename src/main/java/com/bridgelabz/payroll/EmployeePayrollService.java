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

        Scanner scanner = new Scanner(System.in);

        ArrayList<EmployeePayrollData> employeePayrollList = new ArrayList<EmployeePayrollData>();

        EmployeePayrollService employeePayrollService = new EmployeePayrollService(employeePayrollList);

        employeePayrollService.readEmployeeData(scanner);

        employeePayrollService.write(IOService.CONSOLE_IO);
    }

    void write(IOService ioService) {
        if (ioService.equals(ioService.CONSOLE_IO))
        /**
         * display the employee data in store in employeePayrollList
         */
            System.out.println("Given Employee Data is : " + employeePayrollList);
        else if (ioService.equals(ioService.FILE_IO))
            new EmployeePayrollFileIOService().writeData(employeePayrollList);
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

    public void printData(IOService fileIo) {
        if (fileIo.equals(IOService.FILE_IO))
            new EmployeePayrollFileIOService().printData((employeePayrollList));
    }

    /**
     * Reading the employee payroll list so that we can do any operation
     */
    public long readEmployeeData(IOService fileIo) {
        List<String> list = new ArrayList<>();
        if (fileIo.equals(IOService.FILE_IO))
            list = new EmployeePayrollFileIOService().readData();
        return list.size();
    }
}