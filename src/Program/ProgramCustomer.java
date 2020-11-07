package Program;

import Customer.Customer;
import Customer.CustomerAction;
import Store.Manager.CustomerManagement;
import Store.Manager.ProductManagement;

import java.util.Scanner;

public class ProgramCustomer {
    public static void programCustomer() throws CloneNotSupportedException {
        Scanner input = new Scanner(System.in);

        do{
            System.out.println("-----------------------------");
            System.out.println("1.Mua hàng");
            System.out.println("2.Xem hàng");
            System.out.println("3.Xem sản phẩm đã mua");
            System.out.println("0.Exit");
            System.out.println("-----------------------------");
            int programCustomerChoice = Integer.parseInt(input.nextLine());

            switch (programCustomerChoice){
                case 1:
                    if(ProductManagement.getInstance().getProductList().isEmpty()){
                        System.err.println("Hết hàng");
                    } else {
                        //Người dùng nhập thông tin
                        Customer customer = new Customer();
                        CustomerManagement.getInstance().inputCustomerInfo(customer);
                        CustomerManagement.getInstance().addCustomer(customer);

                        //Nhập thông tin và số lượng sản phẩm muốn mua
                        System.out.println("Nhập ID sản phẩm muốn mua");
                        String idProduct = input.nextLine();
                        System.out.println("Nhập số lượng muốn mua");
                        int purchaseQuantity = Integer.parseInt(input.nextLine());
                        ProductManagement.getInstance().sellProduct(customer, idProduct, purchaseQuantity);
                    }
                    break;
                case 2:
                    System.out.println("---Danh sách sản phẩm---");
                    ProductManagement.getInstance().displayAllProduct();
                    break;
                case 3:
                    System.out.println("---Nhập ID khách---");
                    CustomerAction.getInstance().purchasedList(Integer.parseInt(input.nextLine()));
                    break;
                case 0:
                    Main.programMain();
                    break;
            }
        }while(true);
    }

}
