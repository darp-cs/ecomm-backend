package com.ecomm.Dao;
import java.util.ArrayList;

//Interfaces can't be instantiated, but can be implemented
//All classes that implement a interface have to implement all methods
//Interfaces are blue prints that can be used by serveral classe that need common methods
//T data types are generic data types that can be any type
public interface Dao<T> {
    
    T get(int id);
    
    ArrayList<T> getAll();
    
    void save(T t);
        
    void delete(T t);
}