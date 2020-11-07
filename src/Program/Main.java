package Program;

import java.util.Scanner;

public class Main {
    public static void programMain(){
        Scanner input = new Scanner(System.in);
        do{
            try{
                System.out.println("---Chọn vai---");
                System.out.println("1.KHÁCH HÀNG");
                System.out.println("2.QUẢN LÝ CỬA HÀNG");
                System.out.println("0.EXIT");
                int choice = Integer.parseInt(input.nextLine());

                switch (choice){
                    case 1:
                        ProgramCustomer.programCustomer();
                        break;
                    case 2:
                        ProgramStore.programStore();
                        break;
                    case 0:
                        System.exit(0);
                        break;
                }
            } catch (NumberFormatException e){
                System.err.println("Chọn 1 số");
            } catch (CloneNotSupportedException e) {
            }
        }while (true);
    }
    public static void main(String[] args) {
        programMain();
    }
}
