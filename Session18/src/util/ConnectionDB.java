package util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/md2_productmanagement";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "1234$";

    //Phương thức tạo đối tượng kết nối từ ứng dụng Java đến CSDL MySQL thông qua thư viện JDBC
    public static Connection openConnection() {
        /*
         * Phải có:
         * 1. Thư viện JDBC.jar (add vào trong project)
         * 2. Cung cấp các thông tin để kết nối đến CSDL
         *   - Driver: biết kết nối với loại cơ sở dữ liệu nào
         *   - URL: địa chỉ của CSDL cần kết nối
         *       + Địa chỉ server cài CSDL (localhost)
         *       + Port kết nối của CSDL: 3306
         *       + Tên CSDL cần kết nối
         *   - UserName của CSDL
         *   - Password của CSDL
         * */
        Connection conn = null;
        try {
            //Set Driver
            Class.forName(DRIVER);
            //Khởi tạo đối tượng Connection từ DriverManager
            conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    //Phương thức đóng kết nối sau khi làm việc xong với CSDL
    public static void closeConnection(Connection conn, CallableStatement callSt) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (callSt != null) {
            try {
                callSt.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
