package eshop.repositories;


import eshop.entities.BaseEntity;

import java.util.List;

public interface BaseRepository<T extends BaseEntity> {

    void create(T entity);

    List<T> read();

    void update(T entity);

    void delete(int id);
}
