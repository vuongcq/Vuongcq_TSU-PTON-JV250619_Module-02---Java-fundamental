package Session10.Ex3;

import java.util.Scanner;

public class Person {

    // khai báo biến, trươngf
    private String name;
    private String email;
    private int phoneNumber;

    // Constructor


    public Person() {
    }

    public Person(String name, String email, int phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    // Phương thức
    // getter, setter

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // thêm người dùng
    public  void addData(Scanner scanner) {
        // nhập và xử lý ngoại lệ cho tên người dùng
        do {
            try {
                System.out.println("Nhập tên người dùng:");
                this.name = scanner.nextLine();

                if (this.name.isEmpty()) {
                    throw new Exception("Tên người dùng không được để trống");
                }
                break; // hợp lệ
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } while (true);

        // Nhập và xử lý ngoại lệ cho email

        do {
            try {
                System.out.println("Nhập email người dùng:");
                this.email = scanner.nextLine();

                if (this.email.isEmpty() || !this.email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
                    throw new Exception("Email không được để trống và phaỉ đúng chuẩn");
                }
                break;
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } while (true);

        // Nhập và xử lý ngoại ệ cho sđt. k đc rỗng và là số nguyên

        do {
            try {
                System.out.println("Nhập số điện thoại:");
                String input = scanner.nextLine();

                if (input.isEmpty()) {
                    throw new Exception("SĐT không được để trống.");
                }
                // hợp lệ
                this.phoneNumber = Integer.parseInt(input);
                break;
            } catch (NumberFormatException e) {
                System.err.println("SĐT phải là số nguyên");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    // hiển thị danh sách người dùng
    public void displayPerson() {
        System.out.printf("Tên: %s, Email: %s, SĐT: %d \n", this.name, this.email, this.phoneNumber);
    }
}
