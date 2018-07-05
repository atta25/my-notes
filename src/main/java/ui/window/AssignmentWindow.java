package ui.window;

import model.CurrentNote;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;
import ui.vm.AssignmentViewModel;

public class AssignmentWindow extends SimpleWindow<AssignmentViewModel> {

    public AssignmentWindow(WindowOwner parent, AssignmentViewModel model) {
        super(parent, model);
    }

    @Override
    protected void addActions(Panel panel) { }

    @Override
    protected void createFormPanel(Panel panel) {
        this.setTitle("Notas");
        Table tableNotes = new Table<>(panel, CurrentNote.class);
        tableNotes.bindItemsToProperty("currentNotes");

        Column<CurrentNote> columnDescription = new Column<CurrentNote>(tableNotes);
        columnDescription.setTitle("Descripción");
        columnDescription.bindContentsToProperty("description");

        Column<CurrentNote> columnNotes = new Column<CurrentNote>(tableNotes);
        columnNotes.setTitle("Nota actual");
        columnNotes.bindContentsToProperty("lastNote");

        Column<CurrentNote> columnStatus = new Column<CurrentNote>(tableNotes);
        columnStatus.setTitle("Estado");
        columnStatus.bindContentsToProperty("status");

        new Button(panel)
                .setCaption("Cerrar")
                .onClick(this::close).setWidth(500);
    }

}
