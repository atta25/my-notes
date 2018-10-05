package ui.vm;

import model.Student;
import org.uqbar.commons.model.annotations.Observable;
import service.StudentService;
import utils.JsonUtils;

@Observable
public class UpdateStudentViewModel {
    private Student student;
    private Boolean enabled = false;

    public UpdateStudentViewModel(String token) {
        String body = new StudentService().getStudentData(token).getEntity(String.class);
        this.student = new JsonUtils().getObject(body, Student.class);
        this.student.setToken(token);
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

    public String updateData() {
        String body = new JsonUtils().getJson(student);
        return new StudentService().updateResponse(student.getToken(), body);
    }

}
