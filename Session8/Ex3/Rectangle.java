package Session8.Ex3;

import java.awt.*;

public class Rectangle implements Colorable {
    private String color;
    private double chieuDai;
    private double chieuRong;

    public Rectangle (double chieuDai, double chieuRong) {
        this.chieuDai = chieuDai;
        this.chieuRong = chieuRong;
    }

    // phương thức ghi đe
    @Override
    public void setColor (String Color){
        this.color = Color;
        System.out.printf("Rectangle color: %s \n", color);
    }

    public String getColor() {
        return color;
    }

    public double getChieuDai() {
        return chieuDai;
    }

    public void setChieuDai(double chieuDai) {
        this.chieuDai = chieuDai;
    }

    public double getChieuRong() {
        return chieuRong;
    }

    public void setChieuRong(double chieuRong) {
        this.chieuRong = chieuRong;
    }
}
