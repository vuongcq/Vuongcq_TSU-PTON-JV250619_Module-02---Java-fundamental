package Session4.Ex6;

import java.util.Arrays;
import java.util.Scanner;

public class Sapxep {
    public static void main(String[] args) {
        // Sắp xếp mảng giảm dần và tìm kiếm số
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập kích thước mảng:");
        int n = Integer.parseInt(sc.nextLine());
        int[] arr = new int[n];

        // nhập Giá trị cho mảng
        for (int i = 0; i < n; i++) {
            System.out.printf("Nhập phần tử %d của mảng: \n", i + 1);
            arr[i] = Integer.parseInt(sc.nextLine());
        }

        // Sắp xếp theo thứ tự giảm dần bằng thuật toán selection Sort
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int temp;
                if (arr[i] < arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println("Mảng sau khi sắp xếp theo thứ tự giảm dần: " + Arrays.toString(arr));

        // Tìm kiếm số
        System.out.println("Nhập số muốn tìm:");
        int searchNum = Integer.parseInt(sc.nextLine());
        int searchIndex = -1;
        boolean found = false;
        for (int i = 0; i < arr.length; i++) {
            if (searchNum == arr[i]) {
                searchIndex = i;
                found = true;
            }
        }

        if (found) {
            System.out.printf("Phần tử %d được tìm thấy tại chỉ số: %d \n", searchNum, searchIndex);
        } else {
            System.out.println("Không tìm thấy phần tử nào phù hợp");
        }
    }
}
