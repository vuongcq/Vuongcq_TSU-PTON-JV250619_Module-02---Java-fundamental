package Session7.Ex1;

public class Rectangle {
        // thuộc tính
        private double length;
        private double width;

        // Constructor
        public Rectangle (double length, double width) {
            this.length = length;
            this.width = width;
        }
        public Rectangle (){
            this.length = 1;
            this.width = 1;
        }

        // phương thức
        public void getArea(){
            System.out.println("Diện tích: " + this.length * this.width);
        }
        public void getPerimeter(){
            System.out.println("Chu vi:" + (this.length + this.width)*2);
        }
        public void display(){
            System.out.println("Chiều dài:" + this.length);
            System.out.println("Chiều rộng:" + this.width);

        }
    }
