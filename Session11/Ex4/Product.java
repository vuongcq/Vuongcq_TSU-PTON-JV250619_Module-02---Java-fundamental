package Session11.Ex4;

import java.util.Scanner;

public class Product {
    private int id;
    private String name;
    private double price;

    //Constructor


    public Product() {}

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // Method


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("ID: %d, Name: %s, Price: %.1f", id, name, price);
    }

    public void addData(Scanner scanner){
        // bắt ngoại lệ ID không được để trống và phải là số nguyên
        do {
            try {

                System.out.println("Nhập vào ID:");
                String input = scanner.nextLine();

                if (input.isEmpty()){
                    throw new Exception("ID không được để trống");
                }
                this.id =Integer.parseInt(input);
                break;
            } catch (NumberFormatException e){
                System.err.println("ID phải là số nguuyên.");
            } catch (Exception e){
                System.err.println(e.getMessage());
            }

        } while (true);

        // bắt ngoại lệ của nhập tên sản phẩm không được để trống
        do {
            try {
                System.out.println("NHập vào tên sản phẩm:");
                this.name = scanner.nextLine();

                if (this.name.isEmpty()){
                    throw new Exception("Tên sản phẩm không được để trống!");
                }
                break;
            } catch (Exception e){
                System.err.println(e.getMessage());
            }
        } while(true);

        // bắt ngoại lệ giá phải là số thực và không được để trống
        do {
            try {
                System.out.println("Nhập vào giá:");
                String input =scanner.nextLine();
                if (input.isEmpty()){
                    throw new Exception("Giá sản phẩm không được để trống!");
                }
                this.price = Double.parseDouble(input);
                break;
            }catch (NumberFormatException e){
                System.err.println("Giá sản phẩm phải là số");
            }
            catch (Exception e){
                System.err.println(e.getMessage());
            }
        } while (true);


    }
}
