import enums.Status;
import model.Assignment;
import model.CurrentNote;
import org.junit.Before;
import org.junit.Test;
import ui.vm.AssignmentViewModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;

public class AssignmentsTest {
    List<Assignment> assignments;
    AssignmentViewModel assignmentViewModel;
    List<CurrentNote> currentNotes;

    @Before
    public void init() {
        assignments = this.getAssignments();
        assignmentViewModel = new AssignmentViewModel(assignments);
        currentNotes = assignmentViewModel.transformNotes(assignments);
    }

    private List<Assignment> getAssignments() {
        List<Assignment> assignments = new ArrayList<>();
        Assignment assignmentPartial = new Assignment();
        assignmentPartial.setDescription("Parcial");
        assignmentPartial.setNotes(Arrays.asList("4", "7"));
        Assignment assignmentTP = new Assignment();
        assignmentTP.setDescription("TP");
        assignmentTP.setNotes(Arrays.asList("B", "M"));
        assignments.add(assignmentPartial);
        assignments.add(assignmentTP);

        return assignments;
    }

    @Test
    public void getLastNoteOfEachAssignment() {
        CurrentNote currentNotePartial = currentNotes.get(0);
        assertEquals("7", currentNotePartial.getLastNote());
        CurrentNote currentNoteTP = currentNotes.get(1);
        assertEquals("M", currentNoteTP.getLastNote());
    }

    @Test
    public void getStatusOfEachAssignment() {
        CurrentNote currentNotePartial = currentNotes.get(0);
        assertEquals(Status.APROBO.name(), currentNotePartial.getStatus());
        CurrentNote currentNoteTP = currentNotes.get(1);
        assertEquals(Status.NO_APROBO.name(), currentNoteTP.getStatus());
    }

}
