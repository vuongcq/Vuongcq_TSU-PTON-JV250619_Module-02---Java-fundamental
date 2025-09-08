package Session7.Ex4;

public class Student {
    private String name;
    private int age;
    private String cls;
    private double avgScore;

    // Constructor
    public Student(String name, int age, String cls, double avgScore) {
        this.name = name;
        this.age = age;
        this.cls = cls;
        this.avgScore = avgScore;
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

    public String getCls() {
        return cls;
    }

    public void setCls(String cls) {
        this.cls = cls;
    }

    public double getAvgScore() {
        return avgScore;
    }

    public void setAvgScore(double avgScore) {
        this.avgScore = avgScore;
    }

    @Override
    public String toString() {
        return "Tên: " + name + ", Tuổi: " + age + ", Lớp: " + cls + ", Điểm trung bình: " + avgScore;
    }
}
