package Session8.Ex2;

abstract class Vehicle {
    private String name;
    private int speed;

    // Constructor
    public Vehicle (String name, int speed) {
        this.name = name;
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    // phương thức trừu tượng
    abstract void displayInfo();

    // phương thức thông thường
    void start(){
        System.out.println("Vehicle is Starting...");
    }
}
