package module2;

import java.util.Scanner;

import static java.lang.Boolean.parseBoolean;

public class Session3 {
    public static void main(String[] args) {

//        //Bai1 Tinh tien hoa don sieu thi
//        //input: customerName, productName, price, quantity, member
//        // totalAmount = price * quantity
//        // discount = toalAmout *0.1
//        // vat =totalAmout *0.08
//        // payment = totalAmount - discount + vat
//        //output: customerName, productName, quantity, price, totalAmount, discount, vat, payment
//
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Nhap ten khach hang:");
//        String customerName = sc.nextLine();
//        System.out.println("Nhap ten san pham:");
//        String productName = sc.nextLine();
//        System.out.println("Nhap don gia san pham:");
//        float price = Float.parseFloat(sc.nextLine());
//        System.out.println("Nhap so luong:");
//        int quantity = Integer.parseInt(sc.nextLine());
//        System.out.println("Bạn có phải là thành viên? true/false");
//        boolean member = Boolean.parseBoolean(sc.nextLine());
//        System.out.println("Địa chỉ:");
//        String address = sc.nextLine();
//
//        float totalAmount = price * quantity;
//        float memberAmount = 0;
//        if (member){
//            memberAmount = totalAmount * 0.1f;
//        }
//        else memberAmount = 0;
//
//        float vat =totalAmount * 0.08f;
//        float payment = totalAmount -memberAmount +vat;
//
//        System.out.printf("Khách hàng: %s\n", customerName);
//        System.out.printf("Sản phẩm: %s\n", productName);
//        System.out.printf("Giá: %.0f\n",price);
//        System.out.printf("Số lượng: %d\n",quantity);
//        System.out.printf("Thành tiền: %.0f\n",totalAmount);
//        System.out.printf("Giảm giá: %.0fVND\n",memberAmount);
//        System.out.printf("Tổng tiền VAT: %.0fVND\n",vat);
//        System.out.printf("Tổng thanh toán: %.0fVND\n",payment);
//    //---------Kết thúc Bài 1----------------------


//        // Bài 2: Quan lý điêm học viên
//        //CN1: Nhập điểm hv
//        // input: nhập điểm học sinh,
//        // Nhập -1 kết thúc nhập
//        // nhập ngoài  (0-10) và -1 in cảnh báo và yêu cầu nhập lại
//        //output: xếp loại học lực
//        //CN2: Hiển thị thống kê
//        // TH1: Chưa có học viên, hiê thị chưa c dl
//        //TH2: Nếu có thì in: sumStudent, avaMark, minMarkm maxMark
//        // tính toán:  sumStudent, maxMark, minMark
//        // CN3: thoát ctr
//
//        Scanner sc = new Scanner(System.in);
//        boolean choice = true;
//        int sumStudent = 0;
//        float avaMark = 0;
//        float sumMark = 0;
//        float minMark = 10;
//        float maxMark = 0;
//        do {
//            System.out.println("====== MENU =====\n" +
//                    "1. Nhập điểm học viên\n" +
//                    "2. Hiển thị thống kê\n" +
//                    "3. Thoát\n" +
//                    "Lựa chọn của bạn:");
//            int input = sc.nextInt();
//            switch (input) {
//                case 1:
//                    // Câu lệnh
//                    do {
//                        System.out.println("Nhập điểm học viên:");
//                        float markOfstd = sc.nextFloat();
//                        if (markOfstd == -1) {
//                            choice = false;
//                        } else {
//                            if ((markOfstd >= 0) && (markOfstd <= 10)) {
//                                // thực hiện yêu cầu
//                                sumMark = sumMark + markOfstd;
//                                sumStudent = sumStudent + 1;
//                                if (markOfstd > maxMark) {
//                                    maxMark = markOfstd;
//                                }
//                                if (markOfstd < minMark) {
//                                    minMark = markOfstd;
//                                }
//                                if (markOfstd < 5) {
//                                    System.out.println("Học lực: Yếu");
//                                } else {
//                                    if (markOfstd < 7) {
//                                        System.out.println("Học Lực: Trung Bình");
//                                    } else {
//                                        if (markOfstd < 8) {
//                                            System.out.println("Học Lực: Khá");
//                                        } else {
//                                            if (markOfstd < 9) {
//                                                System.out.println("Học Lực: Giỏi");
//                                            } else {
//                                                System.out.println("Học Lực: Xuất Sắc");
//                                            }
//                                        }
//                                    }
//                                }
//                            } else {
//                                System.err.println("Điểm không hợp lệ. Vui lòng nhập lại!");
//                            }
//                        }
//                    } while (choice);
//                    break;
//                case 2:
//                    // Câu lệnh hiển thị thống kê
//                    if (sumStudent == 0) {
//                        System.out.println("Chưa có dữ liệu");
//                    } else {
//                        avaMark = sumMark / sumStudent;
//                        System.out.printf("Số học viên đã nhập: %d\n", sumStudent);
//                        System.out.printf("Điểm trung bình: %.2f\n", avaMark);
//                        System.out.printf("Điểm cao nhất: %.2f\n", maxMark);
//                        System.out.printf("Điểm thấp nhất: %.2f\n", minMark);
//                    }
//                    break;
//                case 3:
//                    System.exit(0);
//            }
//        }
//        while (true);
//        // Kết thuc bài 2......

        //Bài 3: Quản lý lương nhân viên
        //CN1: Nhập lương nhân viên
        // nhập -1 kết thúc quá trình nhập
        // nhập giá trị 0-500 rồi phân loại
        // tính salary sumMember, sumSalary, maxSalary, minSalary
        //CN2: Hiển thị thống kê
        //  nếu chưa có nv hiển thị chưa c dl
        // output avaSalary, maxSalary, minSalary, sumSalary
        //CN3: Tính tổng số tiền thưởng cho nv
        // thưởng theo tỷ lệ lưogn
        // output sumBonus
        //CN4: Thoát

        Scanner sc = new Scanner(System.in);
        boolean choice = true;
        int sumMember = 0;
        int sumSalary = 0;
        int avaSalary = 0;
        int maxSalary = 0;
        int minSalary = 500000000;
        float bonus = 0;
        float sumBonus = 0;
        // hàm do-while cho Menu chính
        do {
            // 4 chức năng chính
            // dùng switch -case cho phím 1-4 nhập vào
            // default dùng khi nhập phím khac 1-4
            System.out.println("********** MENU NHẬP LƯƠNG **********\n" +
                    "1. Nhập lương nhân viên\n" +
                    "2. Hiển thị thống kê\n" +
                    "3. Tính tổng số tiền thưởng cho nhân viên\n" +
                    "4. Thoát\n" +
                    "Lựa chọn của bạn:");
            int input = Integer.parseInt(sc.nextLine());
            switch (input) {
                case 1:
                    // nhập lương nhân viên
                    // vòng do-while để giữ ctrình luôn chạy nếu k nhập -1
                    do {
                        System.out.println("Nhập lương nhân viên (Nhập -1 để kết thúc):");
                        int salary = Integer.parseInt(sc.nextLine());
                        if (salary == -1) {
                            choice = false;
                        } else {
                            if ((salary >= 0) && (salary <= 500000000)) {
                                // Thực hiện lệnh
                                sumMember = sumMember + 1;
                                sumSalary = sumSalary + salary;
                                if (salary > maxSalary) {
                                    maxSalary = salary;
                                }
                                if (salary < minSalary) {
                                    minSalary = salary;
                                }
                                if (salary < 5000000) {
                                    bonus = salary * 0.05f;
                                    System.out.println("Phân loại: Thấp");
                                } else {
                                    if (salary < 15000000) {
                                        bonus = salary * 0.1f;
                                        System.out.println("Phân loại: Trung bình");
                                    } else {
                                        if (salary < 50000000) {
                                            bonus = salary * 0.15f;
                                            System.out.println("Phân loại: Khá");
                                        } else {
                                            if (salary < 100000000) {
                                                bonus = salary * 0.2f;
                                                System.out.println("Phân loại: Cao");
                                            } else {
                                                bonus = salary * 0.25f;
                                                System.out.println("Phân Loại: Cao");
                                            }
                                        }
                                    }
                                }
                                sumBonus = sumBonus + bonus;
                            } else {
                                System.err.println("Giá trị nhập không hợp lệ. Vui lòng nhập lại!");
                            }
                        }
                    }
                    while (choice);
                    break;
                case 2:
                    // Hiển thị thống kê
                    if (sumMember == 0) {
                        System.out.println("Chưa có dữ liệu");
                    } else {
                        avaSalary = sumSalary / sumMember;
                        System.out.printf("Số nhân viên: %d\n", sumMember);
                        System.out.printf("Tổng lương: %,d VND\n", sumSalary);
                        System.out.printf("lương trung bình: %,d VND\n", avaSalary);
                        System.out.printf("Lương cao nhất: %,d VND\n", maxSalary);
                        System.out.printf("Lương thấp nhất: %,d VND\n", minSalary);
                    }
                    break;
                case 3:
                    // Tính tiền thưởng cho nv
                    System.out.printf("Tổng tiền thưởng nhân viên: %,.0f VND\n", sumBonus);
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.err.println("Số bạn nhập chưa đúng. Mời nhập lại!");
                    break;
            }
        }
        while (true);
    }
}
