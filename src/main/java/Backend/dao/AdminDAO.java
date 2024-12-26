package Backend.dao;

import Backend.entity.Admin;
import Backend.entity.Customer;
import Database.Database;
import com.almasb.fxgl.physics.CollisionDetectionStrategy;

import java.util.ArrayList;
import java.util.List;

public class AdminDAO implements DAO_interface<Admin> {

    @Override
    public void add (Admin admin) {
        Database.admins.add(admin);
    }

    @Override
    public void update(Admin oldAdmin, Admin updatedAdmin) {
        for (int i = 0; i < Database.admins.size(); i++) {
            Admin existingAdmin = Database.admins.get(i);
            if (existingAdmin.getId() == oldAdmin.getId()) {
                Database.admins.set(i, updatedAdmin);
            }
        }
    }

    @Override
    public void delete(Admin admin) {
        for (int i=0; i<Database.admins.size(); i++) {
            if (Database.admins.get(i).getId() == admin.getId()) {
                Database.admins.remove(i);
                break;
            }
        }
    }

    @Override
    public List<Admin> getAll() {
        return new ArrayList<>(Database.admins);
    }

}
