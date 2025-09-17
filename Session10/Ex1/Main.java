package Session10.Ex1;

import java.util.Scanner;

public class Main {
    Scanner sc = new Scanner(System.in);
    static Students[] arrStudents = new Students[100];
    static int currentIndex = 0;

    public static void main(String[] args) {
        inputListStudents();
        displayListStudents();
    }

    // Hàm nhập thông tin sinh viên
    public static void inputListStudents() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Số lượng sinh viên muốn nhập:");
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            //khởi tạo phần tử currentIndex là 1 đối tượng sinh viên
            arrStudents[currentIndex] = new Students();
            System.out.printf("Nhập thông tin sinh viên %d: \n", i + 1);
            arrStudents[currentIndex] = InputData.inputStudent(sc);
            currentIndex++;
        }
    }

    // Hàm hiển thị thông tin sinh viên
    public static void displayListStudents() {
        for (int i = 0; i < currentIndex; i++) {
            arrStudents[i].displayStudent();
        }
    }
}
