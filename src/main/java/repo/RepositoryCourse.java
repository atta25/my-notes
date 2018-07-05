package repo;

import model.Course;

public class RepositoryCourse {
    private Course course;
    private static RepositoryCourse instance = new RepositoryCourse();
    public static RepositoryCourse getInstance() { return instance; }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Course getCourse() { return this.course; }

}

