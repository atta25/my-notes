package ui.vm;

import model.Student;
import org.uqbar.commons.model.annotations.Observable;
import repo.RepositoryCourse;

@Observable
public class UpdateStudentViewModel {
    private Student student;
    private Boolean enabled = false;

    public UpdateStudentViewModel(Student student) {
        this.student = student;
    }

    public String getFile() {
        return student.getFile();
    }

    public void setFile(String file) {
        this.student.setFile(file);
    }

    public String getFirstName() {
        return this.student.getFirstName();
    }

    public void setFirstName(String firstName) {
        this.student.setFirstName(firstName);
    }

    public String getLastName() {
        return this.student.getLastName();
    }

    public void setLastName(String lastName) {
        this.student.setLastName(lastName);
    }

    public String getUserGitHub() {
        return this.student.getUserGitHub();
    }

    public void setUserGitHub(String userGitHub) {
        this.student.setUserGitHub(userGitHub);
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public void updateData() {
        RepositoryCourse.getInstance().removeStudent(this.student.getFile());
        RepositoryCourse.getInstance().addStudent(this.student);
    }

}
