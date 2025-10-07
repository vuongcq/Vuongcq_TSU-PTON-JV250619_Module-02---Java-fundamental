package ex.ex01.business;

import ex.ex01.entity.Product;

import java.util.*;

public class ProductBusiness {
    public static List<Product> listProducts = new ArrayList<Product>();

    public static void addProduct(Scanner scanner) {
        System.out.println("Nhập vào số lượng sản phẩm cần thêm:");
        int cntProducts = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < cntProducts; i++) {
            Product product = new Product();
            product.inputData(scanner);
            listProducts.add(product);
        }
    }

    public static void displayListProducts() {
        for (Product product : listProducts) {
            System.out.println(product);
        }
    }

    public static void updateProduct(Scanner scanner) {
        System.out.println("Nhập vào mã sản phẩm cần cập nhật:");
        int productId = Integer.parseInt(scanner.nextLine());
        int indexUpdate = findIndexById(productId);
        if (indexUpdate == -1) {
            System.err.println("Mã sản phẩm không tồn tại");
            return;
        }
        boolean isNotExit = true;
        do {
            System.out.println("1. Cập nhật tên sản phẩm");
            System.out.println("2. Cập nhật giá sản phẩm");
            System.out.println("3. Cập nhật danh mục sản phẩm");
            System.out.println("4. Cập nhật số lượng tồn kho");
            System.out.println("5. Thoát");
            System.out.print("Lựa chọn của bạn:");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Nhập vào tên mới của sản phẩm:");
                    listProducts.get(indexUpdate).setProductName(scanner.nextLine());
                    break;
                case 2:
                    System.out.println("Nhập vào giá mới của sản phẩm:");
                    listProducts.get(indexUpdate).setPrice(Float.parseFloat(scanner.nextLine()));
                    break;
                case 3:
                    System.out.println("Nhập vào tên danh mục mới của sản phẩm:");
                    listProducts.get(indexUpdate).setCategory(scanner.nextLine());
                    break;
                case 4:
                    System.out.println("Nhập vào số lượng tồn kho mới của sản phẩm:");
                    listProducts.get(indexUpdate).setQuantity(Integer.parseInt(scanner.nextLine()));
                    break;
                case 5:
                    isNotExit = false;
                    break;
                default:
                    System.err.println("Vui lòng chọn từ 1-5");
            }
        } while (isNotExit);
    }

    public static int findIndexById(int productId) {
        for (int i = 0; i < listProducts.size(); i++) {
            if (listProducts.get(i).getProductId() == productId) {
                return i;
            }
        }
        return -1;
    }

    public static void deleteProduct(Scanner scanner) {
        System.out.println("Nhập vào mã sản phẩm cần xóa:");
        int productId = Integer.parseInt(scanner.nextLine());
        int indexDelete = findIndexById(productId);
        if (indexDelete == -1) {
            System.err.println("Mã sản phẩm không tồn tại");
            return;
        }
        listProducts.remove(indexDelete);
        System.out.println("Xóa thành công");
    }

    public static void searchProductByName(Scanner scanner) {
        System.out.println("Nhập vào tên sản phẩm cần tìm:");
        String productName = scanner.nextLine();
        for (Product product : listProducts) {
            if (product.getProductName().toLowerCase().contains(productName.toLowerCase())) {
                System.out.println(product);
            }
        }
    }

    public static void sortProductByPriceASC() {
        Collections.sort(listProducts);
    }

    public static void sortProductByQuantityDESC() {
        Collections.sort(listProducts, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o2.getQuantity() - o1.getQuantity();
            }
        });
    }
}
