package Session7.Ex1;

public class Ex1 {
    public static void main(String[] args) {
        // hình chữ nhật 1
        Rectangle rect1 = new Rectangle();
        System.out.println("Hình chữ nhật 1:");
        rect1.display();
        rect1.getArea();
        rect1.getPerimeter();
        System.out.println("\n");

        // hình chữ nhật 2
        Rectangle rect2 = new Rectangle(5.0, 3.0);
        System.out.println("Hình chữ nhật 2:");
        rect2.display();
        rect2.getArea();
        rect2.getPerimeter();
    }
}
