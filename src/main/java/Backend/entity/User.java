package Backend.entity;

import Backend.entity.Enum.Gender;

import java.util.Date;
import java.util.Objects;

abstract public class User {
    private String firstname;
    private String lastname;
    private String username;
    private String email;
    private Gender gender;
    private String password;
    private String address;
    private String phone;
    private Date dateOfBirth;

    public User(String firstname, String lastname, String username, String email, Gender gender, String password, String address, String phone, Date dateOfBirth) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.email = email;
        this.gender = gender;
        this.password = password;
        this.address = address;
        this.phone = phone;
        this.dateOfBirth = dateOfBirth;
    }
    public User() {
    }

    public String getFirstnameName() {
        return firstname;
    }
    public String getLastnameName() {
        return lastname;
    }
    public String getUsername() {
        return username;
    }
    public String getEmail() {
        return email;
    }
    public Gender getGender() {
        return gender;
    }
    public String getPassword() {
        return password;
    }
    public String getAddress() {
        return address;
    }
    public String getPhone() {
        return phone;
    }
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setFirstName(String firstname) {
        if (!firstname.matches("[A-Za-z]+")) {
            throw new IllegalArgumentException("Lastname must contain alphabets only.");
        }
        this.firstname = firstname;
    }
    public void setLastname(String lastname) {
        if (!lastname.matches("[A-Za-z]+")) {
            throw new IllegalArgumentException("Lastname must contain alphabets only.");
        }
        this.lastname = lastname;
    }
    public void setUsername(String username) {
        if (!username.matches("[A-Za-z0-9]+")) {
            throw new IllegalArgumentException("Username must contain alphabets and numbers only.");
        }
        this.username = username;
    }
    public void setEmail(String email) {
        if (!email.matches("^(.+)@(.+)$")) {
            throw new IllegalArgumentException("Email must contain @ symbol.");
        }
        this.email = email;
    }
    public void setPassword(String password) {
        if (password == null ||!password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$")) {
            throw new IllegalArgumentException("Password must contain at least one digit, one lowercase letter, one uppercase letter, one special character, and at least 8 characters.");
        }
        this.password = password;
    }
    public void setAddress(String address) {
        if (!address.matches("[A-Za-z0-9 ]+")) {
            throw new IllegalArgumentException("Address must contain alphabets and numbers only.");
        }
        this.address = address;
    }
    public void setPhone(String phone) {
        if (!phone.matches("[0-9]+")) {
            throw new IllegalArgumentException("Phone must contain numbers only.");
        }
        this.phone = phone;
    }
    public void setDateOfBirth(Date dateOfBirth) {
        if (!dateOfBirth.before(new Date())) {
            throw new IllegalArgumentException("Date of birth must be before current date.");
        }
        this.dateOfBirth = dateOfBirth;
    }
    public void setGender(Gender gender) {
        this.gender = gender;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        User user = (User) obj;
        return Objects.equals(firstname, user.firstname) &&
                Objects.equals(lastname, user.lastname) &&
                Objects.equals(username, user.username) &&
                Objects.equals(email, user.email) &&
                gender == user.gender &&
                Objects.equals(password, user.password) &&
                Objects.equals(address, user.address) &&
                Objects.equals(phone, user.phone) &&
                Objects.equals(dateOfBirth, user.dateOfBirth);
    }


}