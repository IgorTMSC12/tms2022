package eshop.repositories;


import eshop.entities.BaseEntity;
import eshop.util.ConnectionPool;

import java.util.List;

public interface BaseRepository<T extends BaseEntity> {
    ConnectionPool connectionPool = ConnectionPool.getInstance();

    void create(T entity);

    List<T> read();

    T update(T entity);

    void delete(int id);
}
