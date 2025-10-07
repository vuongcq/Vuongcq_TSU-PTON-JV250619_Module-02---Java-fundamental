package Session16.Ex1_2_3_4;

import Session16.ConnectionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManagementStudent {
    public static void main(String[] args) throws SQLException {
//        Connection con = ConnectionDB.openConnection();
//        try{
//            System.out.println("Kết nối đến cơ sở dũ liệu thành công");
//        } catch (Exception e){
//            e.printStackTrace();
//        }
//        finally {
//            ConnectionDB.closeConnection(con);
//        }

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1.Hiển thị danh sách sinh viên.\n" +
                    "2.Thêm mới sinh viên.\n" +
                    "3.Sửa sinh viên.\n" +
                    "4.Xóa sinh viên.\n" +
                    "5.Tìm kiếm sinh viên.\n" +
                    "6.Thoát .\n" +
                    "Lựa chọn của bạn:");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    displayListStudent();
                    break;
                case 2:
                    addStudent(scanner);
                    break;
                case 3:
                    editStudent(scanner);
                    break;
                case 4:
                    deleteStudent(scanner);
                    break;
                case 5:
                    searchStudentByName(scanner);
                    break;
                case 6:
                    System.out.println("Good bye !");
                    System.exit(0);
            }

        }
    }


    // hàm hiển thị danh sách sinh viên
    public static void displayListStudent() throws SQLException {
        List<Students> studentsList = new ArrayList<>();
        try (Connection connection = ConnectionDB.openConnection()) {
            CallableStatement callableStatement = connection.prepareCall("{call get_all_students()}");
            ResultSet resultSet = callableStatement.executeQuery();

            while (resultSet.next()) {
                Students students = new Students();
                students.setId(resultSet.getInt("student_id"));
                students.setName(resultSet.getString("full_name"));
                students.setDateOfBirth(resultSet.getDate("date_of_birth").toLocalDate());
                students.setEmail(resultSet.getString("email"));
                studentsList.add(students);
            }
        } catch (Exception e) {
            System.out.println("Lấy dữ liệu ko thành công");
        }
        if (studentsList.isEmpty()) {
            System.out.println("Danh sách sinh viên trống !");
        } else {
            System.out.println("Danh sách sinh viên");
            for (Students student : studentsList) {
                student.display();
            }
        }
    }

    // Hàm thêm sinh viên
    public static void addStudent(Scanner scanner) {
        Students students = new Students();
        students.setName(validator.getString(scanner, "Nhập họ và tên:"));
        students.setEmail(validator.getString(scanner, "Nhập email:"));
        students.setDateOfBirth(validator.getLocalDate(scanner, "Nhập ngày tháng năm sinh theo định dạng dd/MM/yyyy:"));

        try (Connection connection = ConnectionDB.openConnection()) {
            CallableStatement callableStatement = connection.prepareCall("{Call add_student (?,?,?)}");
            callableStatement.setString(1, students.getName());
            callableStatement.setDate(2, Date.valueOf(students.getDateOfBirth()));
            callableStatement.setString(3, students.getEmail());
            boolean rs = callableStatement.executeUpdate() > 0;
            if (rs) {
                System.out.println("Thêm sinh viên thành công");
            } else {
                System.out.println("Thêm sinh viên bị lỗi");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    // Hàm tìm sv theo ID
    public static Students findByID(int studentID) {
        try (Connection connection = ConnectionDB.openConnection()) {
            CallableStatement callableStatement = connection.prepareCall("{Call find_student_by_id (?)}");
            callableStatement.setInt(1, studentID);
            ResultSet rs = callableStatement.executeQuery();
            if (rs.next()) {
                Students students = new Students();
                students.setId(rs.getInt("student_id"));
                students.setName(rs.getString("full_name"));
                students.setDateOfBirth(rs.getDate("date_of_birth").toLocalDate());
                students.setEmail(rs.getString("email"));
                return students;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Sửa sinh viên
    public static void editStudent(Scanner scanner) {
        int id_input = validator.getInt(scanner, "Nhập id sinh viên muốn sửa:");
        Students oldStudent = findByID(id_input);
        if (oldStudent == null) {
            System.out.println("Không tìm thấy sinh viên");
        } else {
            Students students = new Students();
            students.setId(oldStudent.getId());
            students.setName(validator.getString(scanner, "Nhập tên sinh viên"));
            students.setDateOfBirth(validator.getLocalDate(scanner, "Nhập ngày tháng năm sinh định dạng dd/MM/yyyy:"));
            students.setEmail(validator.getString(scanner, "Email:"));

            try (Connection connection = ConnectionDB.openConnection()) {
                CallableStatement callableStatement = connection.prepareCall("{Call update_student (?,?,?,?)}");
                callableStatement.setInt(1, oldStudent.getId());
                callableStatement.setString(2, students.getName());
                callableStatement.setDate(3, Date.valueOf(students.getDateOfBirth()));
                callableStatement.setString(4, students.getEmail());
                boolean rs = callableStatement.executeUpdate() > 0;
                if (rs) {
                    System.out.println("Sửa sinh viên thành công");
                } else {
                    System.out.println("Sửa sinh viên bị lỗi");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // xóa sinh viên
    public static void deleteStudent(Scanner scanner){
        int delId = validator.getInt(scanner, "Nhập id sinh viên muốn xóa:");
        Students students = findByID(delId);
        if (students == null) {
            System.out.println("Không tìm thấy sinh viên!");
        } else {
            try (Connection connection = ConnectionDB.openConnection()){
                CallableStatement callableStatement = connection.prepareCall("{Call delete_student (?)}");
                callableStatement.setInt(1, delId);
                boolean rs = callableStatement.executeUpdate() > 0;
                if (rs){
                    System.out.println("Xóa thành công!");
                } else {
                    System.err.println("Không thể xóa");
                }
            } catch (Exception e) {
                System.err.println("Xóa thất bại!");
            }
        }
    }

    // Tìm kiếm sinh viên theo tên
    public static void searchStudentByName(Scanner scanner) {
        String search = validator.getString(scanner, "Nhập tên muốn tìm kiếm:");
        List<Students> studentsList = new ArrayList<>();
        try (Connection connection = ConnectionDB.openConnection()){
            CallableStatement callableStatement = connection.prepareCall("{ call search_student_by_name(?)}");
            callableStatement.setString(1, search);
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()) {
                Students students = new Students();
                students.setId(rs.getInt("student_id"));
                students.setName(rs.getString("full_name"));
                students.setDateOfBirth(rs.getDate("date_of_birth").toLocalDate());
                students.setEmail(rs.getString("email"));
                studentsList.add(students);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        if (studentsList.isEmpty()) {
            System.err.println("Không tìm thấy sinh viên nào có chứa tên:" +search);
        } else {
            System.out.println("Kêết quả sau khi tìm kiếm với tên: "+search);
            for (Students students: studentsList){
                students.display();
            }
        }
    }

}
