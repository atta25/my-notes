import model.Course;
import model.Student;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import repo.RepositoryCourse;
import ui.vm.UpdateStudentViewModel;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
