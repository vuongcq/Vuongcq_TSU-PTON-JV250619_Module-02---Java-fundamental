package Session17.Ex1_2_3;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ManagementStudent manager = new ManagementStudent();
//         //Thêm sinh viên mới
        List<Students> listStudents = Arrays.asList(
                new Students(0, "Nguyen Van A", 20),
                new Students(0, "Tran Thi B", 22),
                new Students(0, "Le Van C", 19)
        );
        manager.addStudents(listStudents);
//
//        // Cập nhật tuổi của Nguyễn Văn A
//        Students student = new Students(1, "Nguyễn Văn A", 21);
//        manager.updateStudent(student);

        // Xóa sinh viên tuổi bé hơn tuổi nhập vào
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tuổi sv muốn xóa:");
        int ageDel = Integer.parseInt(scanner.nextLine());
        manager.deleteByAge(ageDel);

    }
}
