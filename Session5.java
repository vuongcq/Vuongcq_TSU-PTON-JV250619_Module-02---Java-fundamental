import java.util.Scanner;

public class Session5 {
//    // Bài 1 Tìm từ trong chuỗi
//    // Nhập vào chuỗi văn bản, và từ cần tìm trong chuỗi
//    // Nếu có in ra vị trí đầu tin của từ trong chuỗi
//    // Nếu không thì sẽ thông báo không tìm thấy
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Nhập chuỗi văn bản:");
//        String input = sc.nextLine();
//        System.out.println("Nhập từ cần tìm:");
//        String wordtoFind = sc.nextLine();
//        int index = input.indexOf(wordtoFind);
//        if (index == -1){
//            System.out.printf("Không tìm thấy từ %s trong chuỗi \n", wordtoFind);
//        } else {
//            System.out.printf("Từ %s xuất hiện tại vị trí %d trong chuỗi", wordtoFind, index);
//        }
//    }
//    /// kết thúc bài 1

//    // Bài 2 Xóa và thay thế phần tử trong String Builder
//    // viêt chương trình JV sd lớp String Builder để thực hiện thao tác trên chuỗi
//    // Khơ tạo chuỗi "Hello, Java World"
//    // xóa ký tự từ 5-9
//    // thay thế đoạn "World" bằng "Universe"
//    // in ra chuỗi ban đầu, sau khi xóa, sau khi thay thế
//    public static void main(String[] args) {
//        StringBuilder str = new StringBuilder("Hello, Java World");
//        System.out.println("Chuỗi ban đầu: " +str);
//        StringBuilder delStr = str.delete(5,9);
//        System.out.println("Chuỗi sau khi xóa: "+delStr);
//        StringBuilder replaceStr = str.replace(8,15, "Universe");
//        System.out.println("Chuỗi sau khi thay thế: " +replaceStr);
//    }
//    // Kết thúc bài 2

//    // Bài 3: Thay thế ký tự trong chuỗi
//    // Nhập vào 1 chỗi t bàn phím
//    // thay thế ký tự số  trong chỗi bằng ký tự *
//
//    public static void main(String[] args) {
//        String regex = "\\d";
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Nhập vào chuỗi:");
//        String inputText = sc.nextLine();
//        String result = inputText.replaceAll(regex, "*");
//        System.out.println(result);
//    }
//    // Kết thúc bài 3

    // Bài 4:  Kiểm tra định dạng email
    // input chuỗi bất kỳ đa diện cho đại chỉ email
    // loại bỏ khoảng trắng thừa nếu cần thiết
    // kiêểm tra xem chuỗi có tuân theo định dạng email hợp lệ k sử dụng regex
    // nếu hợp lệ thì hiển thị email hợp lệ, nếu k hiển thị k hợp lệ

//    public static void main(String[] args) {
//        String regex = "^[a-zA-Z0-9._]+@[a-zA-Z0-9.]+\\.[a-zA-Z]{2,6}$";
//        Scanner scan = new Scanner(System.in);
//        System.out.println("Nhập vào chuỗi từ bàn phím:");
//        String textInput = scan.nextLine();
//        String editedInput = textInput.replaceAll("\\s+","");
//        System.out.println(editedInput);
//        boolean result = editedInput.matches(regex);
//        System.out.println(result);
//        if (result) {
//            System.out.printf("Email %s hợp lệ!", editedInput);
//        } else {
//            System.out.println("Email không hợp lệ!");
//        }
//    }
//    // Kết thúc bài 4

    // Bài 5: So sánh hiệu suất giữa String, String Builder và StringBuffer
    // Tạo chuỗi Hello
    // sử dụng vòng lặp để nối chuỗi ban đầu với 1 triệu lần với mỗi loại String, StringBuilder và StringBuffer
    // Sử dụng System.currentTimeMillis để đo thời gian bắt đầu và kết thúc

    public static void main(String[] args) {
        String str1 = "Hello";
        String str2 = "World";
        long start = System.currentTimeMillis();
        for ( int i =1;i<1000000; i++){
            String str = str1.concat(str2);
        }
        long end = System.currentTimeMillis();
        System.out.println("Nối chỗi theo String: "+(end - start));

        StringBuilder sb = new StringBuilder("Hello");
        long start1 = System.currentTimeMillis();
        for ( int i =1;i<1000000; i++){
            sb = sb.append(str2);
        }
        long end1 = System.currentTimeMillis();
        System.out.println("Nối chỗi theo StringBuilder: "+(end1 - start1));

        StringBuilder sbf = new StringBuilder("Hello");
        long start2 = System.currentTimeMillis();
        for ( int i =1;i<1000000; i++){
            sbf = sbf.append(str2);
        }
        long end2 = System.currentTimeMillis();
        System.out.println("Nối chỗi theo StringBuffer: "+(end2 - start2));
    }
}
