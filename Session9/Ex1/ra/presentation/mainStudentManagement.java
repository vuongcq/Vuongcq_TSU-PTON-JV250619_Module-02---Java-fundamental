package Session9.Ex1.ra.presentation;

import Session9.Ex1.ra.entity.Student;

import java.util.Scanner;

public class mainStudentManagement {
    // Khai báo mảng sinh viên
    // Khai báo ở đây để có thể sử dụng cho các phương thức ngoài
    static Student[] arrStudents = new Student[100];
    static int currentIndex = 0;
    static int searchIndex = -1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("********** QUẢN LÝ SINH VIÊN ********** \n" +
                    "1. Hiển thị danh sách sinh viên\n" +
                    "2. Thêm sinh viên \n" +
                    "3. Cập nhật thông tin sinh viên theo mã sinh viên\n" +
                    "4. Xóa sinh viên theo mã sinh viên\n" +
                    "5. TÌm sinh viên theo tên sinh viên\n" +
                    "6. Thoát\n" +
                    "Lựa chọn của bạn:");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    // Hiển thị danh sách sinh viên
                    displayListStudents();
                    break;
                case 2:
                    // thêm sinh viên
                    inputListStudents(sc);
                    break;
                case 3:
                    // Cập nhật thông tin sinh viên theo mã sinh viên
                    searchIdStudent(sc);
                    if (searchIndex == -1) {
                        System.err.println("Mã sinh viên không tồn tại!");
                    } else {
                        System.out.println("Tìm kiếm thành công\n" +
                                "Vui lòng nhập thông tin sinh viên mới.");
                        arrStudents[searchIndex].inputData(sc);
                        System.out.println("Cập nhật thành công!");
                    }
                    break;
                case 4:
                    // Xóa sinh viên theo mã sv
                    delIdStudent();
                    break;
                case 5:
                    // Tìm sinh viên theo tên
                    searchNameStudent();
                    break;
                case 6:
                    // Thoát
                    System.exit(0);
                default:
                    System.err.println("Vui lòng nhập từ 1-6!");
                    break;
            }

        } while (true);
    }

    // khởi tạo phương thức displayListStudents
    public static void displayListStudents() {
        for (int i = 0; i < currentIndex; i++) {
            // in thông tin sinh viên
            arrStudents[i].displayData();
        }
    }

    // khởi tạo phương thức inputData
    public static void inputListStudents(Scanner scanner) {
        System.out.println("Nhập số sinh viên cần nhập thông tin:");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            //khởi tạo phần tử currentIndex là 1 đối tượng sinh viên
            arrStudents[currentIndex] = new Student();
            // Nhập thông tin phần tử sinh viên có chỉ số curentIndex
            System.out.printf("Nhập thông tin sinh viên %d: \n", i + 1);
            arrStudents[currentIndex].inputData(scanner);
            currentIndex++;
        }
    }

    // phương thức tìm kiếm sinh viên theo ID
    public static void searchIdStudent(Scanner scanner) {
        System.out.println("Nhập mã sinh viên:");
        String searchName = scanner.nextLine();

        for (int i = 0; i < currentIndex; i++) {
            if (arrStudents[i].getId().toLowerCase().equalsIgnoreCase(searchName.toLowerCase())) {
                searchIndex = i;
            }
        }
    }

    // Phương thức tìm kiếm sinh viên theo tên
    public static void searchNameStudent (){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào tên sinh viên:");
        String searchName = sc.nextLine();
        for ( int i=0;i<currentIndex;i++){
            if (arrStudents[i].getName().toLowerCase().contains(searchName.toLowerCase())){
                arrStudents[i].displayData();
            }
        }
    }

    // phương thức xóa sinh viên
    // tìm kiếm bằng hàm searchIdStudent() -- đây là hàm tự tạo
    // tìm ra vị trị searchIndex, rồi bắt đầu cho chạy vòng for gán giá trị mảng tại vị trí i= searchIndex (array[searchIndex]) = array[searchIndex+1]
    // chạy đến giá trị CurrentIndex
    // dịch biến currentIndex lùi 1 giá trị

    public static void delIdStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Xóa sinh viên theo ID:");
        searchIdStudent(sc);
        if (searchIndex == -1) {
            System.out.println("Không tìm thấy sinh viên");
        } else {
            for (int i = searchIndex; i < currentIndex; i++) {
                arrStudents[searchIndex] = arrStudents[searchIndex + 1];
            }
            System.out.println("Xóa thành công!");
            currentIndex = currentIndex - 1;
        }
    }

}
