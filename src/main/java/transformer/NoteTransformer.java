package transformer;

import enums.Status;
import model.Assignment;
import model.CurrentNote;
import model.Note;
import org.apache.commons.collections.CollectionUtils;
import java.util.List;
import java.util.stream.Collectors;

public class NoteTransformer {
    private static final String NO_NOTE = "SIN NOTA";
    private static final String NO_STATUS = "SIN ESTADO";

    public List<CurrentNote> transform(List<Assignment> assignments) {
        return assignments.stream().map(assignment -> this.transformOneNote(assignment)).collect(Collectors.toList());
    }

    private CurrentNote transformOneNote(Assignment assignment) {
        CurrentNote currentNote = new CurrentNote();
        currentNote.setId(assignment.getId());
        currentNote.setTitle(assignment.getTitle());
        currentNote.setDescription(assignment.getDescription());

        if (CollectionUtils.isEmpty(assignment.getNotes())) {
            currentNote.setLastNote(NO_NOTE);
            currentNote.setStatus(NO_STATUS);
        } else {
            List<Note> notes = assignment.getNotes();
            Note lastNote = notes.get(notes.size() - 1);
            currentNote.setLastNote(lastNote.getValue());
            currentNote.setStatus(this.getStatus(lastNote.getValue()).name());
        }

        return currentNote;
    }

    private Status getStatus(String lastNote) {
        return ("M2345".contains(lastNote)) ? Status.DESAPROBADO : Status.APROBADO;
    }

}
