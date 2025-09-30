package Session12.ra.entity;

import java.util.ArrayList;
import java.util.Scanner;

public class ManagementProduct {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("********** QUẢN LÝ SẢN PHẨM ********** \n" +
                    "1. Thêm sản phẩm \n" +
                    "2. Danh sách sản phẩm \n" +
                    "3. Cập nhật sản phẩm theo mã sản phẩm \n" +
                    "4. Xóa sản phẩm theo mã sản phẩm \n" +
                    "5. Tìm kiếm sản phẩm theo tên \n" +
                    "6. Sắp xếp sản phẩm theo giá tăng dần \n" +
                    "7. Sắp xếp sản phẩm theo số lượng giảm dần \n" +
                    "8. Thoát \n" +
                    "Lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    System.out.println("Đã thoát chương trình!");
                    System.exit(0);
                default:
                    break;
            }

        } while (true);

    }
}
