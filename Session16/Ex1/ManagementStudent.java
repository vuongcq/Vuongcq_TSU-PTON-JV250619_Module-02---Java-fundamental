package Session16.Ex1;

import java.sql.*;
import java.time.LocalDate;
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

                    break;
                case 4:

                    break;
                case 5:
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

        System.out.println("Nhập họ và tên:");
        String name = scanner.nextLine();
        System.out.println("Nhập ngày tháng năm sinh:");
        LocalDate dob = LocalDate.parse(scanner.nextLine());
        System.out.println("Nhập email sinh viên:");
        String email = scanner.nextLine();
        students.setName(name);
        students.setDateOfBirth(dob);
        students.setEmail(email);

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

    // Sửa sinh viên

}
