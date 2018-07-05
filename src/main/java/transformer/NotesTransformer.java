package transformer;

import enums.Status;
import model.Assignment;
import model.CurrentNote;
import java.util.List;
import java.util.stream.Collectors;

public class NotesTransformer {

    public List<CurrentNote> transform(List<Assignment> assignments) {
        return assignments.stream().map(assignment -> this.transformOneNote(assignment)).collect(Collectors.toList());
    }

    private CurrentNote transformOneNote(Assignment assignment) {
        CurrentNote currentNote = new CurrentNote();
        currentNote.setDescription(assignment.getDescription());
        String lastNote = this.getLastNote(assignment.getNotes());
        currentNote.setLastNote(lastNote);
        Status status = this.getStatus(lastNote);
        currentNote.setStatus(status.name());

        return currentNote;
    }

    private String getLastNote(List<String> notes) {
        //en principio asumo que siempre que haya una tarea voy a tener por lo menos una nota cargada
        return notes.get(notes.size() - 1);
    }

    private Status getStatus(String lastNote) {
        return ("M2345".contains(lastNote)) ? Status.NO_APROBO : Status.APROBO;
    }

}
