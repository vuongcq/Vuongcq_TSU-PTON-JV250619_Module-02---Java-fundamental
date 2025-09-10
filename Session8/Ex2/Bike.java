package Session8.Ex2;

public class Bike extends Vehicle{

    //
    public Bike(String name, int speed){
        super(name, speed);
    }

    @Override
    void displayInfo(){
        System.out.printf("Car Name: %s, Speed: %d \n", getName(), getSpeed());
    }

}
