package Session10.Ex3;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static LinkedList<Person> listPersons = new LinkedList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("********** MENU QUẢN LÝ NGƯỜI DÙNG ********** \n" +
                    "1. Thêm người dùng \n" +
                    "2. Xóa người dùng \n" +
                    "3. Hiển thị danh sách người dùng \n" +
                    "4. Thoát \n" +
                    "Lựa chọn của bạn:");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    addListPerson(scanner);
                    break;
                case 2:
                    deleteByEmail(scanner);
                    break;
                case 3:
                    displayListPerson();
                    break;
                case 4:
                    System.exit(0);
            }

        } while (true);
    }

    // Thêm Người dùng

    public static void addListPerson(Scanner scanner) {
        System.out.println("Nhập số người dùng muốn nhập:");
        int cntPerson = Integer.parseInt(scanner.nextLine());

        // khởi tạo đối tượng person
        for (int i = 0; i < cntPerson; i++) {
            Person person = new Person();
            System.out.printf("Nhập người dùng %d\n", i + 1);
            person.addData(scanner);
            listPersons.addLast(person);
        }
    }

    // hiển thị danh sách người dùng
    public static void displayListPerson() {
        for (Person person : listPersons) {
            person.displayPerson();
        }
    }

    // xoá người dùng theo email - tìm đúng email để xoá- có quan tâm hoa thường
    public static void deleteByEmail(Scanner scanner) {
        System.out.println("Nhập email muốn xóa:");
        String delEmail = scanner.nextLine();
        boolean isHas = false;
        for (Person person : listPersons) {
            if (person.getEmail().equals(delEmail)) {
                listPersons.remove(person);
                isHas = true;
            }
        }
        if (isHas == true) {
            System.out.println("Xóa thành công!");
        } else {
            System.err.println("Email không tồn tại.");
        }
    }

}
