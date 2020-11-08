package ru.geekbrains.generics.handlers.crisis;

import ru.geekbrains.generics.entity.LoggedEntity;

public abstract class AbstractCrisisHandler<T> {

    public LoggedEntity<T> handleEmployee(T employee){
        return new LoggedEntity<>(employee, handle(employee));
    }

    protected abstract T handle(T employee);
}
