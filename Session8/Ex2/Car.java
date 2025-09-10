package Session8.Ex2;

public class Car extends Vehicle{

    // phương thưcs
    public Car(String name, int speed){
        super(name, speed);
    }

    // Ghi đè phương thức displayInfo
    @Override
    void displayInfo(){
        System.out.printf("Car Name: %s, Speed: %d \n", getName(), getSpeed());
    }
}
