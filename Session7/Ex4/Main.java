package Session7.Ex4;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // khởi tạo sinh viên
        // để dễ dàng thao tác thì cho tất cả sv vào 1 mảng
        Student[] arr = new Student[5];

        arr[0] = new Student("An", 19, "A1", 7.0);
        arr[1] = new Student("Bình", 20, "A4", 5.5);
        arr[2] = new Student("Hòa", 4, "A1", 9.5);
        arr[3] = new Student("Khả", 7, "A9", 3.2);
        arr[4] = new Student("Ái", 10, "A5", 8.8);

        // Nhập điểm min max
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào điểm min:");
        float min = Float.parseFloat(sc.nextLine());
        System.out.println("Nhập vào điểm max:");
        float max = Float.parseFloat(sc.nextLine());
        System.out.printf("Danh sách sinh viên có điểm trung bình từ %.1f đến %.1f:\n", min, max);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getAvgScore() > min && arr[i].getAvgScore() < max) {
                System.out.println(arr[i]);
            }
        }

    }
}
