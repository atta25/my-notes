package ui.window;

import model.Assignment;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;
import ui.vm.AssignmentViewModel;

public class AssignmentWindow extends SimpleWindow<AssignmentViewModel> {

    public AssignmentWindow(WindowOwner parent) {
        super(parent, new AssignmentViewModel());
    }

    @Override
    protected void addActions(Panel panel) { }

    @Override
    protected void createFormPanel(Panel panel) {
        this.setTitle("Notas");
        Table tableNotes = new Table<>(panel, Assignment.class);

        Column<Assignment> columnDescription = new Column<Assignment>(tableNotes);
        columnDescription.setTitle("Descripción");

        Column<Assignment> columnNotes = new Column<Assignment>(tableNotes);
        columnNotes.setTitle("Nota");

        new Button(panel)
                .setCaption("Cerrar")
                .onClick(this::close).setWidth(500);
    }

}
