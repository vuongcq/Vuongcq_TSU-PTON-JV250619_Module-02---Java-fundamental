package Session16.Ex5;

import java.util.Scanner;

public class validator {
    // ngoại lệ,
    // string không được để trống string
    // int, xét xem int, không được để trống

    // validator String
    public static String getString(Scanner scanner, String prompt) {
        String input ="";
        do {
            System.out.println(prompt);
            input = scanner.nextLine();
            if (input.isEmpty()){
                System.err.println("Không đươợc để trống!");
            } else {
                break;
            }

        } while (true);
        return input;
    }

    // validater Int
    public static int getInt(Scanner scanner, String prompt) {
        String input = "";
        do {
            input = getString(scanner, prompt);
            try {
                return Integer.parseInt(input);
            } catch (Exception e){
                System.err.println("Vui lòng nhập vào số nguyên");
            }
        } while (true);
    }
}
