package Session8.Ex2;

public class Main {
    public static void main(String[] args) {
        Vehicle car = new Car("Toyota", 120);
        Vehicle bike = new Bike("Yamaha", 88);

        // gọi các phương thức
        car.start();
        car.displayInfo();
        bike.start();
        bike.displayInfo();
    }
}
