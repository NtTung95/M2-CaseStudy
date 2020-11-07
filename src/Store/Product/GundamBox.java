package Store.Product;

public class GundamBox extends Product {
    private String size;

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "GundamBox{" +
                super.toString() +
                "size: " + size +
                "}" ;
    }
}
