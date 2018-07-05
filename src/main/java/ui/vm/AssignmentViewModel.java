package ui.vm;

import model.Assignment;
import model.CurrentNote;
import org.uqbar.commons.model.annotations.Observable;
import transformer.NotesTransformer;
import java.util.List;

@Observable
public class AssignmentViewModel {
    private NotesTransformer notesTransformer;
    private List<CurrentNote> currentNotes;

    public AssignmentViewModel(List<Assignment> assignments) {
        this.notesTransformer = new NotesTransformer();
        this.currentNotes = this.transformNotes(assignments);
    }

    public List<CurrentNote> getCurrentNotes() {
        return currentNotes;
    }

    public void setCurrentNotes(List<CurrentNote> currentNotes) {
        this.currentNotes = currentNotes;
    }

    public List<CurrentNote> transformNotes(List<Assignment> assignments) {
        return notesTransformer.transform(assignments);
    }

}
