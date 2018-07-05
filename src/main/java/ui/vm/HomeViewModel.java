package ui.vm;

import model.Course;
import model.Student;
import org.uqbar.commons.model.annotations.Observable;
import repo.RepositoryCourse;
import java.util.Optional;

@Observable
public class HomeViewModel {
    Course course;
    private String file = "";

    public HomeViewModel() {
        super();
        course = RepositoryCourse.getInstance().getCourse();
    }

    public String getFile() {
        return this.file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public Optional<Student> getStudent() {
        return course.getStudents().stream().filter(student -> file.equals(student.getFile())).findAny();
    }

}
