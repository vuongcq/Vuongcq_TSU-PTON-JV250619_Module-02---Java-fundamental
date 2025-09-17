package Session10.Ex2;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    static HashMap<String, Books> books = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("********** MENU QUẢN LÝ SÁCH **********\n" +
                    "1. Thêm sách \n" +
                    "2. Tìm kiếm sách \n" +
                    "3. Hiển thị danh sách \n" +
                    "4. Thoát \n" +
                    "Lựa chọn của bạn:");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    addListBooks(scanner);
                    break;
                case 2:
                    searchBookbyName(scanner);
                    break;
                case 3:
                    displayListBooks();
                    break;
                case 4:
                    System.exit(0);
            }

        } while (true);
    }

    // hàm thêm sách
    public static void addListBooks(Scanner scanner) {
        System.out.println("Nhập số lượng sách muốn nhập:");
        int cntBooks = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < cntBooks; i++) {
            Books book = new Books();
            System.out.printf("Sách thứ %d\n", i + 1);
            book.addBook(scanner);

            // add vào hashMap
            books.put(book.getName(), book);
            System.out.printf("Thêm thành công sách thứ %d!\n", i + 1);
        }
    }

    //Hàm hiển thị
    public static void displayListBooks() {
        for (Books book : books.values()) {
            book.displayBook();
        }
    }

    // hàm tìm kiếm theo tên
    public static void searchBookbyName(Scanner scanner) {
        // duyệt hashMap, tìm phần tử có chứa từ đó, in giá trị ở index đó ra
        boolean found = false;
        System.out.println("Nhập tên sách muốn tìm:");
        String searchName = scanner.nextLine();
        for (Books book : books.values()) {
            if (book.getName().toLowerCase().contains(searchName.toLowerCase())) {
                book.displayBook();
                found = true;
            }
        }
        if (found == false) {
            System.out.println("Không tồn tại sách");
        }
    }

}
