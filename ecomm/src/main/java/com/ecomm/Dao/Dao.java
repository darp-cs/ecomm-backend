package com.ecomm.Dao;
import java.util.ArrayList;

public interface Dao<T> {
    
    T get(int id);
    
    ArrayList<T> getAll();
    
    void save(T t);
        
    void delete(T t);
}