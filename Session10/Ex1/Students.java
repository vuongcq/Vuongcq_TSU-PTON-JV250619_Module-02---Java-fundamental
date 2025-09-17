package Session10.Ex1;

import java.util.Scanner;

public  class Students {
    Scanner sc = new Scanner(System.in);
    private String name;
    private int age;
    private float aveScore;

    // Constructor
    public Students(){};

    public Students(String name, int age, float aveScore) {
        this.name = name;
        this.age = age;
        this.aveScore = aveScore;
    }

    // Method- phương thức

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

    public float getAveScore() {
        return aveScore;
    }

    public void setAveScore(float aveScore) {
        this.aveScore = aveScore;
    }


    // Phương thức hiển thị thông tin sinh viên
    public  void displayStudent (){
        System.out.printf("Tên: %s, Tuổi: %d, Điểm trung bình: %.1f \n", this.name, this.age, this.aveScore);
    }
}
