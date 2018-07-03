package model;

import org.uqbar.commons.model.annotations.Observable;

import java.util.List;

@Observable
public class Assignment {
    private String description;
    private List<String> notes;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getNotes() {
        return notes;
    }

    public void setNotes(List<String> notes) {
        this.notes = notes;
    }

}
