package Program;

import Menu.MenuCustomer;
import Menu.MenuEmployee;
import Menu.MenuProduct;
import Store.Manager.ProductManagement;
import Store.Store;

import java.util.Scanner;

public class ProgramStore {
    public static void programStore(){
        Scanner input = new Scanner(System.in);

        do{
            System.out.println("-----------------------------");
            System.out.println("1.Quản lý sản phẩm");
            System.out.println("2.Quản lý nhân viên");
            System.out.println("3.Quản lý khách hàng");
            System.out.println("4.Xem doanh thu");
            System.out.println("0.Exit");
            System.out.println("-----------------------------");
            int programStoreChoice = Integer.parseInt(input.nextLine());
            switch (programStoreChoice){
                    case 1:
                        MenuProduct.ProductManager();
                        break;
                    case 2:
                        MenuEmployee.EmployeeManager();
                        break;
                    case 3:
                        MenuCustomer.CustomerManager();
                        break;
                        case 4:
                            System.out.println("---Sản phẩm đã bán---");
                        ProductManagement.getInstance().displaySoldProduct();
                        System.out.println("---Lương nhân viên phải trả---");
                        System.out.println(Store.getInstanceStore().getEmployeeSalary());
                        System.out.println("---Doanh thu thực lĩnh cửa hàng---");
                        if(Store.getInstanceStore().getRevenue() < 0){
                            System.err.println("Lỗ");
                        } else {
                            System.out.println(Store.getInstanceStore().getRevenue());
                        }
                        break;
                    case 0:
                        Main.programMain();
                        break;
            }
        } while (true);
    }
}
