package Session16.Ex5;

import java.util.Scanner;

public class MainEx5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MovieManagement movieManagement = new MovieManagement();
        do {
            System.out.println("********** Movie Management\n" +
                    "1. Thêm phim \n" +
                    "2. Liệt kê phim \n" +
                    "3. Sửa phim \n" +
                    "4. Xóa phim \n" +
                    "5. Thoát \n" +
                    "Lựa chọn của bạn");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    movieManagement.addMovie(scanner);
                    break;
                case 2:
                    movieManagement.displayMovie();
                    break;
                case 3:
                    movieManagement.editMovie(scanner);
                    break;
                case 4:
                    movieManagement.deleteMovie(scanner);
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Vui lòng nhập từ 1-5");
                    break;
            }
        } while (true);

    }
}
