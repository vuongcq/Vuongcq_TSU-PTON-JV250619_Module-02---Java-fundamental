package module2;

import java.util.Scanner;

public class Session5 {
    // Bài 1: tìm ký tự từ một chuỗi
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào chuỗi văn bản:");
        String inputText = sc.nextLine().trim();
        System.out.println("Nhập vào từ muốn tìm:");
        String wordTofind = sc.nextLine().trim();
        // trả về chỉ số vị trí của phần tử cần tìm đó
        int index = inputText.indexOf(wordTofind);
        System.out.println(index);
    }
}
