package Session9.Ex1.ra.entity;

import java.util.Scanner;

public class Student {

    // khai báo biến, trường
    private String id;
    private String Name;
    private int age;
    private String major;

    // khai báo hàm tạo - constructor
    // 1. khng tham số
    public Student(){

    };

    // 2.đầy đủ tham số
    public Student(String id, String Name, int age, String major) {
        this.id = id;
        this.Name = Name;
        this.age = age;
        this.major = major;
    };

    // Khai báo phương thức- method
    //1. Khia báo phương thức nhập
    public void inputData(Scanner scanner){
        // nhập thông tin
        System.out.println("Nhập mã sinh viên:");
        this.id = scanner.nextLine();
        System.out.println("Nhập tên sinh viên:");
        this.Name = scanner.nextLine();
        System.out.println("Nhập tuổi sinh viên:");
        this.age = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập chuyên ngành sinh viên:");
        this.major = scanner.nextLine();
    }

    //2. khai báo phương thức hiển thị
    public void displayData(){
        System.out.printf("Mã sv: %s, Tên sv: %s, Tuổi: %d, Chuyên ngành: %s \n", this.id, this.Name, this.age, this.major);
    }

    // getter và setter


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}
