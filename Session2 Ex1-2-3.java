import java.util.Scanner;

public class Session2 {
    public static void main(String[] args) {
        //Ex1

        System.out.println("Nhập vào một số nguyên:");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n == 0) {
            System.out.println("Số không phải chẵn cũng không phải lẻ");
        } else if (n % 2 == 0) {
            System.out.printf("Số %s là số chẵn!", n);
        } else {
            System.out.printf("Số %s là số lẻ!", n);

        }

        //Ex2
        // Nhập vào số từ 1-7 để in các ngày trong tuần
        System.out.println("");
        System.out.println("Nhập vào 1 số từ 1-7 để chọn in ngày ra:");
        Scanner scanner1 = new Scanner(System.in);
        int choice = scanner1.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Đây là thứ 2!");
                break;
            case 2:
                System.out.println("Đây là thứ 3!");
                break;
            case 3:
                System.out.println("Đây là thứ 4!");
                break;
            case 4:
                System.out.println("Đây là thứ 5!");
                break;
            case 5:
                System.out.println("Đây là thứ 6!");
                break;
            case 6:
                System.out.println("Đây là thứ 7!");
                break;
            case 7:
                System.out.println("Đây là thứ CN!");
                break;
            default:
                System.out.println("Số bạn nhập vào chưa đúng!");
                break;
        }


        // Ex3 Tính tổng các số nguyên dương từ 1-N N được nhập vào từ bàn phím
        System.out.println("Mời nhập vào số nguyên N là số lớn nhất của chuỗi từ 1-N:");
        Scanner scanner2 = new Scanner(System.in);
        int N = scanner2.nextInt();
        int tong =0;
        if (N <=0) {
            System.out.println("Số nhập vào không hợp lệ");
        } else {
            for (int i=1; i<=N; i++){
                tong = tong + i;
            }
            System.out.println(" Tổng của dãy số từ 1 đến N là:" +tong);
        }
    }
}
