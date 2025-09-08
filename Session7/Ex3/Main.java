package Session7.Ex3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // tạo 2 đối tượng person

        Person ps1 = new Person();
        System.out.println("Nhập tên của người đầu tiên:");
        ps1.setName(sc.nextLine());
        System.out.println("Nhập tuổi của người đầu tiên:");
        ps1.setAge(Integer.parseInt(sc.nextLine()));

        Person ps2 = new Person();
        System.out.println("Nhập tên của người thứ 2:");
        ps2.setName(sc.nextLine());
        System.out.println("Nhập tuổi của người thứ 2:");
        ps2.setAge(Integer.parseInt(sc.nextLine()));

        if (ps1.getAge() > ps2.getAge()){
            System.out.printf("%s lớn tuổi hơn %s \n", ps1.getName(), ps2.getName());
        } else {
            System.out.printf("%s lớn tuổi hơn %s \n", ps2.getName(), ps1.getName());
        }
    }
}
