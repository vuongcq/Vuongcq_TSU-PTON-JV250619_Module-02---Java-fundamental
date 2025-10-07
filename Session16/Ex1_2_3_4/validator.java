package Session16.Ex1_2_3_4;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class validator {
    // validator chuỗi
    public static String getString (Scanner scanner, String yeucau){
        String input ="";
        do {
            System.out.println(yeucau);
            input = scanner.nextLine();
            if (input.isEmpty()){
                System.err.println("Không được để trống");
            }  else {
                break;
            }
        } while (true);
        return input;
    }

    // validator số nguyên
    public static int getInt (Scanner scanner, String yeucau){
        String input ="";
        do {
            input = getString(scanner, yeucau);
            try {
                return Integer.parseInt(input);
            } catch (Exception e){
                System.err.println("Vui lòng nhập vào số nguyên");
            }
        } while (true);
    }

    // validator số thực
    public static double getDouble(Scanner scanner, String yeucau) {
        String input = "" ;
        do {

            input = getString(scanner, yeucau);
            try {
                return Double.parseDouble(input);
            }catch (Exception e) {
                System.out.println("Vui lòng nhập số thực");
            }
        }while (true);
    }

    // validator ngày tháng theo định dạng dd/MM/yyyy
    public static LocalDate getLocalDate(Scanner scanner, String yeucau) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        do {
            String input = getString(scanner, yeucau);
            try {
                return LocalDate.parse(input, formatter);
            } catch (Exception e) {
                System.out.println("Vui lòng nhập đúng định dạng dd/MM/yyyy: ");
            }
        }while (true);
    }
}
