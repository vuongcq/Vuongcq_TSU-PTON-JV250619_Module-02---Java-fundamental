package Session11.Ex2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ManagementStudent {
    public static void main(String[] args) {
        List <Student> listStudents = Arrays.asList(
                new Student("Alice", 20, 8.5),
                new Student("Bob", 22, 6.0),
                new Student("Charlie", 21, 7.5),
                new Student("David", 23, 9.0),
                new Student("Eve", 20, 5.5),
                new Student("Frank", 22, 8.0),
                new Student("Grace", 21, 7.0),
                new Student("Heidi", 23, 8.8),
                new Student("BIvan", 20, 6.5),
                new Student("Judy", 22, 7.2)
        );

        // Danh sách sinh viên có điểm lớn hơn 7, sắp xếp theo tên
        System.out.println("Danh sách sinh viên có điểm lớn hơn 7, sắp xếp theo tên:");
        listStudents.stream().filter(student -> student.getGrade() > 7).sorted((s1, s2) -> s1.getName().compareTo(s2.getName())).forEach(System.out::println);               // lọc theo điểm. // sắp xếp theo tên

    }
}
