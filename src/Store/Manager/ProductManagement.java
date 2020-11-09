package Store.Manager;

import Customer.Customer;
import Store.Product.GundamBox;
import Store.Product.Product;
import Store.Product.Transformers;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductManagement {
    Scanner input = new Scanner(System.in);
    private final String productFile = "product.txt";
    private ArrayList<Product> productList = readFile(productFile);
    private final String soldProductFile = "soldProduct.txt";
    private ArrayList<Product> soldList = readFile(soldProductFile);

    private static ProductManagement instanceProductManagement;

    private ProductManagement(){}

    public static ProductManagement getInstance(){
        if(instanceProductManagement == null){
            instanceProductManagement = new ProductManagement();
        }
        return instanceProductManagement;
    }

    public ArrayList<Product> getProductList(){
        return productList;
    }

    public ArrayList<Product> getSoldList() {
        return soldList;
    }


    public void addProduct(Product product){
        if(productList == null){
            productList = new ArrayList<>();
        }
        productList.add(product);
        writeFile(productList, productFile);
    }

    public void update(String idProduct){
        for (Product updateProduct : productList) {
            if (updateProduct.getId().equals(idProduct)) {
                if(updateProduct instanceof GundamBox){
                    inputProductInfo(updateProduct);
                    System.out.println("Nhập size Gundam");
                    ((GundamBox) updateProduct).setSize(input.nextLine());
                }
                if(updateProduct instanceof Transformers){
                    inputProductInfo(updateProduct);
                    System.out.println("Nhập chất liệu sản phẩm");
                    ((Transformers) updateProduct).setMaterial(input.nextLine());
                }
            }
        }
        writeFile(productList, productFile);
    }

    public void delete(String idProduct){
        Product temp = null;
        for (Product deleteProduct : productList) {
            if (deleteProduct.getId().equals(idProduct)) {
                temp = deleteProduct;
            }
        }
        productList.remove(temp);
        writeFile(productList, productFile);
    }

    public void displayAllProduct(){
        if(productList == null || productList.isEmpty()){
            System.err.println("Không còn mặt hàng nào");
        } else {
            for (Product product : productList) {
                System.out.println(product);
            }
        }
    }

    public void displaySoldProduct(){
        if(soldList == null){
            System.err.println("Ế!!!!");
        } else {
            for (Product product : soldList) {
                System.out.println(product);
            }
        }
    }

    public void isProductStocking(){
        for (Product prod : productList) {
            if(prod.isStock()){
                System.out.println(prod.getName() + " còn " + prod.getQuantities());
            } else {
                System.err.println(prod.getName() + " hết hàng");
            }
        }
    }

    public void isIdProductExist(Product product){
        if(productList != null) {
            System.out.println("Nhập ID sản phẩm");
            product.setId(input.nextLine());
            for (Product idProduct : productList) {
                if (idProduct.getId().equals(product.getId())) {
                    System.err.println("Trùng ID");
                    isIdProductExist(product);
                }
            }
        } else {
            System.out.println("Nhập ID sản phẩm");
            product.setId(input.nextLine());
        }
    }

    public void inputProductInfo(Product product){
        isIdProductExist(product);
        System.out.println("Nhập tên sản phẩm");
        product.setName(input.nextLine());
        System.out.println("Nhập số lượng");
        product.setQuantities(Integer.parseInt(input.nextLine()));
        System.out.println("Nhập xuất xứ sản phẩm");
        product.setMadeIn(input.nextLine());
        System.out.println("Nhập giá bán sản phẩm");
        product.setPrice(Double.parseDouble(input.nextLine()));
    }

    public void sellProduct(Customer customer, String idProduct, int purchaseQuantity) throws CloneNotSupportedException {
            Product temp;
            for (Product boughtProduct : ProductManagement.getInstance().getProductList()) {
                if(boughtProduct.getQuantities()<0){
                    System.out.println("Sản phẩm đang hết hàng");
                }
                if(idProduct.equals(boughtProduct.getId())){
                    if(soldList == null){
                        soldList = new ArrayList<>();
                    }
                    temp = boughtProduct.clone();
                    temp.setQuantities(purchaseQuantity);
                    boughtProduct.setQuantities(boughtProduct.getQuantities() - purchaseQuantity);

                    customer.getCart().add(temp);
                    soldList.add(temp);

                }
            }
            writeFile(productList, productFile);
            writeFile(soldList, soldProductFile);
    }







    public void writeFile(ArrayList<Product> products, String fileName){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
            outputStream.writeObject(products);
            outputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Product> readFile(String fileName){
        try {
            FileInputStream fileInputStream = new FileInputStream(fileName);
            ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
            return (ArrayList<Product>) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return null;
        }
    }
}
