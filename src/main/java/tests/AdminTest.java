package tests;

import Backend.dao.*;
import Backend.entity.*;
import Backend.entity.Enum.Gender;
import Backend.entity.Enum.AdminRole;
import java.util.Date;

public class AdminTest {
    static AdminDAO adminDAO = new AdminDAO();

    public static void makeAdmins() {
        Admin admin1 = new Admin("Alice", "Smith", "naguib", "alice.admin@example.com", Gender.FEMALE, "securepass1", AdminRole.Administrator, "09:00-17:00", new Date(85, 2, 15), "101 Admin Blvd", "555-6789");
        adminDAO.add(admin1);

        Admin admin2 = new Admin("Bob", "Johnson", "bob_admin", "bob.admin@example.com", Gender.MALE, "securepass2", AdminRole.Moderator,"10:00-18:00", new Date(90, 6, 20),"202 Support St", "555-1234");
        adminDAO.add(admin2);

    }
}
