package com.efr.generator;

import com.efr.model.Student;

import java.util.*;

public class StudentsGenerator {
    private List<String> studentNames = Arrays.asList(
            "Александр", "Дмитрий", "Максим", "Иван", "Кирилл",
            "Андрей", "Михаил", "Егор", "Роман", "Артем",
            "Сергей", "Николай", "Владимир", "Антон", "Олег",
            "Игорь", "Константин", "Алексей", "Юрий", "Павел"
    );

    private List<String> studentSurnames = Arrays.asList(
            "Иванов", "Петров", "Сидоров", "Смирнов", "Кузнецов",
            "Попов", "Васильев", "Павлов", "Новиков", "Фёдоров",
            "Козлов", "Соловьёв", "Морозов", "Лебедев", "Семенов",
            "Егоров", "Волков", "Никитин", "Михайлов", "Захаров"
    );

    private List<String> subjectList = Arrays.asList(
            "Математика", "Физика", "Химия", "Биология", "История",
            "География", "Литература", "Иностранный язык", "Информатика", "Музыка",
            "Искусство", "Физическая культура", "Экономика", "Обществознание", "Этика",
            "Философия", "Психология", "Технология", "Культура речи", "Экология"
    );
    public List<Student> generateStudentsList(int amount) {
        Set<String> usedNames = new HashSet<>();
        List<Student> students = new ArrayList<>();

        Random random = new Random();

        while (students.size() < amount && usedNames.size() < studentNames.size() * studentSurnames.size()) {
            // Генерируем уникальное имя студента (имя + фамилия)
            String name;
            String surname;

            // Генерируем случайное имя и фамилию
            name = studentNames.get(random.nextInt(studentNames.size()));
            surname = studentSurnames.get(random.nextInt(studentSurnames.size()));
            String fullName = name + " " + surname;

            // Проверяем, чтобы имя не повторялось
            if (usedNames.contains(fullName)) {
                continue; // если имя уже есть, пропускаем итерацию
            }

            usedNames.add(fullName);

            // Генерируем случайное количество предметов для студента
            int subjectsCount = random.nextInt(subjectList.size()) + 1; // от 1 до количества предметов
            Set<String> chosenSubjects = new HashSet<>();

            // Выбираем уникальные предметы
            while (chosenSubjects.size() < subjectsCount) {
                String subject = subjectList.get(random.nextInt(subjectList.size()));
                chosenSubjects.add(subject);
            }

            // Генерируем оценки для выбранных предметов
            Map<String, Integer> grades = new HashMap<>();
            for (String subject : chosenSubjects) {
                grades.put(subject, random.nextInt(100) + 1); // оценки от 1 до 100
            }

            // Создаем студента и добавляем в список
            students.add(new Student(fullName, grades));
        }

        return students;
    }
}
