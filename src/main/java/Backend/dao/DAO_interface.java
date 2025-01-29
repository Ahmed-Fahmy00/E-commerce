package Backend.dao;

import Backend.entity.Cart;

import java.util.List;

public interface DAO_interface<T> {
    public void add(T item);
    public void delete(T item);
    public void update(T item1,T item2);
    public List<T> getAll();
}
