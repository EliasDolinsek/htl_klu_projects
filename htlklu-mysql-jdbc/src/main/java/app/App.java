package app;

import dao.Employee;
import dao.EmployeeDao;

import java.util.ArrayList;

public class App {

    public static void main(String[] args) {
        ArrayList<Employee> employees = EmployeeDao.getAllEmployees();
        for(Employee employee:employees){
            System.out.println(employee.toString());
        }
    }
}
