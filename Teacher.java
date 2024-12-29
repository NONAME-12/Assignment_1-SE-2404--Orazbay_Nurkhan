package models;

public class Teacher extends Person {
    private String subject;
    private int yearsOfExperience;
    private int salary;

    public Teacher(String name, String surname, int age, boolean gender, String subject, int yearsOfExperience, int salary) {
        super(name, surname, age, gender);
        this.subject = subject;
        this.yearsOfExperience = yearsOfExperience;
        this.salary = yearsOfExperience > 10 ? salary + (salary * 10 / 100) : salary;
    }

    public int getSalary() {
        return salary;
    }

    public String getSubject() {
        return subject;
    }

    @Override
    public String toString() {
        return super.toString() + " I teach " + subject + " with a salary of " + salary + ".";
    }
}
