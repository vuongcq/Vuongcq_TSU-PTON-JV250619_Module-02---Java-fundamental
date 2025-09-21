package Session11.Ex6;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManagementEvent {
    static List <Event> listevent = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        do {
            try {
                Event event = new Event();
                event.addData(scanner);
                listevent.add(event);
            } catch (RuntimeException e){
                if (e.getMessage().equals("EXIT")){
                    System.out.println("Danh sách sự kiện: ");
                    displayEvent();
                    System.exit(0);
                }  else {
                    throw e; // ném lại nếu là RuntimeException khác
                }
            }

        } while (true);
    }
public static void displayEvent(){
        for (Event event: listevent){
            System.out.println(event);
        }
}

}
