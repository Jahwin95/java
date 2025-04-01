package rpg.dao;

import java.util.List;

public interface DAO<T> {
    // Save an item
    void save(T item);
    
    // Find an item by name
    T findByName(String name);
    
    // Get all items
    List<T> findAll();
    
    // Delete an item by name
    boolean delete(String name);
}