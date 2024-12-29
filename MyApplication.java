import models.Person;
import models.Student;
import models.Teacher;
import models.School;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MyApplication {
    public static void main(String[] args) throws FileNotFoundException {
        School school = new School();

        loadStudents(new File("C:\\Users\\Ktoto\\Desktop\\Softs\\IntelliJ IDEA 2024.3.1.1\\projects\\AITU\\assignment1_project\\src\\students.txt"), school);
        loadTeachers(new File("C:\\Users\\Ktoto\\Desktop\\Softs\\IntelliJ IDEA 2024.3.1.1\\projects\\AITU\\assignment1_project\\src\\teachers.txt"), school);

        System.out.println(school);

        // Вывод GPA студентов
        for (Person person : school.getMembers()) {
            if (person instanceof Student) {
                Student student = (Student) person;
                System.out.println(student.getSurname() + "'s GPA: " + student.calculateGPA());
            }
        }
    }

    private static void loadStudents(File file, School school) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String[] data = scanner.nextLine().split(" ");
            String name = data[0];
            String surname = data[1];
            int age = Integer.parseInt(data[2]);
            boolean gender = data[3].equalsIgnoreCase("Male");

            Student student = new Student(name, surname, age, gender);
            for (int i = 4; i < data.length; i++) {
                student.addGrade(Integer.parseInt(data[i]));
            }

            school.addMember(student);
        }
    }

    private static void loadTeachers(File file, School school) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String[] data = scanner.nextLine().split(" ");
            String name = data[0];
            String surname = data[1];
            int age = Integer.parseInt(data[2]);
            boolean gender = data[3].equalsIgnoreCase("Male");
            String subject = data[4];
            int yearsOfExperience = Integer.parseInt(data[5]);
            int salary = Integer.parseInt(data[6]);

            Teacher teacher = new Teacher(name, surname, age, gender, subject, yearsOfExperience, salary);
            school.addMember(teacher);
        }
    }
}
