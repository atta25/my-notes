package ui.window;

import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;
import ui.vm.StudentViewModel;

public class UpdateStudentWindow extends SimpleWindow<StudentViewModel> {

    public UpdateStudentWindow(WindowOwner parent) {
        super(parent, new StudentViewModel());
    }

    @Override
    protected void addActions(Panel panel) { }

    @Override
    protected void createFormPanel(Panel panel) {
        this.setTitle("Modificación de datos");
        new Label(panel).setText("Datos del estudiante: ");
        new Label(panel).setText("");
        Panel columns = new Panel(panel);
        columns.setLayout(new ColumnLayout(2));
        new Label(columns).setText("Legajo: ");
        TextBox file = new TextBox(columns);
        file.setWidth(200);
        file.bindEnabledToProperty("enabled");
        file.bindValueToProperty("file");
        new Label(columns).setText("Nombre: ");
        new TextBox(columns).setWidth(200);
        new Label(columns).setText("Apellido: ");
        new TextBox(columns).setWidth(200);
        new Label(columns).setText("Usuario de GitHub: ");
        new TextBox(columns).setWidth(200);
        new Label(panel).setText("");
        new Label(panel).setText("");
        new Button(panel)
                .setCaption("Modificar")
                .onClick(this::uploadData)
                .setWidth(150);
        new Button(panel)
                .setCaption("Cerrar")
                .onClick(this::close)
                .setWidth(150);
    }

    private void uploadData() {
    }

}
