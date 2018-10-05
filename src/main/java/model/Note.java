package model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Note {
    private Integer id;
    private String value;
    @JsonProperty("created_at")
    private String createdIn;
    @JsonProperty("updated_at")
    private String UpdatedIn;

    public Note() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getCreatedIn() {
        return createdIn;
    }

    public void setCreatedIn(String createdIn) {
        this.createdIn = createdIn;
    }

    public String getUpdatedIn() {
        return UpdatedIn;
    }

    public void setUpdatedIn(String updatedIn) {
        UpdatedIn = updatedIn;
    }

}
