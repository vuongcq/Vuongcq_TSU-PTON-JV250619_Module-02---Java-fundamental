package Session12.ra.entity;

import java.util.Scanner;

public class Product {
    // Khai báo hàm
    private int productID;
    private String productName;
    private double price;
    private String category;
    private int quantity;

    //COnstructor

    public Product() {
    }

    public Product(int quantity, String category, double price, String productName, int productID) {
        this.quantity = quantity;
        this.category = category;
        this.price = price;
        this.productName = productName;
        this.productID = productID;
    }

    // getter- setter

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // input Data

    public void inputData(Scanner scanner){
            System.out.println("Nhập tên sản phẩm:");
            this.productName = scanner.nextLine();
            System.out.println("Nhập giá sản phẩm:");
            this.price = Double.parseDouble(scanner.nextLine());
            System.out.println("Nhập loại sản phẩm");
            this.category = scanner.nextLine();
            System.out.println("Nhập số lượng tồn kho");
            this.quantity = Integer.parseInt(scanner.nextLine());
    }

    @Override
    public String toString() {
        return "Product{" +
                "productID=" + productID +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
