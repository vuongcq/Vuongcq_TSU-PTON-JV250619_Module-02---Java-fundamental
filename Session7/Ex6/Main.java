package Session7.Ex6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Category> categoryList = new ArrayList<>(); // Khởi tạo danh sách
        do {
            System.out.println("Menu:\n" +
                    "1: Thêm mới danh mục:\n" +
                    "2. Hiển thị danh sách danh mục:\n" +
                    "3. Cập nhật danh mục:\n" +
                    "4: Xóa danh mục\n" +
                    "5: Tìm kiếm danh mục theo tên: \n" +
                    "6: Thoát\n" +
                    "Nhập lựa chọn của bạn:");
            int input = -1;
            try {
                input = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.err.println("Vui lòng nhập số từ 1-6!");
                continue;
            }

            switch (input) {
                case 1:
                    // thêm mới danh mục
                    System.out.println("Nhập ID danh mục:");
                    int id;
                    try {
                        id = Integer.parseInt(sc.nextLine());
                    } catch (NumberFormatException e) {
                        System.err.println("Vui lòng nhập ID là số");
                        continue;
                    }
                    System.out.println("Nhập tên danh mục:");
                    String name = sc.nextLine();
                    System.out.println("Nhập mô tả danh mục:");
                    String description = sc.nextLine();

                    categoryList.add(new Category(id, name, description));
                    System.out.println("Danh mục đã được thêm");
                    break;
                case 2:
                    // hiển thị danh mục
                    for (int i = 0; i < categoryList.size(); i++) {
                        System.out.printf("Danh sách danh mục: %s \n", categoryList.get(i));
                    }
                    break;
                case 3:// cập nhật danh mục
                    boolean updateFound = false;
                    System.out.println("Nhập ID danh mục cần cập nhật:");
                    int updateId;
                    try {
                        updateId = Integer.parseInt(sc.nextLine());
                    } catch (NumberFormatException e) {
                        System.err.println("Vui lòng nhập ID là số");
                        continue;
                    }
                    for (int i = 0; i < categoryList.size(); i++) {
                        Category p = categoryList.get(i);
                        if (updateId == p.getId()) {
                            System.out.println("Nhập tên mới:");
                            String newName = sc.nextLine();
                            System.out.println("Nhập mô tả mới:");
                            String newDescription = sc.nextLine();
                            p.setName(newName);
                            p.setDescription(newDescription);
                            updateFound = true;
                            System.out.println(" Danh mục đã được cập nhật.");
                            break;
                        }

                    }
                    if (!updateFound) {
                        System.err.println("Không tìm thấy ID.");
                    }
                    break;
                case 4:
                    // xóa danh mục theo ID
                    // Nhập vào ID cần xóa,
                    // vòng for tìm kiếm, nếu có thì thực hiện xóa, nếu k thì hiện ra không có id
                    boolean delFound = false;
                    System.out.println("Nhập ID danh mục cần xóa:");
                    int delId;
                    try {
                        delId = Integer.parseInt(sc.nextLine());
                    }
                    catch (NumberFormatException e) {
                    System.err.println("Vui lòng nhập ID là số");
                    continue;
                }
                    for (int i = 0; i < categoryList.size(); i++) {
                        Category c = categoryList.get(i);
                        if (delId == c.getId()) {
                            categoryList.remove(i);
                            delFound = true;
                            System.out.println("Danh mục đã được xóa");
                            break;
                        }
                    }
                    if (!delFound) {
                        System.err.println("Không tìm thấy ID");
                    }
                    break;
                case 5:
                    // tìm kiếm danh mục theo tên
                    // trim dl đầu vào
                    // so sánh vs c.getName nếu có hiện ra, k thì báo k
                    boolean nameFound = false;
                    System.out.println("Nhập tên danh mục cần tìm:");
                    String searchName = sc.nextLine().trim().toLowerCase();
                    for (int i = 0; i < categoryList.size(); i++) {
                        Category c = categoryList.get(i);
                        if (c.getName().toLowerCase().contains(searchName)) {
                            System.out.println("Danh sách danh mục khớp tên:");
                            System.out.println(categoryList.get(i));
                            nameFound = true;
                        }
                    }
                    if (!nameFound) {
                        System.err.println("Không tìm thấy danh mục nào khớp.");
                    }
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.err.println("Vui lòng nhập từ 1-6");
                    break;
            }
        } while (true);
    }
}
