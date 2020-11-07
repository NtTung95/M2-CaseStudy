package Store.Manager;

import Customer.Customer;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class CustomerManagement {
    Scanner input = new Scanner(System.in);
    private final String customerFile = "customer.txt";
    private ArrayList<Customer> customerList = readFile();

    private static CustomerManagement instanceCustomerManagement;

    private CustomerManagement(){}

    public static CustomerManagement getInstance(){
        if(instanceCustomerManagement == null){
            instanceCustomerManagement = new CustomerManagement();
        }
        return instanceCustomerManagement;
    }

    public ArrayList<Customer> getProductList(){
        return customerList;
    }


    public void addCustomer(Customer customer){
        if(customerList == null){
            customerList = new ArrayList<>();
        }
        customerList.add(customer);
        writeFile(customerList);
    }

    public void delete(int idProduct){
        Customer temp = null;
        for (Customer deleteCustomer : customerList) {
            if (deleteCustomer.getId() == idProduct) {
                temp = deleteCustomer;
            }
        }
        customerList.remove(temp);
        writeFile(customerList);
    }

    public void displayAllCustomer(){
        if(customerList.isEmpty()){
            System.err.println("Chưa có khách hàng");
        } else {
            for (Customer customer : customerList) {
                System.out.println(customer);
            }
        }
    }

    public void isIdCustomerExist(Customer customer){
        if(customerList != null) {
            System.out.println("Nhập ID khách hàng");
            customer.setId(Integer.parseInt(input.nextLine()));
            for (Customer idCustomer : customerList) {
                if (idCustomer.getId() == customer.getId()) {
                    System.err.println("Trùng ID");
                    isIdCustomerExist(customer);
                }
            }
        } else {
            System.out.println("Nhập ID khách hàng");
            customer.setId(Integer.parseInt(input.nextLine()));
        }
    }

    public void inputCustomerInfo(Customer customer){
        isIdCustomerExist(customer);
        System.out.println("Nhập tên khách hàng");
        customer.setName(input.nextLine());
        System.out.println("Nhập địa chỉ");
        customer.setAddress(input.nextLine());
        System.out.println("Nhập tuổi khách hàng");
        customer.setAge(Integer.parseInt(input.nextLine()));
    }

    public void writeFile(ArrayList<Customer> customers){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(customerFile);
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
            outputStream.writeObject(customers);
            outputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Customer> readFile(){
        try {
            FileInputStream fileInputStream = new FileInputStream(customerFile);
            ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
            return (ArrayList<Customer>) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return null;
        }
    }
}
