package Session11.Ex6;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Event {
    // khai báo biến
    private String name;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    // Constructor

    public Event() {
    }

    public Event(String name, LocalDateTime startDate, LocalDateTime endDate) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    // Method, getter/setter


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Event{" +
                "name='" + name + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }

    public void addData(Scanner scanner) {
        // nhập tên sự kiện
        do {
            try {
                System.out.println("Nhập tên sự kiện hoặc [exit] để thoát:");
                String nameInput = scanner.nextLine();
                if (nameInput.equalsIgnoreCase("exit")) {
                    // ném ra ngoại lệ để main xử lý
                    throw new RuntimeException("EXIT");
                }
                if (nameInput.isEmpty()) {
                    throw new Exception("Không được để trống!");
                }


                // nếu nhập ok, và k nhập exit
                this.name = nameInput;
                break;

            } catch (RuntimeException e) {
                throw e; // ném tiếp lên main
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }

        } while (true);

        // tạo định dạng theo ý muốn cho ngày tháng
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        // nhập thời gian bắt đầu
        do {
            try {
                System.out.println("Nhập thời gian bắt đầu: - Định dạng yyyy-MM-dd HH:mm");
                String startDayInput = scanner.nextLine();
                this.startDate = LocalDateTime.parse(startDayInput, formatter);
                break;
            } catch (Exception e) {
                System.err.println("Ngày giờ nhập vào sai định dạng");
            }

        } while (true);

        // nhập thời gian kết thúc

        do {
            try {
                System.out.println("Nhập thời gian kết thúc: - Định dạng yyyy-MM-dd HH:mm");
                String endDateInput = scanner.nextLine();
                this.endDate = LocalDateTime.parse(endDateInput, formatter);
                break;

            } catch (Exception e) {
                System.err.println("Ngày giờ nhập vào sai định dạng");
            }
        } while (true);
    }
}
