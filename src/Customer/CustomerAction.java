package Customer;

import Store.Manager.CustomerManagement;

public class CustomerAction {
    private static CustomerAction instance;

    private CustomerAction(){}

    public static CustomerAction getInstance(){
        if(instance == null){
            instance = new CustomerAction();
        }
        return instance;
    }


    public void purchasedList(int id){
        for (Customer customer : CustomerManagement.getInstance().getProductList()) {
            if(id == customer.getId()){
                System.out.println(customer.getCart());
            }
        }
    }

}
