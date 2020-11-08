package ru.geekbrains.generics.handlers;

import ru.geekbrains.generics.entity.Developer;
import ru.geekbrains.generics.entity.logged_entity.LoggedDeveloper;

public class DeveloperHandler {

    public static void main(String[] args) {
        Developer dimonDev = new Developer("Dimon", 100_000, "OpenSource");
        Developer promotedDeveloper = changeDeveloper(dimonDev);
        LoggedDeveloper loggedDeveloper = new LoggedDeveloper(dimonDev, promotedDeveloper);
        System.out.println(loggedDeveloper);
    }

    public static Developer changeDeveloper(Developer d) {
        return d.changeProject("Sberbank")
                .changeSalary(1.5);
    }
}
