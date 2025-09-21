package Session11.Ex2;

public class Student {
    // biến
    private String name;
    private int age;
    private double grade;

    //Constructor


    public Student(String name, int age, double grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    // Method
    //getter, setter


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

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public void display() {
        System.out.printf("| name: %s| age: %d| grade: %.2f%n", name, age, grade);
    }

    @Override
    public String toString() {
        return String.format("| name: %s | age: %d | grade: %.2f", name, age, grade);
    }
}

