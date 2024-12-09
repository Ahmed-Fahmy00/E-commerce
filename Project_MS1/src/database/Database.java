package database;

import entity.*;

public class Database {
    private static int c_customer = 10;
    private static int c_admin = 10;
    private static int c_product = 10;
    private static int c_catigory = 10;
    private static int c_order = 10;

    public static Customer[] customers = new Customer[c_customer];
    public static Admin[] admins = new Admin[c_admin];
    public static Product[] products = new Product[c_product];
    public static Category[] categories = new Category[c_catigory];
    public static Order[] orders = new Order[c_order];

    public static void doubleArraySizeIfFull() {
        customers = doubleArraySize(customers);
        admins = doubleArraySize(admins);
        products = doubleArraySize(products);
        categories = doubleArraySize(categories);
        orders = doubleArraySize(orders);
    }

    private static <T> T[] doubleArraySize(T[] array) {
        if (array[array.length - 1] != null) {
            T[] newArray = java.util.Arrays.copyOf(array, array.length * 2);
            return newArray;
        }
        return array;
    }

    public static <T> boolean add(T[] array, T item) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                array[i] = item;
                return true;
            }
        }
        return false;
    }

    public static <T> boolean remove(T[] array, T item) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null && array[i].equals(item)) {
                array[i] = null;
                return true;
            }
        }
        return false;
    }

}
