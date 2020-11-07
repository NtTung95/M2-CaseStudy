package Store.Product;

import java.io.Serializable;

public class Product implements Serializable, Cloneable {
    private String id;
    private String name;
    private int quantities;
    private String madeIn;
    private double price;
    private boolean isStock;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantities() {
        return quantities;
    }

    public void setQuantities(int quantities) {
        this.quantities = quantities;
    }

    public String getMadeIn() {
        return madeIn;
    }

    public void setMadeIn(String madeIn) {
        this.madeIn = madeIn;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isStock() {
        this.isStock = this.quantities > 0;
        return isStock;
    }

    public Product clone() throws CloneNotSupportedException {
        return (Product) super.clone();
    }

    @Override
    public String toString() {
        return "ID: " + id +
                ", Tên sp: " + name +
                ", Số lượng: " + quantities +
                ", made In " + madeIn +
                ", Giá: " + price + ", ";
    }
}
