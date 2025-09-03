package module2;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;

public class Session4 {

//     // Bài 1: Tìm phần tử lớn nhất trong mảng
//        // NHập kích thước mảng, và gi trị của mảng
//        // sử dụng thuật toán selection sort sắp xếp theo tăng dần
//        // in ra phần tử lớn nhất.
//
//    public static void main(String[] args) {
//
//
//        Scanner sc = new Scanner(System.in);
//        System.out.println("NHập vào kích thước n của mảng:");
//        int n = Integer.parseInt(sc.nextLine());
//        int[] array = new int[n];
//        for (int i = 0; i < n; i++) {
//            System.out.printf("Nhập phần tử %d của mảng %d phần tử:\n", i, n);
//            array[i] = Integer.parseInt(sc.nextLine());
//        }
//        // lệnh in ra mảng
//        System.out.println("Mảng trước khi sắp xếp:" + Arrays.toString(array));
//        SelectionSort(array);
//        System.out.println("Mảng sau khi sắp xếp:" + Arrays.toString(array));
//        System.out.printf("Phần tử lớn nhất trong mảng là: %d", array[0]);
//    }
//
//    public static void SelectionSort(int [] arr){
//        for (int i = 0; i < arr.length - 1; i++) {
//            int maxValue = arr[i];
//            int maxIndex = i;
//            for (int j = i + 1; j < arr.length; j++) {
//                if (arr[j] > maxValue) {
//                    maxValue = arr[j];
//                    maxIndex = j;
//                }
//            }
//            arr[maxIndex] = arr[i];
//            arr[i] = maxValue;
//        }
//    }
//
//    // Kết thúc bài 1.....................

    // Bài 2 Tính tổng các phần tử trong mảng
    // Nhập kích thước mảng và giá trị cho mảng số nguyên
    // Duyệt qua từng phần tử trong mảng để tính tổng
//    public static void main(String[] args){
//        Scanner sc =new Scanner(System.in);
//        System.out.println("Nhập kích thước n của mảng:");
//        int n = Integer.parseInt(sc.nextLine());
//        int sum =0;
//        int [] array =new int[n];
//        for ( int i=0; i<n;i++){
//            System.out.printf("Nhập phần từ %d của mảng:", i);
//            array[i] = Integer.parseInt(sc.nextLine());
//        }
//        for ( int i=0; i<n;i++){
//            sum =sum +array[i];
//        }
//        System.out.println("Mảng vừa nhập là:" + Arrays.toString(array));
//        System.out.println("Tổng các phần tử của mảng là:" +sum);
//    }
//       // Kết thúc Bài 2....

//    // Bài 3: Sắp xếp mảng giảm dần
//
//    public static void BubbleSort(int[] arr) {
//        for (int i = 0; i < arr.length - 1; i++) {
//            for (int j = 0; j < arr.length - i - 1; j++) {
//                if (arr[j] < arr[j + 1]) {
//                    int temp = arr[j + 1];
//                    arr[j + 1] = arr[j];
//                    arr[j] = temp;
//                }
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Nhập kích thước của mảng:");
//        int n = Integer.parseInt(sc.nextLine());
//        int[] array = new int[n];
//        for (int i = 0; i < n; i++) {
//            System.out.printf("Nhập phần tử thứ %d của mảng:\n", i);
//            array[i] = Integer.parseInt(sc.nextLine());
//        }
//        System.out.println("Mảng trước khi sắp xếp: " + Arrays.toString(array));
//        // sắp xếp theo thứ tự giảm dần thoe thuật toán nổi bọt
//        BubbleSort(array);
//        System.out.println("Mảng sau khi sắp xếp:" + Arrays.toString(array));
//    }
//    // kết thúc bài 3/////////////////


    // Bài 4: Đảo ngược mảng.
    
}
