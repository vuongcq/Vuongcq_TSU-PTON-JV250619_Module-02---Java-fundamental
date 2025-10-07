package Session16.Ex1_2_3_4;

import java.time.LocalDate;

public class Students {
    private int id;
    private String name;
    private LocalDate dateOfBirth;
    private String email;

    // Constructor

    public Students() {
    }

    public Students(int id, String name, LocalDate dateOfBirth, String email) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public void display() {
        System.out.printf("| Student ID : %5d | Full Name : %20s | DateOfBirth : %15s | Email : %30s |\n" , id, name, dateOfBirth, email);
    }

}
