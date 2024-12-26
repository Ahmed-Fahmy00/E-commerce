package Backend.service;

import Backend.entity.Admin;
import Backend.entity.Customer;
import Backend.entity.User;

public class UserService{
    AdminService adminService = new AdminService();
    CustomerService customerService = new CustomerService();

    private static UserService instance;

    private UserService() {}
    public static UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }

    private User loggedInUser; // Keep track of the logged-in user

    public Customer loginGUICustomer(String username, String password) {
        Customer customer = customerService.getCustomerByUsername(username);
        if (customer != null && customer.getPassword().equals(password.trim())) {
            loggedInUser = customer;
            return customer;
        }
        return null;
    }
    public Admin loginGUIAdmin(String username, String password) {
        Admin admin = adminService.getAdminByUsername(username);
        if (admin != null && admin.getPassword().equals(password.trim())) {
            loggedInUser = admin;
            return admin;
        }
        return null;
    }

    public void logout() {
        loggedInUser = null;
    }

    public boolean changePassword(String newPassword) {
        if (loggedInUser != null) {
            loggedInUser.setPassword(newPassword); // Assuming User class has setPassword
            return true;
        }
        return false;
    }

}


