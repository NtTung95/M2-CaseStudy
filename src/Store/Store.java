package Store;

import Store.Employee.Employee;
import Store.Manager.EmployeeManagement;
import Store.Manager.ProductManagement;
import Store.Product.Product;

public class Store {
    private static Store instanceStore;

    private Store(){}

    public static Store getInstanceStore(){
        if(instanceStore == null){
            instanceStore = new Store();
        }
        return instanceStore;
    }

    public double getEmployeeSalary(){
        double employeeSalary = 0;
        for (Employee employee: EmployeeManagement.getInstance().getEmployeeList()) {
            employeeSalary += employee.getSalary();
        }
        return employeeSalary;
    }

    public int getRevenue(){
        int revenue = 0;
        if(ProductManagement.getInstance().getSoldList() == null){
            System.err.println("Chưa có doanh thu");
        } else {
            for (Product soldProduct: ProductManagement.getInstance().getSoldList()) {
                revenue += (soldProduct.getQuantities()*soldProduct.getPrice());
            }
        }
        return (int) (revenue - getEmployeeSalary());
    }
}
