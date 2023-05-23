package com.example.miitnavigation.component;

public enum DayOfWeek {
    MONDAY("Понедельник"),
    TUESDAY("Вторник"),
    WEDNESDAY("Среда"),
    THURSDAY("Четверг"),
    FRIDAY("Пятница"),
    SATURDAY("Суббота"),
    SUNDAY("Воскресенье");

    @Override
    public String toString() {
        return "DayOfWeek{" +
                "name='" + name + '\'' +
                '}';
    }

    private final String name;

    DayOfWeek(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
