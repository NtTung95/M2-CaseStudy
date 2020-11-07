package Store.Product;

public class Transformers extends Product {
    private String material;

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public String toString() {
        return "Transformers{" +
                super.toString() +
                "Chất liệu: " + material +
                "}";
    }
}
