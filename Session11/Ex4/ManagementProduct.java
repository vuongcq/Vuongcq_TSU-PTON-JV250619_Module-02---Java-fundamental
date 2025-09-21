package Session11.Ex4;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ManagementProduct {
    static Map<Integer, Product> mapProducts = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        do {
            System.out.println("--- Product Management System ---\n" +
                    "1. Add Products \n" +
                    "2. Edit Products \n" +
                    "3. Delete Products \n" +
                    "4. Display Products \n" +
                    "5. Filter Products (Price >100) \n" +
                    "6. Total Value of products \n" +
                    "0. Exit \n" +
                    "Enter your choice:");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    editProduct();
                    break;
                case 3:
                    deleteProduct();
                    break;
                case 4:
                    displayProduct();
                    break;
                case 5:
                    filterProduct();
                    break;
                case 6:
                    sumPriceProduct();
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Vui lòng nhập từ 0-6");
                    break;
            }
        } while (true);
    }

    // Hàm addproducts
    public static void addProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số lượng sản phẩm mua thêm:");
        int cntProducts = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < cntProducts; i++) {
            Product product = new Product();
            System.out.printf("Thêm sản phẩm thứ %d: \n", i + 1);
            product.addData(scanner);
            mapProducts.put(product.getId(), product);
        }
    }

    public static void displayProduct() {
        for (Product product : mapProducts.values()) {
            System.out.println(product);

        }
    }

    public static void editProduct() {
        System.out.println("Nhập vào ID muốn sửa:");
        boolean foundId = false;
        Scanner scanner = new Scanner(System.in);
        int editID = Integer.parseInt(scanner.nextLine());
        for (Product product : mapProducts.values()) {
            if (mapProducts.containsKey(editID)) {
                foundId = true;
                boolean isNotOut = true;
                do {
                    System.out.println("***** MENU SỬA SẢN PHẨM***** \n" +
                            "1. Sửa tên\n" +
                            "2. Sửa giá\n" +
                            "0. Thoát\n" +
                            "lựa chọn của bạn:");
                    int choice = Integer.parseInt(scanner.nextLine());
                    switch (choice) {
                        case 1:
                            System.out.println("Nhập vào tên mới:");
                            String newName = scanner.nextLine();
                            // thêm tên mới theo key ID,
                            mapProducts.get(editID).setName(newName);
                            System.out.println("Thêm Tên mới thành công!");
                            break;
                        case 2:
                            System.out.println("Nhập vào giá mới:");
                            double newPrice = Double.parseDouble(scanner.nextLine());
                            mapProducts.get(editID).setPrice(newPrice);
                            System.out.println("Thêm giá thành công!");
                            break;
                        case 0:
                            isNotOut = false;
                            break;
                        default:
                            System.err.println("Vui lòng nhập từ 0-3");
                            break;
                    }
                } while (isNotOut);
            }
        }
        if (!foundId) {
            System.err.println("Không có ID này");
        }
    }

    public static void deleteProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập ID sản phẩm muốn xóa:");
        int deleteID = Integer.parseInt(scanner.nextLine());
        if (mapProducts.containsKey(deleteID)) {
            mapProducts.remove(deleteID);
            System.out.println("Xóa thành công!");
        } else {
            System.out.println("ID này không tồn tại!");
        }
    }

    public static void filterProduct() {
        // in ra sản phẩm có giá hơn 100
        boolean isExist = false;
        for (Product product : mapProducts.values()) {
            if (product.getPrice() > 100) {
                System.out.println(product);
                isExist = true;
            }
        }
        if (!isExist) {
            System.err.println("Không có phần tử nào!");
        }
    }

    public static void sumPriceProduct() {
        double sum = 0;
        for (Product product : mapProducts.values()) {
            sum = product.getPrice() + sum;
        }
        System.out.println("Tổng giá trị sản phẩm là:" + sum);
    }
}
