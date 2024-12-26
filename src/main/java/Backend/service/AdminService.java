package Backend.service;

import Backend.dao.AdminDAO;
import Backend.entity.Admin;
import java.util.List;

public class AdminService {

    AdminDAO adminDAO = new AdminDAO();


    public Admin getAdminByUsername(String username) {
        if (username == null) {
            System.out.println("Error: Username cannot be null.");
            return null;
        }
        List<Admin> admins = adminDAO.getAll();
        for (Admin admin : admins) {
            if (admin != null && admin.getUsername().equals(username)) {
                return admin;
            }
        }
        System.out.println("Admin not found with username: " + username);
        return null;
    }

}