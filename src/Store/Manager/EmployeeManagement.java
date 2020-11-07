package Store.Manager;

import Store.Employee.Employee;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeManagement {
    Scanner input = new Scanner(System.in);
    private final String employeeFile = "employee.txt";
    private ArrayList<Employee> employeeList = readFile();

    private static EmployeeManagement instanceEmployeeManagement;

    private EmployeeManagement(){}

    public static EmployeeManagement getInstance(){
        if(instanceEmployeeManagement == null){
            instanceEmployeeManagement = new EmployeeManagement();
        }
        return instanceEmployeeManagement;
    }

    public ArrayList<Employee> getEmployeeList(){
        return employeeList;
    }


    public void addEmployee(Employee employee){
        if(employeeList == null){
            employeeList = new ArrayList<>();
        }
        employeeList.add(employee);
        writeFile(employeeList);
    }

    public void delete(int idEmployee){
        Employee temp = null;
        for (Employee deleteEmployee : employeeList) {
            if (deleteEmployee.getId() == idEmployee) {
                temp = deleteEmployee;
            }
        }
        employeeList.remove(temp);
        writeFile(employeeList);
    }

    public void displayAllEmployee(){
        if(employeeList.isEmpty()){
            System.err.println("Chưa tuyển nhân viên");
        } else {
            for (Employee employee : employeeList) {
                System.out.println(employee);
            }
        }
    }

    public void isIdEmployeeExist(Employee employee){
        if(employeeList != null) {
            System.out.println("Nhập ID nhân viên");
            employee.setId(Integer.parseInt(input.nextLine()));
            for (Employee idEmployee : employeeList) {
                if (idEmployee.getId() == employee.getId()) {
                    System.err.println("Trùng ID");
                    isIdEmployeeExist(employee);
                }
            }
        } else {
            System.out.println("Nhập ID nhân viên");
            employee.setId(Integer.parseInt(input.nextLine()));
        }
    }

    public void inputEmployeeInfo(Employee employee){
        isIdEmployeeExist(employee);
        System.out.println("Nhập tên nhân viên");
        employee.setName(input.nextLine());
        System.out.println("Nhập địa chỉ");
        employee.setAddress(input.nextLine());
        System.out.println("Nhập tuổi nhân viên");
        employee.setAge(Integer.parseInt(input.nextLine()));
        System.out.println("Nhập lương cứng");
        employee.setSalary(Double.parseDouble(input.nextLine()));
    }

    public void writeFile(ArrayList<Employee> employees){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(employeeFile);
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
            outputStream.writeObject(employees);
            outputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Employee> readFile(){
        try {
            FileInputStream fileInputStream = new FileInputStream(employeeFile);
            ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
            return (ArrayList<Employee>) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return null;
        }
    }

}
