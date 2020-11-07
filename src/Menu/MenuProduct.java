package Menu;

import Program.ProgramStore;
import Store.Manager.ProductManagement;
import Store.Product.GundamBox;
import Store.Product.Transformers;

import java.util.Scanner;

public class MenuProduct {
        public static void ProductManager(){
            Scanner input = new Scanner(System.in);
            do{
                System.out.println("-----------------------------");
                System.out.println("1.Thêm sản phẩm");
                System.out.println("2.Xóa sản phẩm");
                System.out.println("3.Sửa sản phẩm");
                System.out.println("4.Hiển thị danh sách sản phẩm");
                System.out.println("5.Kiểm tra hết hàng sản phẩm");
                System.out.println("0.Quay lại");
                System.out.println("-----------------------------");
                int productManagerChoice = Integer.parseInt(input.nextLine());
                switch (productManagerChoice){
                    case 1:
                        System.out.println("1.Gundam");
                        System.out.println("2.Transformers");
                        System.out.println("0.Quay lại");
                        int productType = Integer.parseInt(input.nextLine());
                        switch (productType){
                            case 1:
                                GundamBox gundamBox = new GundamBox();
                                ProductManagement.getInstance().inputProductInfo(gundamBox);
                                System.out.println("Nhập size Gundam");
                                gundamBox.setSize(input.nextLine());
                                ProductManagement.getInstance().addProduct(gundamBox);
                                break;
                            case 2:
                                Transformers transformers = new Transformers();
                                ProductManagement.getInstance().inputProductInfo(transformers);
                                System.out.println("Nhập chất liệu sản phẩm");
                                transformers.setMaterial(input.nextLine());
                                ProductManagement.getInstance().addProduct(transformers);
                                break;
                            case 0:
                                ProductManager();
                                break;
                        }
                        break;
                    case 2:
                        System.out.println("Nhập ID sản phẩm muốn xóa");
                        ProductManagement.getInstance().delete(input.nextLine());
                        break;
                    case 3:
                        System.out.println("Nhập ID sản phẩm cần sửa");
                        ProductManagement.getInstance().update(input.nextLine());
                        break;
                    case 4:
                        System.out.println("---Danh sách sản phẩm---");
                        ProductManagement.getInstance().displayAllProduct();
                        break;
                    case 5:
                        System.out.println("---Tình trạng còn hàng---");
                        ProductManagement.getInstance().isProductStocking();
                        break;
                    case 0:
                        ProgramStore.programStore();
                }
            }while (true);
        }


}
