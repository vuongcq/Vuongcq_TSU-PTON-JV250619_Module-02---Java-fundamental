import java.util.Scanner;

public class Session1 {
    public static void main(String[] args) {
        // Ex1
        System.out.println("Hello, Java!");
        //Ex2
        System.out.printf("Tên tôi là %s, tôi %d tuổi, hiện tại đang học tại PTIT HCM, Quê quán ở%s", "Nguyễn Văn A" , 22, "Hà Nội");
        System.out.println("");

        // Ex3 tính diện tích hình tròn
        double pi = Math.PI;
        System.out.println("Nhập vào bán kính hình tròn:");
        Scanner scanner =new Scanner(System.in);
        double banKinh = scanner.nextDouble();
        double dienTich = banKinh*banKinh * pi;
        System.out.printf("Diện tích của hình tròn có bán kính %.2f là: %.2f"  ,banKinh, dienTich );
        System.out.println("");
        //Ex4
        int a =10;
        int b=5;
        System.out.println("Tổng 2 số a+b ="+(a+b));
        System.out.println("Hiệu 2 số a-b ="+(a-b));
        System.out.println("Tích 2 số a*b ="+(a*b));
        System.out.println("Thương 2 số a/b ="+(a/b));
        System.out.println("Số dư khi chia số a cho số b ="+(a%b));

        // Ex5
        // Nhập tử số và mẫu số của hai phân số người dùng tính tổng và
        // in ra kq

        System.out.println("Nhập tử số của phân số 1:");
        Scanner scanner1 = new Scanner(System.in);
        int a1 = scanner1.nextInt();
        System.out.println("Nhập mẫu số của phân số 1:");
        Scanner scanner2 = new Scanner(System.in);
        int b1 = scanner2.nextInt();
        System.out.println("Nhập tử số của phân số 2:");
        Scanner scanner3 = new Scanner(System.in);
        int c = scanner3.nextInt();
        System.out.println("Nhập mẫu số của phân số 2:");
        Scanner scanner4 = new Scanner(System.in);
        int d = scanner4.nextInt();
        int tongTu = (a1*d)+(b1*c);
        int tongMau =b1*d;
        System.out.printf("Kết quả của tổng 2 phân số là %s/%s", tongTu, tongMau);

        //Ex6 tính chu vi và diên tích hình chữ nhật
        System.out.println("Nhập chiều rộng hình chữ nhật:");
        Scanner scanner5 = new Scanner(System.in);
        float width = scanner5.nextFloat();
        System.out.println("Nhập chiều dài hình chữ nhật:");
        Scanner scanner6 = new Scanner(System.in);
        float height = scanner6.nextFloat();
        float area = width*height;
        float circumference = 2*(width + height);
        System.out.printf("Diện tích:  %.2f\n", area);
        System.out.printf("Chu vi: %.2f", circumference);

    }
}

