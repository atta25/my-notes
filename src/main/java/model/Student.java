package model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class Student {
    @JsonProperty("code")
    private String file;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    @JsonProperty("github_user")
    private String userGitHub;
    private List<Assignment> assignments;
    private String token;

    public Student() {}

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserGitHub() {
        return userGitHub;
    }

    public void setUserGitHub(String userGitHub) {
        this.userGitHub = userGitHub;
    }

    public List<Assignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(List<Assignment> assignments) {
        this.assignments = assignments;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
