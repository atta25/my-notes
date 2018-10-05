package model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.uqbar.commons.model.annotations.Observable;

import java.util.List;

@Observable
public class Assignment {
    private Integer id;
    private String title;
    private String description;
    @JsonProperty("grades")
    private List<Note> notes;

    public Assignment() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

}
