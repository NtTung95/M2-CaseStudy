package Customer;

import Store.Manager.CustomerManagement;
import Store.Manager.ProductManagement;
import Store.Product.Product;

import java.util.Scanner;

public class CustomerAction {
    Scanner input = new Scanner(System.in);
    private static CustomerAction instance;

    private CustomerAction(){}

    public static CustomerAction getInstance(){
        if(instance == null){
            instance = new CustomerAction();
        }
        return instance;
    }


    public void purchasedList(int id){
        for (Customer customer : CustomerManagement.getInstance().getCustomerList()) {
            if(id == customer.getId()){
                if(customer.getCart().isEmpty() || customer.getCart() == null){
                    System.out.println("Khách hàng " + customer.getName() + " chưa mua sản phẩm nào");
                } else {
                    System.out.println("Khách hàng " + customer.getName() + " đã mua:");
                    for (Product product : customer.getCart()) {
                        System.out.println(product);
                    }
                }
            }
        }
    }

    public void buy() throws CloneNotSupportedException {
        System.out.println("Nhập ID khách");
        int idCus = Integer.parseInt(input.nextLine());

        if(CustomerManagement.getInstance().getCustomerList() == null){
            buyInput(idCus);
        }
        for (Customer cus : CustomerManagement.getInstance().getCustomerList()) {
            if(idCus == cus.getId()){
                System.out.println("Nhập ID sản phẩm muốn mua");
                String idProduct = input.nextLine();
                System.out.println("Nhập số lượng muốn mua");
                int purchaseQuantity = Integer.parseInt(input.nextLine());
                ProductManagement.getInstance().sellProduct(cus, idProduct, purchaseQuantity);
            } else {
                buyInput(idCus);
                break;
            }
        }
        CustomerManagement.getInstance().writeFile(CustomerManagement.getInstance().getCustomerList());
    }

    public void buyInput(int idCus) throws CloneNotSupportedException {
        Customer customer = new Customer();
        customer.setId(idCus);
        CustomerManagement.getInstance().inputCustomerInfo(customer);
        CustomerManagement.getInstance().addCustomer(customer);

        System.out.println("Nhập ID sản phẩm muốn mua");
        String idProduct = input.nextLine();
        System.out.println("Nhập số lượng muốn mua");
        int purchaseQuantity = Integer.parseInt(input.nextLine());
        ProductManagement.getInstance().sellProduct(customer, idProduct, purchaseQuantity);
    }
}
