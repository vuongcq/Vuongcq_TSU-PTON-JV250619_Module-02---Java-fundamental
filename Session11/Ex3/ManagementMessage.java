package Session11.Ex3;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ManagementMessage {

    static List<Message> listMessage = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        // Chương trình main
        do {
            System.out.println("Nhập tên nguời gửi (hoặc [exit] để thoát):");
            String sender = scanner.nextLine();
            if (sender.trim().toLowerCase().equals("exit".toLowerCase())) {
                System.out.println("Đã thoát chương trình!");
                break;
            }
            System.out.println("Nhập nội dung tin nhắn:");
            String message = scanner.nextLine();
            Message message1 = new Message(sender, message, LocalDateTime.now());
            listMessage.add(message1);
            System.out.println("Nhập 'history' để xem lịch sử, hoặc 'filter' để lịc tin nhắn theo ngươ gửi, hoặc 'date' để lọc theo ngày:");
            String input = scanner.nextLine();
            switch (input.trim().toLowerCase()) {
                case "history":
                    // hiện lịch sử chat
                    displayHistoryChat();
                    break;
                case "filter":
                    searchByFilter();
                    break;
                case "date":
                    searchByDay();
                    break;
                default:
                    System.out.println("Chỉ nhập 'history' để xem lịch sử, hoặc 'filter' để lịc tin nhắn theo ngươ gửi, hoặc 'date' để lọc theo ngày");
                    break;
            }
        } while (true);
    }

    public static void displayHistoryChat() {
        for (Message message1 : listMessage) {
            System.out.println(message1);
        }
    }

    // Lọc tin nhắn theo người gửi và ngày bằng stream
    public static void searchByFilter() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tên người gửi:");
        String senderInput = scanner.nextLine();
        // Lọc bằng Stream
        List<Message> filtered = listMessage.stream()
                .filter(m -> m.getSender().toLowerCase().equals(senderInput))
                .collect(Collectors.toList());

        if (filtered.isEmpty()) {
            System.out.println("Không có tin nhắn nào từ người gửi này.");
        } else {
            filtered.forEach(System.out::println);
        }

    }

    public static void searchByDay() {
        Scanner scanner = new Scanner(System.in);
        LocalDate searchDate = null;
        do {
            try {
                System.out.println("Nhập ngày (yyyy-MM-dd):");
                String dateInput = scanner.nextLine();
                searchDate = LocalDate.parse(dateInput); // kiểm tra + gán luôn
                break;
            } catch (DateTimeParseException e) {
                System.out.println(" Sai định dạng ngày! Vui lòng nhập đúng dạng yyyy-MM-dd.");
            }
        } while (true);
        final LocalDate searchDayfinal = searchDate;
        // Lọc bằng Stream
        List<Message> filtered = listMessage.stream()
                .filter(m -> m.getTimestamp().toLocalDate().equals(searchDayfinal))
                .collect(Collectors.toList());

        if (filtered.isEmpty()) {
            System.out.println("Không có tin nhắn nào trong ngày này.");
        } else {
            filtered.forEach(System.out::println);
        }
    }
}
