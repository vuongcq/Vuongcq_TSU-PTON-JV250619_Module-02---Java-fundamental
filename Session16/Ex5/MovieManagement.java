package Session16.Ex5;

import Session16.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public  class MovieManagement {

    //Hàm thêm mới
    public static void addMovie(Scanner scanner) {
        Movies movie = new Movies();
        movie.setTitle(validator.getString(scanner, "Nhập tên phim:"));
        movie.setDirector(validator.getString(scanner, "Nhập tên đạo diễn:"));
        movie.setYear(validator.getInt(scanner, "Nhập năm xuất bản:"));
        try (Connection connection = ConnectionDBEx5.openConnection()) {
            CallableStatement callableStatement = connection.prepareCall("{Call add_movie (?,?,?)}");
            callableStatement.setString(1, movie.getTitle());
            callableStatement.setString(2, movie.getDirector());
            callableStatement.setInt (3, movie.getYear());

            boolean rs = callableStatement.executeUpdate() > 0;
            if (rs) {
                System.out.println("Thêm phim thành công!");
            } else {
                System.err.println("Thêm phim bị lỗi!");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    // hàm hiển thị
    public static void displayMovie(){
        List<Movies> listMovie = new ArrayList<Movies>();
        try (Connection connection = ConnectionDBEx5.openConnection()){
            CallableStatement callableStatement = connection.prepareCall("{call display_movie()}");
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()){
                Movies movie = new Movies();
                movie.setId(resultSet.getInt("id"));
                movie.setTitle(resultSet.getString("title"));
                movie.setDirector(resultSet.getString("director"));
                movie.setYear(resultSet.getInt("year"));
                listMovie.add(movie);
            }

        } catch (Exception e){
            System.err.println("Lấy dữ liệu không thành công");
        }
        if (listMovie.isEmpty()){
            System.err.println("Không có dữ liệu");
        } else {
            System.out.println("Danh sách phim là:");
            for (Movies movie : listMovie) {
                movie.display();
            }
        }
    }

    // Hàm chọn theo ID
    public static Movies findByID(int id){
        try (Connection connection = ConnectionDBEx5.openConnection()){
            CallableStatement callableStatement = connection.prepareCall("{call find_movie_by_id(?)}");
            callableStatement.setInt(1, id);
            ResultSet rs = callableStatement.executeQuery();
            if (rs.next()){
                Movies movie = new Movies();
                movie.setId(rs.getInt("id"));
                movie.setTitle(rs.getString("title"));
                movie.setDirector(rs.getString("director"));
                movie.setYear(rs.getInt("year"));
                return movie;
            }
        } catch (Exception e){
            e.printStackTrace();
        } return null;
    }
    // Hàm sửa phim
    public static void editMovie(Scanner scanner) {
        int id_in = validator.getInt(scanner,"Nhập vào id phim muốn sửa:");
        Movies findMovie = findByID(id_in);
        if (findMovie == null){
            System.err.println("Phim không tồn tại!");
        } else {
            Movies movie = new Movies();
            movie.setId(findMovie.getId());
            movie.setTitle(validator.getString(scanner,"Nhập tên phim:"));
            movie.setDirector(validator.getString(scanner, "Nhập tên đạo diễn:"));
            movie.setYear(validator.getInt(scanner, "Nhập năm phát hành:"));
            try (Connection connection = ConnectionDBEx5.openConnection()) {
                CallableStatement callableStatement = connection.prepareCall("{call edit_movie (?,?,?,?)}");
                callableStatement.setInt(1,findMovie.getId());
                callableStatement.setString(2,movie.getTitle());
                callableStatement.setString(3,movie.getDirector());
                callableStatement.setInt(4,movie.getYear());
                boolean rs = callableStatement.executeUpdate() > 0;
                if (rs) {
                    System.out.println("Sửa thành công!");
                } else {
                    System.err.println("Sửa phim bị lỗi!");
                }
            }catch (Exception e){

            }
        }
    }
    //xóa phim
    public static void deleteMovie(Scanner scanner){
        int delID = validator.getInt(scanner, "Nhập id phim muốn xóa:");
        Movies movie = findByID(delID);
        if (movie == null){
            System.err.println("Không tìm thấy phim");
        } else {
            try (Connection connection = ConnectionDBEx5.openConnection()){
                CallableStatement callableStatement = connection.prepareCall("{call delete_movie (?)}");
                callableStatement.setInt(1,delID);
                boolean rs = callableStatement.executeUpdate() > 0;
                if (rs) {
                    System.out.println("Xóa thành công");
                } else {
                    System.out.println("Không thể xóa");
                }
            } catch (Exception e){
                System.err.println("xóa thất bại!");
            }

        }

    }
}
