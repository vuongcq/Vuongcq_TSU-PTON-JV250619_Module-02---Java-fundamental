package Session9.Ex2.ra.entity;

public class Cat extends Pet{
    public Cat() {
    }

    public Cat(String id, String name, int age) {
        super(id, name, age);
    }

    @Override
    public void speak() {
        super.speak();
        System.out.println("Meo meo");
    }
}
