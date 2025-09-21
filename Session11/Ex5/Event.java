package Session11.Ex5;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Event {
    private String name;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    // Constructor
    public Event() {}

    public Event(LocalDateTime startDate, String name, LocalDateTime endDate) {
        this.startDate = startDate;
        this.name = name;
        this.endDate = endDate;
    }

    // Phương thức nhập dữ liệu
    public boolean addData(Scanner scanner) {
        // Nhập tên sự kiện
        while (true) {
            System.out.println("Tên sự kiện (hoặc nhập 'exit' để thoát):");
            this.name = scanner.nextLine();

            if (this.name.equalsIgnoreCase("exit")) {
                return false; // báo cho EventManagement biết muốn thoát
            }

            if (!this.name.isEmpty()) break;
            System.err.println("Tên sự kiện không được để trống!");
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        // Nhập thời gian bắt đầu
        while (true) {
            try {
                System.out.println("Nhập thời gian bắt đầu (yyyy-MM-dd HH:mm):");
                String startInput = scanner.nextLine();
                this.startDate = LocalDateTime.parse(startInput, formatter);
                break;
            } catch (DateTimeParseException e) {
                System.err.println("Sai định dạng ngày giờ! Vui lòng nhập lại.");
            }
        }

        // Nhập thời gian kết thúc
        while (true) {
            try {
                System.out.println("Nhập thời gian kết thúc (yyyy-MM-dd HH:mm):");
                String endInput = scanner.nextLine();
                this.endDate = LocalDateTime.parse(endInput, formatter);

                if (this.endDate.isBefore(this.startDate)) {
                    System.err.println("Thời gian kết thúc phải sau thời gian bắt đầu!");
                    continue;
                }

                break;
            } catch (DateTimeParseException e) {
                System.err.println("Sai định dạng ngày giờ! Vui lòng nhập lại.");
            }
        }

        return true; // nhập thành công
    }

    @Override
    public String toString() {
        return "Event{" +
                "name='" + this.name + '\'' +
                ", startDate=" + this.startDate +
                ", endDate=" + this.endDate +
                '}';
    }
}
