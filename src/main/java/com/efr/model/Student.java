package com.efr.model;

import java.util.Map;

public class Student {
    private String name; // Имя студента
    private Map<String, Integer> grades; // Оценки по предметам

    public Student(String name, Map<String, Integer> grades) {
        this.name = name;
        this.grades = grades;
    }

    public Map<String, Integer> getGrades() {
        return grades; // Получить оценки
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", grades=" + grades +
                '}';
    }
}
