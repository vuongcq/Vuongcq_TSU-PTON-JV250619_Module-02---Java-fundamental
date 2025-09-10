package Session8.Ex3;

public class Square implements Colorable{
    private double chieuDai;
    private double chieuRong;
    private String color;

    //
    public Square (double chieuDai, double chieuRong) {
        this.chieuDai = chieuDai;
        this.chieuRong = chieuRong;
    }

    // ghi đè phương thức setColor
    @Override
    public void setColor(String color) {
        this.color = color;
        System.out.printf("Square color: %s\n", color);
    }
}

