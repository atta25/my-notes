package App;

import org.uqbar.arena.Application;
import org.uqbar.arena.windows.Window;
import ui.vm.HomeViewModel;
import ui.window.HomeWindow;

public class MyNotesApplication extends Application {
    public static void main(String[] args) {
        new MyNotesApplication().start();
    }

    protected Window<?> createMainWindow() {
        return new HomeWindow(this, new HomeViewModel());
    }

}
