package ui.vm;

import model.Assignment;
import model.CurrentNote;
import model.Student;
import org.uqbar.commons.model.annotations.Observable;
import service.StudentService;
import transformer.NoteTransformer;
import utils.JsonUtils;
import java.util.List;

@Observable
public class AssignmentViewModel {
    private NoteTransformer noteTransformer;
    private List<CurrentNote> currentNotes;

    public AssignmentViewModel(String token) {
        String json = new StudentService().getAssignmentsData(token).getEntity(String.class);
        List<Assignment> assignments = new JsonUtils().getObject(json, Student.class).getAssignments();
        noteTransformer = new NoteTransformer();
        this.currentNotes = noteTransformer.transform(assignments);
    }

    public List<CurrentNote> getCurrentNotes() {
        return currentNotes;
    }

    public void setCurrentNotes(List<CurrentNote> currentNotes) {
        this.currentNotes = currentNotes;
    }

}
