package ru.geekbrains.generics.repository;

public interface Repository<T> {
    T findByName(String name);

    void save(T entity);

    void delete(T entity);
}
