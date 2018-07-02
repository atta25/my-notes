package App;

import model.Course;
import repo.RepositoryCourse;
import useful.JsonReaderFile;

public class Main {
    public static void main(String[] args) {
        loadCourse();
    }

    public static void loadCourse() {
        Course course = JsonReaderFile.getInstance().getCourse();
        RepositoryCourse.getInstance().setCourse(course);
    }

}
