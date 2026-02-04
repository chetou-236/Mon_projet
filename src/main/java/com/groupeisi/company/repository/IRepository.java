package com.groupeisi.company.repository;

import java.util.List;

public interface IRepository <T>{
    boolean create(T t);
    boolean delete(String id, T t);
    boolean update(T t);
    T find(String id, T t);
    List<T> all(T t);
}
