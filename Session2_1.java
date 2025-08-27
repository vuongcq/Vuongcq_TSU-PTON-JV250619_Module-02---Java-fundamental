import java.util.Scanner;

public class Session2_1 {
    public static void main(String[] args) {
    //Bài toán yêu cầu tạo biến age để lưu giá trị nhập vào từ người dùng ,
        // nếu người dùng nhập một chuỗi , một số âm  hoặc để trống ,
        // tóm lại là không phải một số nguyên thì cho người dùng nhập lại
        // đến khi nào nhập đúng một số nguyên thì thôi và sau đó in ra dòng chữ : “ Tuổi của bạn là [age] ! “ .


        // Ex4
        //---------
//        Scanner scanner =new Scanner(System.in);
//        int age = -1;
//        while (true) {
//            System.out.print("Nhập vào tuổi của người dùng: ");
//
//            if (scanner.hasNextInt()) {
//                age = scanner.nextInt();
//                if (age > 0) {
//                    break; // nhập hợp lệ
//                } else {
//                    System.out.println("Tuổi phải là số nguyên dương. Vui lòng nhập lại!");
//                }
//            } else {
//                System.out.println("Không phải số nguyên hợp lệ. Vui lòng nhập lại!");
//                scanner.next(); // bỏ qua input sai (ví dụ "abc")
//            }
//        }
//
//        System.out.println("Tuổi của bạn là " + age + " !");
//        scanner.close();
        //--------------

        //Ex5

//        Scanner sc = new Scanner(System.in);
//        System.out.println("Nhap vao so nguyen tu 1-12 tuong ung voi thang:");
//        int thang =sc.nextInt();
//        switch (thang) {
//            case 1:
//                System.out.println("Thang 1 co 31 ngay!");
//                break;
//            case 2:
//                System.out.println("Thang 2 co 28 hoac 29 ngay!");
//                break;
//            case 3:
//                System.out.println("Thang 3 co 31 ngay!");
//                break;
//            case 4:
//                System.out.println("Thang 4 co 30 ngay!");
//                break;
//            case 5:
//                System.out.println("Thang 5 co 31 ngay!");
//                break;
//            case 6:
//                System.out.println("Thang 6 co 30 ngay!");
//                break;
//            case 7:
//                System.out.println("Thang 7 co 31 ngay!");
//                break;
//            case 8:
//                System.out.println("Thang 8 co 31 ngay!");
//                break;
//            case 9:
//                System.out.println("Thang 9 co 30 ngay!");
//                break;
//            case 10:
//                System.out.println("Thang 10 co 31 ngay!");
//                break;
//            case 11:
//                System.out.println("Thang 11 co 30 ngay!");
//                break;
//            case 12:
//                System.out.println("Thang 12 co 31 ngay!");
//                break;
//            default:
//                System.out.println("Thang ban nhap vao khong hop le!");
//                break;
//        }

        //Ex6
        // nhap day so n
        // khai bao thuong=-1, du, tong=0
        // cho vòng lặp while chạy khi thuong khac 0 thì chạy tiếp
        // thực hiện phép chia rồi gán thuong ==a
        // tong =tong +du
        //

//        Scanner sc = new Scanner(System.in);
//        System.out.println("Nhap vao so nguyen bat ky:");
//        int n = sc.nextInt();
//        int nDuong =Math.abs(n);
//        int thuong = -1;
//        int du =0;
//        int tong =0;
//        while (thuong !=0){
//            thuong=nDuong/10;
//            du =nDuong%10;
//            tong = tong + du;
//            nDuong=thuong;
//        }
//        System.out.println("Tong cac chu so cua so nguyen n la:" +tong);

        //Ex7 Kiem tra tinh hop le cua tam giac

        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap vao canh a cua tam giac:");
        int a = sc.nextInt();
        System.out.println("Nhap vao canh b cua tam giac:");
        int b = sc.nextInt();
        System.out.println("Nhap vao canh c cua tam giac:");
        int c = sc.nextInt();

        if ((a+b>c) && (a+c>b) && (b+c>a)){
            if (a==b && b==c && a==c){
                System.out.println("Tam giác đều");
            } else {
                if (a==b||a==c||b==c){
                    System.out.println("Tam giác cân");
                } else {
                    if (((a*a) == (b*b)+(c*c)) || ((b*b) == (a*a)+(c*c)) || ((c*c) == (b*b)+(a*a))) {
                        System.out.println("Tam giác vuông");
                    } else {
                        System.out.println("Tam giác thường");
                    }
                }
            }
        }
        else {
            System.out.println("Ba cạnh không tạo thành tam giác");
        }


    }
}
