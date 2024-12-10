package database;

import entity.*;
import java.util.ArrayList;

public class Database {

    public static ArrayList<Customer> customers = new ArrayList<>();
    public static ArrayList<Admin> admins = new ArrayList<>();
    public static ArrayList<Product> products = new ArrayList<>();
    public static ArrayList<Category> categories = new ArrayList<>();
    public static ArrayList<Order> orders = new ArrayList<>();
    public static ArrayList<Cart> carts = new ArrayList<>();

    public static <T> void add(ArrayList<T> list, T item) {
        list.add(item);
    }

    public static <T> boolean remove(ArrayList<T> list, T item) {
        return list.remove(item);
    }

    public static <T> ArrayList<T> getAll(ArrayList<T> list) {
        return new ArrayList<>(list); // Returns a copy of the list
    }

    public static <T> void printList(ArrayList<T> list) {
        for (T item : list) {
            System.out.println(item);
        }
    }

}
