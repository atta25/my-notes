package ui.window;

import exception.ClientResponseException;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;
import ui.vm.AssignmentViewModel;
import ui.vm.HomeViewModel;
import ui.vm.UpdateStudentViewModel;

public class HomeWindow extends SimpleWindow<HomeViewModel> {

    public HomeWindow(WindowOwner parent, HomeViewModel model) {
        super(parent, model);
    }

    @Override
    protected void addActions(Panel panelActions) { }

    @Override
    protected void createFormPanel(Panel panel) {
        this.setTitle("Mis Notas");
        new Label(panel).setText("Token: ");
        new TextBox(panel)
                .setWidth(400)
                .bindValueToProperty("token");
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
        try {
            new AssignmentWindow(this, new AssignmentViewModel(this.getModelObject().getStudent().getToken())).open();
        } catch (ClientResponseException e) {
            this.showError(e.getMessage());
        }
    }

    private void updateData() {
        try {
            new UpdateStudentWindow(this, new UpdateStudentViewModel(this.getModelObject().getStudent().getToken())).open();
        } catch (ClientResponseException e) {
            this.showError(e.getMessage());
        }
    }

}
