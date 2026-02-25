package com.groupeisi.company.repository;

import java.util.List;

public interface IRepository<T> {

    boolean create(T entity);

    boolean update(T entity);

    boolean delete(Class<T> entityClass, String id);

    T find(Class<T> entityClass, String id);

    List<T> all(Class<T> entityClass);
}

