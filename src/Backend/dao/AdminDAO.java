package Backend.dao;

import Backend.entity.Admin;
import Database.Database;

public class AdminDAO {
    public  void addAdmin(Admin admin) {
        if (getAdminByUsername(admin.getUsername()) == null) {
            Database.admins.add(admin);
        }
    }

    public Admin getAdminByUsername(String username) {
        for (int i = 0; i < Database.admins.size(); i++) {
            Admin admin = Database.admins.get(i);
            if (admin != null && admin.getUsername().equals(username)) {
                return admin;
            }
        }
        return null;
    }

}
