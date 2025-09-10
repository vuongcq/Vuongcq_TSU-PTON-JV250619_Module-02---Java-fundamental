package Session8.Ex1;

public class Cat extends Animals{
    public String furColor;

    //Constructor
    public Cat (String name, int age, String furColor){
        super(name, age);
        this.furColor =furColor;
    }

    @Override
    public void displayInfo(){
        System.out.printf("Tên: %s, Tuổi: %d \n", super.getName(), super.getAge());
        System.out.printf("Màu lông: %s", furColor);
    }

    @Override
    public String makeSound(){
        return "Meow Meow";
    }

}
