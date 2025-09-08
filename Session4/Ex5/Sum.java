package Session4.Ex5;

import java.util.Arrays;
import java.util.Scanner;

public class Sum {
    public static void main(String[] args) {
        // Nhập mảng 2 chiều số nguyên
        // tính tổng số chẵn và lẻ
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số hàng:");
        int r = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập số cột:");
        int c = Integer.parseInt(sc.nextLine());

        int[][] arr = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.printf("Nhập giá trị của hàng %d, cột %d: ", i + 1, j + 1);
                arr[i][j] = Integer.parseInt(sc.nextLine());

            }
        }
        int sumEven = 0;
        int sumOdd = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (arr[i][j] % 2 == 0) {
                    sumEven = sumEven + arr[i][j];
                } else {
                    sumOdd = sumOdd + arr[i][j];
                }
            }
        }
        System.out.printf("Tổng các số chẵn là: %d\n", sumEven);
        System.out.printf("Tổng các số lẽ là:%d\n", sumOdd);
    }
}
