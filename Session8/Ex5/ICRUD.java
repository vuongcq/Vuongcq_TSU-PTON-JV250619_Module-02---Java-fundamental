package Session8.Ex5;

public interface ICRUD {
    // phương thức
    abstract  Category[] findAll();
    abstract void addCategory (Category category);
    abstract  void updateCategory (Category category);
    abstract  void deleteById (int id);
}
