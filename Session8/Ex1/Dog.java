package Session8.Ex1;

public class Dog extends Animals{
    public String breed;

    // Constructor
    public Dog(String name, int age, String breed) {
        super(name, age);
        this.breed = breed;
    }

    @Override
    public void displayInfo(){
        System.out.printf("Tên: %s, Tuổi: %d \n", super.getName(), super.getAge());
        System.out.printf("Giống chó: %s\n", breed);
    }

    @Override
    public String makeSound() {
        return "Âm thanh: Woof Woof";
    }
}
