package Session8.Ex3;

public class Circle implements Colorable {
    private double banKinh;
    private String color;

    // Phương thức
    public Circle(double banKinh){
        this.banKinh = banKinh;
        this.color = color;
    }
    // ghi đè
    @Override
    public void setColor(String color){
        this.color = color;
        System.out.printf("Circle color: %s \n", color);
    }

    public double getBanKinh() {
        return banKinh;
    }

    public void setBanKinh(double banKinh) {
        this.banKinh = banKinh;
    }

    public String getColor() {
        return color;
    }
}
