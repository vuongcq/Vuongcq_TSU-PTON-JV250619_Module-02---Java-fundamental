package Session11.Ex5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EventManagement {
    static List<Event> listevents = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            Event event = new Event();
            boolean isContinue = event.addData(scanner);

            if (!isContinue) {
                System.out.println("\nDanh sách các sự kiện đã nhập:");
                displayEvent();
                break; // thoát vòng lặp
            }

            listevents.add(event); // thêm sự kiện hợp lệ
        }

        scanner.close();
    }

    // Hiển thị danh sách sự kiện
    public static void displayEvent() {
        if (listevents.isEmpty()) {
            System.out.println("Chưa có sự kiện nào.");
        } else {
            for (Event event : listevents) {
                System.out.println(event);
            }
        }
    }
}