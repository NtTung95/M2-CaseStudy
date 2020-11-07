package Menu;

import Program.ProgramStore;
import Store.Employee.Employee;
import Store.Manager.EmployeeManagement;

import java.util.Scanner;

public class MenuEmployee {
    public static void EmployeeManager(){
        Scanner input = new Scanner(System.in);
        do{
            System.out.println("-----------------------------");
            System.out.println("1.Thêm nhân viên");
            System.out.println("2.Xóa nhân viên");
            System.out.println("3.Hiển thị danh sách nhân viên");
            System.out.println("0.Quay lại");
            System.out.println("-----------------------------");
            int employeeManagerChoice = Integer.parseInt(input.nextLine());
            switch (employeeManagerChoice){
                case 1:
                    Employee employee = new Employee();
                    EmployeeManagement.getInstance().inputEmployeeInfo(employee);
                    EmployeeManagement.getInstance().addEmployee(employee);
                    break;
                case 2:
                    System.out.println("Nhập ID nhân viên cần xóa");
                    EmployeeManagement.getInstance().delete(Integer.parseInt(input.nextLine()));
                    break;
                case 3:
                    System.out.println("---Danh sách nhân viên---");
                    EmployeeManagement.getInstance().displayAllEmployee();
                    break;
                case 0:
                    ProgramStore.programStore();
            }
        }while (true);
    }
}
