package Session7.Ex2;

public class Main {
    public static void main(String[] args) {
        Book book = new Book("Nhà Giả Kim", "Adam", 110000);
        System.out.println("Tên sách:" +book.getTitle());
        System.out.println("Tác giả:" +book.getAuthor());
        System.out.println("Giá:" +book.getPrice());

        // thay đổi thuộc tính price
        book.setPrice(1000);
        System.out.println("Giá mới:" +book.getPrice());
        book.setPrice(-40000);
    }
}
