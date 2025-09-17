package Session10.Ex1;


import java.util.Scanner;

public class InputData {

    // Phương thức nhập thông tin sinh viên
    Scanner sc = new Scanner(System.in);

    static public Students inputStudent(Scanner sc) {
        Students st = new Students();

        // Nhập tên, không được rỗng
        while (true) {
            System.out.println("Nhập tên sinh viên:");
            String name = sc.nextLine().trim();  // loại bỏ khoảng trắng đầu/cuối
            if (!name.isEmpty()) {
                st.setName(name);
                break;
            } else {
                System.err.println("Tên không được để trống. Vui lòng nhập lại.");
            }
        }

        // Nhập tuổi, không được rỗng, phải là số nguyên
        while (true) {
            try {
                System.out.println("Nhập tuổi:");
                String ageStr = sc.nextLine().trim();
                if (ageStr.isEmpty()) {
                    System.err.println("Tuổi không được để trống.");
                    continue;
                }
                st.setAge(Integer.parseInt(ageStr));
                break;
            } catch (NumberFormatException e) {
                System.err.println("Tuổi phải là số nguyên. Vui lòng nhập lại.");
            }
        }

        // Nhập điểm trung bình, có thể rỗng, phải là số thực
        while (true) {
            try {
                System.out.println("Nhập điểm TB:");
                String scoreStr = sc.nextLine().trim();
                if (scoreStr.isEmpty()) {
                    st.setAveScore(0);  // nếu muốn mặc định 0 khi bỏ trống
                } else {
                    st.setAveScore(Float.parseFloat(scoreStr));
                }
                break;
            } catch (NumberFormatException e) {
                System.err.println("Điểm phải là số thực. Vui lòng nhập lại.");
            }
        }

        return st;
    }
}