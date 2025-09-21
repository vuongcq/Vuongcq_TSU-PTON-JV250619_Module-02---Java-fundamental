package Session11.Ex1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntergeruseLamda {
    public static void main(String[] args) {

        // tạo 1 mảng s nguyên
        List<Integer> listInteger = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        System.out.println(listInteger);

        // Sử dụng Lambda để in ra số chẵn
        System.out.println("Số chẵn trong danh sách là:");
        listInteger.stream().filter(num -> num % 2 == 0).forEach(num -> System.out.println(num));

//       // Sử dụng Lambda tổng các số trong danh sách

        int sum = listInteger.stream().reduce(0, (a, b) -> a + b);
        System.out.println("Tổng của danh sách số nguyên là:" + sum);

    }
}
