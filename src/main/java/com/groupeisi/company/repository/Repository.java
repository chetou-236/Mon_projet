package com.groupeisi.company.repository;

import java.util.List;

public interface Repository <T> {
    boolean save(T t);
    boolean delete(long id,T t);
    boolean update(T t);
    List<T> list(T t);
    T get(long id,T t);
    List<T> listpaginate(T t, int page, int pageSize);
}