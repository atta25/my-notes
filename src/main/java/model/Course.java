package model;

import java.util.Set;

public class Course {
    private Set<Student> students;
    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

}
