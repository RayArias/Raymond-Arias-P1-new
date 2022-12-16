package com.revature.erts.daos;

import java.util.List;

// CRUD = Create, Read, Update, Delete -OR- Open, Read, Put, Close
public interface CRUD_DAO<T> {
    void create(T obj);
    T read();
    void save(T obj);
    void delete(T obj);
    void update(T obj);
    T findById();
    List<T> findAll();
}
