package Session12.ra.business;

import Session12.ra.entity.Product;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductBusiness {
    Scanner scan = new Scanner(System.in);
    static ArrayList <Product> listProducts = new ArrayList<Product>();
    Product products = new Product();
    public static void inputProduct(){


    }

    //  Hàm tự động tăng
    public static int autoIncrementID(){
        if (listProducts.isEmpty()){
            return  1;
        } else {
            int maxId = listProducts.get(0).getProductID();
            for (Product products: listProducts){
                if (maxId < listProducts.get(0).getProductID()){
                    maxId = listProducts.get(0).getProductID();
                }
            }
            return maxId + 1;
        }
    }

    // Hàm thêm sản phẩm
    public static void addProduct(Scanner scanner) {
        System.out.println("Nhập số luượng sản phẩm muốn nhập:");
        int cntProduct = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < cntProduct; i++) {
            System.out.printf("Nhập thông tin sản phẩm %d",i+1);


        }
    }
}


