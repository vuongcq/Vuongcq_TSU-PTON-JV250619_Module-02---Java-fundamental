package Session16.Ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/ss16ex1?createDatabaseIfNotExist=true";
    private static final String USER = "vuongcq";
    private static final String PASS = "123456@";

    // Tạo kết nôi openConnection ()
    public static Connection openConnection(){
        try {
            Class.forName(DRIVER);
            Connection conn = DriverManager.getConnection(URL,USER,PASS);
            return conn;
        } catch (ClassNotFoundException e) {
            System.err.println("Không tìm thấy driver");
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    // ĐÓng kết nối
    public static void closeConnection(Connection conn){
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
