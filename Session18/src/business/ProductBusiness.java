package business;

import entity.Product;
import util.ConnectionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductBusiness {
    public static List<Product> findAllProduct() {
        //1. Khai báo và khởi tạo đối tượng Connection kết nối từ ứng dung Java đến CSDL
        //2. Khai báo và khởi tạo đối tượng CallableStatement để gọi procedure
        //3. Set giá trị cho các tham số vào
        //4. Đăng ký kiểu dữ liệu cho các tham số trả ra
        /*5. Thực hiện gọi procedure
            - executeQuery(): nếu gọi procedure chứa câu lệnh select
            - executeUpdate(): nếu gọi procedure không có tham số trả ra
            - execute(): nếu gọi procedure có tham số trả ra
         */
        //6. Xử lý dữ liệu trả về
        //7. Đóng kết nối
        Connection conn = null;
        CallableStatement callSt = null;
        List<Product> listProducts = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call find_all_product()}");
            ResultSet rs = callSt.executeQuery();
            listProducts = new ArrayList<Product>();
            while (rs.next()) {
                Product product = new Product();
                product.setProductId(rs.getInt("product_id"));
                product.setProductName(rs.getString("product_name"));
                product.setPrice(rs.getFloat("product_price"));
                product.setTitle(rs.getString("product_title"));
                product.setCreated(rs.getDate("product_created"));
                product.setCatalog(rs.getString("product_catalog"));
                product.setStatus(rs.getBoolean("product_status"));
                listProducts.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return listProducts;
    }

    public static boolean isExistProductName(String productName) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = false;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call is_exist_product_name(?,?)}");
            //set giá trị cho tham số vào
            callSt.setString(1, productName);
            //đăng ký kiểu dữ liệu cho tham số trả ra
            callSt.registerOutParameter(2, Types.INTEGER);
            //thực hiện gọi procedure
            callSt.execute();
            //Lấy giá trị tham số trả ra
            int countProduct = callSt.getInt(2);
            if (countProduct > 0) {
                result = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return result;
    }

    public static boolean createProduct(Product product) {
        Connection conn = null;
        CallableStatement callSt = null;
        /*
         * Để quản lý giao dịch thì:
         * - set lại trạng thái autoCommit là false
         * - commit khi kết thúc giao dịch thành công
         * - rollback khi giao dịch thất bại
         * */
        try {
            conn = ConnectionDB.openConnection();
            conn.setAutoCommit(false);
            callSt = conn.prepareCall("{call create_product(?,?,?,?,?)}");
            callSt.setString(1, product.getProductName());
            callSt.setFloat(2, product.getPrice());
            callSt.setString(3, product.getTitle());
            //product.getCreated(): java.util.Date --> java.sql.Date
            callSt.setDate(4, new java.sql.Date(product.getCreated().getTime()));
            callSt.setString(5, product.getCatalog());
            callSt.executeUpdate();
            conn.commit();
            return true;
        } catch (Exception e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return false;
    }

    public static Product findById(int productId) {
        Connection conn = null;
        CallableStatement callSt = null;
        Product product = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call find_product_by_id(?)}");
            callSt.setInt(1, productId);
            ResultSet rs = callSt.executeQuery();
            if (rs.next()) {
                product = new Product();
                product.setProductId(rs.getInt("product_id"));
                product.setProductName(rs.getString("product_name"));
                product.setPrice(rs.getFloat("product_price"));
                product.setTitle(rs.getString("product_title"));
                product.setCreated(rs.getDate("product_created"));
                product.setCatalog(rs.getString("product_catalog"));
                product.setStatus(rs.getBoolean("product_status"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return product;
    }

    public static boolean updateProduct(Product product) {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call update_product(?,?,?,?,?,?,?)}");
            callSt.setInt(1, product.getProductId());
            callSt.setString(2, product.getProductName());
            callSt.setFloat(3, product.getPrice());
            callSt.setString(4, product.getTitle());
            //product.getCreated(): java.util.Date --> java.sql.Date
            callSt.setDate(5, new java.sql.Date(product.getCreated().getTime()));
            callSt.setString(6, product.getCatalog());
            callSt.setBoolean(7, product.isStatus());
            callSt.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return false;
    }

    public static boolean deleteProduct(int productId) {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call delete_product(?)}");
            callSt.setInt(1, productId);
            callSt.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return false;
    }

    public static List<Product> searchProductByName(String productName) {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Product> listProducts = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call find_product_by_name(?)}");
            callSt.setString(1, productName);
            ResultSet rs = callSt.executeQuery();
            listProducts = new ArrayList<Product>();
            while (rs.next()) {
                Product product = new Product();
                product.setProductId(rs.getInt("product_id"));
                product.setProductName(rs.getString("product_name"));
                product.setPrice(rs.getFloat("product_price"));
                product.setTitle(rs.getString("product_title"));
                product.setCreated(rs.getDate("product_created"));
                product.setCatalog(rs.getString("product_catalog"));
                product.setStatus(rs.getBoolean("product_status"));
                listProducts.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return listProducts;
    }

}
