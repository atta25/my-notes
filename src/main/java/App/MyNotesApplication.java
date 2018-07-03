package App;

import model.Course;
import org.uqbar.arena.Application;
import org.uqbar.arena.windows.Window;
import repo.RepositoryCourse;
import ui.window.HomeWindow;
import useful.JsonReaderFile;

public class MyNotesApplication extends Application {
    public static void main(String[] args) {
        initialize();
        new MyNotesApplication().start();
    }

    public static void initialize() {
        Course course = JsonReaderFile.getInstance().getCourse();
        RepositoryCourse.getInstance().setCourse(course);
    }

    protected Window<?> createMainWindow() {
        return new HomeWindow(this);
    }
}
