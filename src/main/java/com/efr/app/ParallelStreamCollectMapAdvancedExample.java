package com.efr.app;

import com.efr.aggregator.StudentsAggregator;
import com.efr.generator.StudentsGenerator;
import com.efr.model.Student;

import java.util.List;

public class ParallelStreamCollectMapAdvancedExample {
    public static void main(String[] args) {
        List<Student> students = new StudentsGenerator().generateStudentsList(1000); // Генерация 1000 студентов

        // Вывод студентов для проверки
        students.forEach(System.out::println);

        // Получение и вывод среднего значения оценок по предметам
        System.out.println(StudentsAggregator.gradesOfSubjectForStudents(students));
    }
}
