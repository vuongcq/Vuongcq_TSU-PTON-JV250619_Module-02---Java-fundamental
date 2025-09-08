package Session7.Ex6;

public class Category {
    // khai báo
    private int id;
    private String name;
    private String description;

    // Constructor
    public Category(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;

    }

    // phương thức

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "{ID: " + id + ", Tên: " + name + ", Mô tả: " + description + "}";
    }
}
