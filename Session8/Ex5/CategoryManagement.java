package Session8.Ex5;

public class CategoryManagement implements ICRUD{
    private  Category[] categories;

    // phuương thức trả về mảng danh sách danh mục


    @Override
    public Category[] findAll() {
        return new Category[0];
    }
}

    // Phương thức thêm danh mục vào danh sách
    @Override
    public void addCategory (Category category){

    }

    // Phuong thuc cap nhat danh muc trong danh sach
    @Override
    public void updateCategory (Category category){

    }

    // Phuong thuc xoa danh muc khoi danh sach theo ID

    @Override
    public void deleteById(int id) {

    }
}
