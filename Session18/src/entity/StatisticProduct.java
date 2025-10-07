package entity;

public class StatisticProduct {
    private String catalog;
    private int cntProduct;

    public StatisticProduct() {
    }

    public StatisticProduct(String catalog, int cntProduct) {
        this.catalog = catalog;
        this.cntProduct = cntProduct;
    }

    public String getCatalog() {
        return catalog;
    }

    public void setCatalog(String catalog) {
        this.catalog = catalog;
    }

    public int getCntProduct() {
        return cntProduct;
    }

    public void setCntProduct(int cntProduct) {
        this.cntProduct = cntProduct;
    }

    @Override
    public String toString() {
        return String.format("Danh mục: %s - Số sản phẩm: %d\n", this.catalog, this.cntProduct);
    }
}
