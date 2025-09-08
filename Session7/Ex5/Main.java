package Session7.Ex5;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        do {
            boolean choice = true;
            System.out.println("Menu:\n" +
                    "1: Thêm mới sản phẩm\n" +
                    "2: Hiển thị danh sách sản phẩm\n" +
                    "3: Cập nhật sản phẩm\n" +
                    "4: Xóa sản phẩm\n" +
                    "5: Thoát\n" +
                    "Nhập lựa chọn của bạn:\n");
            int input = Integer.parseInt(sc.nextLine());
            switch (input) {
                case 1:
                    // Nhập thông tin sản phẩm
                    System.out.println("Nhập ID sản phẩm:");
                    int id = Integer.parseInt(sc.nextLine());
                    System.out.println("Nhập tên sản phẩm:");
                    String name = sc.nextLine();
                    System.out.println("Nhập giá sản phẩm:");
                    double price = Double.parseDouble(sc.nextLine());

                    products.add(new Product(id, name, price));
                    System.out.println("Sản phẩm đã được thêm.");
                    break;
                case 2:
                    // Hiển thị danh sách sản phẩm
                    System.out.println("Danh sách sản phẩm:");
                    for (int i = 0; i < products.size(); i++) {
                        System.out.println(products.get(i));
                    }
                    break;
                case 3:
                    // Cập nhật sản phẩm
                    // Nhâ id của sản phẩm
                    // cho phép cập nhật name, price
                    System.out.println("Nhập ID của sản phẩm cần cập nhật:");
                    int newId = Integer.parseInt(sc.nextLine());
                    boolean found = false;
                    for (int i = 0; i < products.size(); i++) {
                        Product p = products.get(i); // lấy Product tại vị trí i
                        if (p.getId() == newId) { // kiểm tra ID
                            System.out.println("Nhập tên mới:");
                            String newName = sc.nextLine();
                            System.out.println("Nhập giá mới:");
                            double newPrice = Double.parseDouble(sc.nextLine());
                            p.setName(newName);
                            p.setPrice(newPrice);
                            System.out.println("Sản phẩm đã được cập nhật.");
                            found = true;
                            break; // thoát vòng lặp khi đã cập nhật
                        }
                    }
                    if (!found) {
                        System.err.println("Không tìm thấy sản phẩm bạn tìm kiếm.");
                    }
                    break;
                case 4:
                    // Nhập id của sản phẩm cần xóa và xóa sản phẩm đó
                    System.out.println("Nhập ID sản phẩm muốn xóa");
                    int delID = Integer.parseInt(sc.nextLine());
                    boolean foundDel = false;
                    for (int i = 0; i < products.size(); i++) {
                        Product p = products.get(i);
                        if (delID == p.getId()) {
                            products.remove(i);
                            System.out.println("Sản phẩm đã xóa.");
                            foundDel = true;
                            break;
                        }
                    }
                    if (!foundDel) {
                        System.err.println("Không tìm thấy ID này");
                    }
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.err.println("Vui lòng nhập từ 1-5");
                    break;
            }

        } while (true);

    }
}
