package repo;

import model.Course;
import model.Student;

import java.util.Optional;

public class RepositoryCourse {
    private Course course;
    private static RepositoryCourse instance = new RepositoryCourse();
    public static RepositoryCourse getInstance() { return instance; }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Course getCourse() { return this.course; }

    public void removeStudent(String file) {
        this.course.getStudents().removeIf(student -> file.equals(student.getFile()));
    }

    public void addStudent(Student student) {
        this.course.getStudents().add(student);
    }

    public Optional<Student> getStudent(String file) {
        return course.getStudents().stream().filter(student -> file.equals(student.getFile())).findFirst();
    }

}

