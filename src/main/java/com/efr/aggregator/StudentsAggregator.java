package com.efr.aggregator;

import com.efr.model.Student;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentsAggregator {
    public static Map<String, Double> gradesOfSubjectForStudents(List<Student> students) {
        return students.parallelStream() // Параллельный поток для увеличения производительности
                .flatMap(student -> student.getGrades().entrySet().stream()) // Второй стрим решил сделать секвентальным, для экономии ресурсов
                .collect(Collectors.groupingBy(
                        Map.Entry::getKey, // Группировка по предметам
                        Collectors.averagingDouble(Map.Entry::getValue) // Среднее значение оценок
                ));
    }
}