package Session10.Ex2;

import java.util.Scanner;

public class Books {

    // khai báo đối tượng, biến
    private String name;
    private String author;
    private int year;

    //Constructor
    public Books() {}

    public Books(String name, String author, int year) {
        this.name = name;
        this.author = author;
        this.year = year;
    }

    //Method
    //geter. sett


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    // chức năng thêm mới

    // Hàm thêm mới
    public  void addBook (Scanner scanner){
        // tên sách không được dể trống, phải là string


        do {
            try {
                System.out.println("Nhập tên sách:");
                this.name = scanner.nextLine();

                if (this.name.isEmpty()){
                    throw new Exception("Tên sách không được để trống!");
                }
                //hợp lệ
                break;
            } catch (Exception e){
                System.err.println(e.getMessage());
            }

        } while (true);

        // tên ta giả không đợc để trống/ phải là string
        do {
            try {
                System.out.println("Nhập tác giả:");
                this.author = scanner.nextLine();

                if (this.author.isEmpty()){
                    throw new Exception("Tên tác giả không được để trống!");
                }
                break;
            } catch (Exception e){
                System.err.println(e.getMessage());
            }
        } while (true);

        // năm xuất bản khng được để trống và phải là số nguyên


        do {
            try {
                System.out.println("Nhập năm xuất bản:");
                String input = scanner.nextLine();

                if (input.isEmpty()){
                    throw new Exception("Năm xuất bản không được để trống.");
                }
                this.year = Integer.parseInt(input);
                break;
            }
            catch (NumberFormatException e){
                System.err.println("Năm phải là 1 số nguyên.");
            }
            catch (Exception e){
                System.err.println(e.getMessage());
            }
        } while (true);
    }

    // Hàm hiển thị
    public  void displayBook (){
        System.out.printf("Tên sách: %s, Tên tác giả: %s, Năm xuất bản: %d \n", this.name, this.author, this.year);
    }

}
