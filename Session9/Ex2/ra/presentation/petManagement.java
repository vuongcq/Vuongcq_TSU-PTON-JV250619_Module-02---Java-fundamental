package Session9.Ex2.ra.presentation;

import Session9.Ex2.ra.entity.Dog;
import Session9.Ex2.ra.entity.Pet;

import java.util.Scanner;

public class petManagement {
    static Pet [] arrListpet = new Pet[100];
    static int currentIndex = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("********** QUẢN LÝ THÚ CƯNG **********\n" +
                    "1. Hiển thị danh sách thú cưng\n" +
                    "2. Thêm thú cưng \n" +
                    "3. Gọi tiếng kêu \n" +
                    "4. Xóa thú cưng \n" +
                    "5. Tìm thú cưng theo tên \n" +
                    "6. Thoát \n" +
                    "Lựa chọn của bạn:\n");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice){
                case 1:
                    // Hiển thị danh sách thú cưng
                    displayListPet();
                    break;
                case 2:
                    // thêm thú cưng
                    inputPet(sc);
                    break;
                case 3:
                    // gọi tiếng kêu

                    break;
                case 4:
                    // xóa thú cưng

                    break;
                case 5:
                    // tìm thú cưng theo tên
                    break;
                case 6:
                    // thoát
                    System.exit(0);
                default:
                    System.out.println("Nhập từ 1-6");
                    break;
            }

        } while (true);
    }

    // hiển thị thú cưng
    public static void displayListPet (){
        for ( int i =0; i<currentIndex;i++){
            arrListpet[i].displayData();

        }
    }

    // thêm thú cưng
    public static void inputPet (Scanner scanner){
        Scanner sc = new Scanner(System.in);
        System.out.println("Số lượng thú cưng muốn nhập:");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i=0; i<n;i++){
            // khai  báo arrListpet là 1 phâ tử của mảng
            arrListpet[currentIndex] = new Dog();

            // Nhập thông tin thú cưng
            System.out.printf("Nhập thông tin thú cưng %d \n", i+1);
            arrListpet[currentIndex].inputData(sc);
            currentIndex ++;
        }
    }
}
