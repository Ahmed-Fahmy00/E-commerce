package Backend.entity;

import Backend.entity.Enum.AdminRole;
import Backend.entity.Enum.Gender;

import java.util.Date;

public class Admin extends User {
    private AdminRole role;
    private String workingHours;
    private static int IdCounter = 1;
    private int Id;

    public Admin(String firstname, String lastname, String username, String email, Gender gender, String password, AdminRole role, String workingHours, Date dateOfBirth, String address, String phone) {
        super(firstname, lastname, username, email, gender, password, address, phone, dateOfBirth);
        this.role = role;
        this.workingHours = workingHours;
        this.Id = IdCounter++;
    }

    public int getId() {
        return Id;
    }
    public AdminRole getRole() {
        return role;
    }
    public String getWorkingHours() {
        return workingHours;
    }

    public void setRole(AdminRole role) {
        if (role == null) {
            throw new IllegalArgumentException("Role cannot be empty.");
        }
        this.role = role;
    }
    public void setWorkingHours(String workingHours) {
        if (!workingHours.matches("\\d{1,2}:\\d{2}-\\d{1,2}:\\d{2}")) {
            throw new IllegalArgumentException("Working hours must follow the format HH:mm-HH:mm.");
        }
        this.workingHours = workingHours;
    }

    @Override
    public String toString() {
        return "------ Admin Profile ------" +
                "\n  Firstname: " + getFirstnameName() +
                "\n  Lastname: " + getLastnameName() +
                "\n  Username: " + getUsername() +
                "\n  Email: " + getEmail() +
                "\n  Gender: " + getGender() +
                "\n  Role: " + getRole() +
                "\n  Working Hours: " + getWorkingHours() +
                "\n--------------------------";
    }
}
