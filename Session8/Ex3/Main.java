package Session8.Ex3;

import org.w3c.dom.ls.LSOutput;

public class Main {
    public static void main(String[] args) {
        Colorable circle =new Circle(5);
        Colorable rectangle = new Rectangle(5,10);
        Colorable square =new Square(6,12);
        circle.setColor("Red");
        rectangle.setColor("Blue");
        square.setColor("Green");


    }
}
