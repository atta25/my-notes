package model;

import org.uqbar.commons.model.annotations.Observable;

@Observable
public class CurrentNote {
    private Integer id;
    private String title;
    private String description;
    private String lastNote;
    private String status;

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

    public String getLastNote() {
        return lastNote;
    }

    public void setLastNote(String lastNote) {
        this.lastNote = lastNote;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
