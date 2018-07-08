import model.Course;
import model.Student;
import org.junit.Before;
import org.junit.Test;
import repo.RepositoryCourse;
import ui.vm.UpdateStudentViewModel;
import java.util.HashSet;
import java.util.Optional;
import static org.junit.Assert.*;

public class StudentTest {
    private Student student;
    private UpdateStudentViewModel updateStudentViewModel;
    private Course course;

    @Before
    public void init() {
        student = this.getStudent();
        course = new Course();
        course.setStudents(new HashSet<>());
        RepositoryCourse.getInstance().setCourse(course);
        RepositoryCourse.getInstance().addStudent(student);
        updateStudentViewModel = new UpdateStudentViewModel(student);
    }

    private Student getStudent() {
        Student studentTest = new Student();
        studentTest.setFile("100.000-0");
        studentTest.setFirstName("Homero");
        studentTest.setLastName("Simpson");
        studentTest.setUserGitHub("hthompson");

        return studentTest;
    }

    @Test
    public void updateStudent() {
        updateStudentViewModel.setFirstName("Cosme");
        updateStudentViewModel.setLastName("Fulanito");
        updateStudentViewModel.setUserGitHub("cfulanito");

        updateStudentViewModel.updateData();

        assertTrue(RepositoryCourse.getInstance().getCourse().getStudents().contains(student));

        Optional<Student> studentModifiend = RepositoryCourse.getInstance().getStudent(student.getFile());

        assertEquals("100.000-0", studentModifiend.get().getFile());
        assertEquals("Cosme",studentModifiend.get().getFirstName());
        assertEquals("Fulanito", studentModifiend.get().getLastName());
        assertEquals("cfulanito", studentModifiend.get().getUserGitHub());
    }

}
