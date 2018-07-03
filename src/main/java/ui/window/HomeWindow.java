package ui.window;

import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;
import ui.vm.StudentViewModel;

public class HomeWindow extends SimpleWindow<StudentViewModel> {
    public HomeWindow(WindowOwner parent) {
        super(parent, new StudentViewModel());
    }

    @Override
    protected void addActions(Panel panelActions) { }

    @Override
    protected void createFormPanel(Panel panel) {
        this.setTitle("Mis Notas");
        new Label(panel).setText("Legajo: ");
        new TextBox(panel).setWidth(400);
        Panel columns = new Panel(panel);
        columns.setLayout(new ColumnLayout(2));
        new Button(columns)
                .setCaption("Ver notas")
                .onClick(this::seeNotes)
                .setWidth(200);
        new Button(columns)
                .setCaption("Actualizar datos")
                .onClick(this::updateData)
                .setWidth(200);
        new Button(panel)
                .setCaption("Cerrar")
                .onClick(this::close)
                .setWidth(200);
    }

    private void seeNotes() {
        new AssignmentWindow(this).open();
    }

    private void updateData() {
        new UpdateStudentWindow(this).open();
    }

}
