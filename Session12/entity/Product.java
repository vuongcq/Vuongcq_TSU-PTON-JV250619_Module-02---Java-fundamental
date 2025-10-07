package ex.ex01.entity;

import ex.ex01.business.ProductBusiness;

import java.util.Scanner;

public class Product implements Comparable<Product> {

    private int productId;
    private String productName;
    private float price;
    private String category;
    private int quantity;

    public Product() {
    }

    public Product(int productId, String productName, float price, String category, int quantity) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.category = category;
        this.quantity = quantity;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
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

    public void inputData(Scanner scanner) {
        this.productId = incrementProductId();
        this.productName = inputProductName(scanner);
        this.price = inputPrice(scanner);
        System.out.println("Nhập vào loại sản phẩm:");
        this.category = scanner.nextLine();
        System.out.println("Nhập vào số lượng tồn kho:");
        this.quantity = Integer.parseInt(scanner.nextLine());
    }

    public int incrementProductId() {
        if (ProductBusiness.listProducts.isEmpty()) {
            return 1;
        }
        int max = ProductBusiness.listProducts.get(0).getProductId();
        for (Product product : ProductBusiness.listProducts) {
            if (product.getProductId() > max) {
                max = product.getProductId();
            }
        }
        return max + 1;
    }

    public String inputProductName(Scanner scanner) {
        System.out.println("Nhập vào tên sản phẩm:");
        do {
            String productName = scanner.nextLine();
            if (productName.length() <= 50 && productName.length() >= 10) {
                boolean isExist = false;
                for (Product product : ProductBusiness.listProducts) {
                    if (product.getProductName().equals(productName)) {
                        isExist = true;
                        break;
                    }
                }
                if (!isExist) {
                    return productName;
                }
                System.err.println("Tên sản phẩm đã tồn tại, vui lòng nhập lại");
            } else {
                System.err.println("Tên sản phẩm phải từ 10-50 ký tự");
            }
        } while (true);
    }

    public float inputPrice(Scanner scanner) {
        System.out.println("Nhập vào giá sản phẩm:");
        do {
            try {
                float price = Float.parseFloat(scanner.nextLine());
                if (price > 0) {
                    return price;
                }
                System.err.println("Giá sản phẩm phải lớn hơn 0, vui lòng nhập lại");
            } catch (Exception e) {
                System.err.println("Giá sản phẩm là số thực, vui lòng nhập lại");
            }
        } while (true);
    }

    @Override
    public String toString() {
        return String.format("Mã SP: %d - Tên SP: %s - Giá: %.1f - Danh mục: %s - Tồn kho: %d",
                this.productId, this.productName, this.price, this.category, this.quantity);
    }

    @Override
    public int compareTo(Product o) {
        return Float.compare(this.price, o.price);
    }
}
