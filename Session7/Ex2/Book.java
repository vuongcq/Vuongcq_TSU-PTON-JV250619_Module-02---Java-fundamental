package Session7.Ex2;

public class Book {
    // thuộc tính
    private String title;
    private String author;
    private int price;

    //constructor
    public Book (String title, String author, int price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        if ( price <0) {
            System.out.println("Giá không được âm!");
        } else {
            this.price = price;
        }
    }
}
