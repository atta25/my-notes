package ui.vm;

import org.uqbar.commons.model.annotations.Observable;

@Observable
public class StudentViewModel {
    private Boolean enabled = false;
    private String file = "150.000-3";

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

}
