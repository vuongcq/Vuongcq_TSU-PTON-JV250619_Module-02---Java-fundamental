package Session8.Ex1;

public class Animals {
    private String name;
    private int age;

    // Constructor
    public Animals(String name, int age) {
        this.name =name;
        this.age = age;
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

    // Phương thức
    public void displayInfo(){

    }
    public String makeSound(){
        return "Some generic sound";
//        System.out.println("Some generic sound");
    }
}
