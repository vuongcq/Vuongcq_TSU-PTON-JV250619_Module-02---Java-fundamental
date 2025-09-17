package Session9.Ex2.ra.entity;

public class Dog extends Pet{
    public Dog() {
    }

    public Dog(String id, String name, int age) {
        super(id, name, age);
    }

    @Override
    public void speak() {
        super.speak();
        System.out.println("Gâu gâu");
    }
}
