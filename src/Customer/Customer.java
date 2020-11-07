package Customer;

import Entities.Person;
import Store.Product.Product;

import java.util.ArrayList;

public class Customer extends Person {
    private ArrayList<Product> cart = new ArrayList<>();

    public ArrayList<Product> getCart() {
        return cart;
    }

    @Override
    public String toString() {
        return "Customer{" +
                super.toString() +
                "} ";
    }
}
