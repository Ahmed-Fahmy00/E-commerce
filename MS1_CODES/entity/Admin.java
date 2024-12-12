package codes.oldCODES.entity;

import java.util.Date;

public class Admin extends User {
    private String role;
    private String workingHours;

    public Admin(String firstname, String lastname, String username, String email, Gender gender, String password, String role, String workingHours, Date dateOfBirth, String address, String phone) {
        super(firstname, lastname, username, email, gender, password, "Admin", address, phone, dateOfBirth);
        this.role = role;
        this.workingHours = workingHours;
    }

    public String getRole() {
        return role;
    }
    public String getWorkingHours() {
        return workingHours;
    }

    public void setRole(String role) {
        if (role == null || role.isEmpty()) {
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
    public void login() {
        System.out.println("Admin " + getUsername() + " logged in.");
    }

    @Override
    public void logout() {
        System.out.println("Admin " + getUsername() + " logged out.");
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
