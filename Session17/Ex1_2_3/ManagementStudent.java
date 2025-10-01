package Session17.Ex1_2_3;

import Session17.ConnectDatabase;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.List;

public class ManagementStudent {
    public void addStudents (List<Students> students){
        try (Connection connection = ConnectDatabase.openConnection()) {
             //Tắt auto-commit để tự kiểm soát transaction
            connection.setAutoCommit(false);

            CallableStatement callableStatement =
                    connection.prepareCall("{CALL add_students(?, ?)}");

            for (Students s : students  ) {
                callableStatement.setString(1, s.getName());
                callableStatement.setInt(2, s.getAge());
                callableStatement.executeUpdate();
            }

            // Nếu không lỗi thì commit
            connection.commit();
            System.out.println("Thêm tất cả sinh viên thành công!");
        } catch (Exception e) {
            e.printStackTrace();
            try (Connection connection = ConnectDatabase.openConnection()) {
                // Nếu có lỗi thì rollback
                connection.rollback();
                System.out.println("Đã rollback, không có dữ liệu nào được thêm.");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    }

    public static void updateStudent (Students students){
        Connection connection = null;
        try {
            connection = ConnectDatabase.openConnection();
            // Tắt auto-commit để tự quản lý transaction
            connection.setAutoCommit(false);

            CallableStatement stmt = connection.prepareCall("{CALL update_student(?, ?, ?)}");

                stmt.setInt(1, students.getId());
                stmt.setString(2, students.getName());
                stmt.setInt(3, students.getAge());
                stmt.executeUpdate();


            // Nếu tất cả thành công, commit
            connection.commit();
            System.out.println("Cập nhật tất cả sinh viên thành công!");

        } catch (Exception e) {
            e.printStackTrace();
            try {
                if (connection != null) {
                    // Nếu có lỗi, rollback
                    connection.rollback();
                    System.out.println("Có lỗi xảy ra, rollback tất cả thay đổi.");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } finally {
            try {
                if (connection != null) connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void deleteByAge( int ageDel){
        Connection connection = null;
        try {
            connection = ConnectDatabase.openConnection();
            connection.setAutoCommit(false); // bắt đầu transaction

            CallableStatement stmt = connection.prepareCall("{CALL delete_students_by_age(?)}");
            stmt.setInt(1, ageDel);
            int rowsDeleted = stmt.executeUpdate();

            connection.commit();
            System.out.println("Đã xóa " + rowsDeleted + " sinh viên có tuổi < " + ageDel);

        } catch (Exception e) {
            e.printStackTrace();
            try {
                if (connection != null) {
                    connection.rollback(); // rollback nếu có lỗi
                    System.out.println("Có lỗi xảy ra, rollback toàn bộ.");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } finally {
            try {
                if (connection != null) connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
