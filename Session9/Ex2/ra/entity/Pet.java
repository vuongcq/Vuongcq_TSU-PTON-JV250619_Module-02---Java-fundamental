package Session9.Ex2.ra.entity;

import java.util.Scanner;

public abstract class Pet {
    private String id;
    private String name;
    private int age;

    // Constructor
    // Không tham số
    public Pet() {}

    // có tham số
    public Pet(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Phương thức khác
    // input
    public void inputData (Scanner scanner){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập tên:");
        this.name = sc.nextLine();

        System.out.println("Nhập tuổi:");
        this.age = Integer.parseInt(sc.nextLine());
    }

    //display
    public void displayData (){
        System.out.printf("Mã: %s, Tên: %s, Tuổi: %d \n", this.id, this.name, this.age);
    }

    //phương thức trừu tượng speak
    public void speak(){}
}
