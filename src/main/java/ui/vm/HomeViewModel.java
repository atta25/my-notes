package ui.vm;

import model.Student;
import org.uqbar.commons.model.annotations.Observable;
import service.StudentService;
import utils.JsonUtils;

@Observable
public class HomeViewModel {
    private String token;

    public HomeViewModel() {
        super();
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Student getStudent() {
        String json = new StudentService().getStudentData(token).getEntity(String.class);
        Student student = new JsonUtils().getObject(json, Student.class);
        student.setToken(token);
        return student;
    }

}
