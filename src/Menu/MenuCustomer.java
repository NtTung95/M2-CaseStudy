package Menu;

import Customer.Customer;
import Program.ProgramStore;
import Store.Manager.CustomerManagement;

import java.util.Scanner;

public class MenuCustomer {
    public static void CustomerManager(){
        Scanner input = new Scanner(System.in);
        do{
            System.out.println("-----------------------------");
            System.out.println("1.Thêm khách hàng");
            System.out.println("2.Xóa khách hàng");
            System.out.println("3.Hiển thị danh sách khách");
            System.out.println("0.Quay lại");
            System.out.println("-----------------------------");
            int customerManagerChoice = Integer.parseInt(input.nextLine());
            switch (customerManagerChoice){
                case 1:
                    Customer customer = new Customer();
                    CustomerManagement.getInstance().isIdCustomerExist(customer);
                    CustomerManagement.getInstance().inputCustomerInfo(customer);
                    CustomerManagement.getInstance().addCustomer(customer);
                    break;
                case 2:
                    System.out.println("Nhập ID khách hàng cần xóa");
                    CustomerManagement.getInstance().delete(Integer.parseInt(input.nextLine()));
                    break;
                case 3:
                    System.out.println("---Danh sách khách hàng---");
                    CustomerManagement.getInstance().displayAllCustomer();
                    break;
                case 0:
                    ProgramStore.programStore();
            }
        }while (true);
    }
}
