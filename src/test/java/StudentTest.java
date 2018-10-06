import com.sun.jersey.api.client.ClientResponse;
import model.Assignment;
import model.Student;
import org.junit.Test;
import service.StudentService;
import utils.JsonUtils;
import java.util.List;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class StudentTest {
    private static final String TOKEN = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiIxMTEyMjIzMzMiLCJybmQiOiJ5SXNmZFIwN2lIR3BRRmVjYU9KT2VRPT0ifQ.9pVJGUXhrJPQ-TptNCt971l0h_1dWqWgMrHAWXJchho";

    @Test
    public void assignmentsTest() {
        ClientResponse response = new StudentService().getAssignmentsData(TOKEN);
        String json = response.getEntity(String.class);
        List<Assignment> assignments = new JsonUtils().getObject(json, Student.class).getAssignments();
        Assignment firstAssignment = assignments.get(0);
        Assignment secondAssignment = assignments.get(1);

        assertTrue(response.getStatus() == 200);

        assertThat(firstAssignment.getId(), is(1));
        assertEquals("TPA1", firstAssignment.getTitle());
        assertEquals("Entrega 1 del TP Anual", firstAssignment.getDescription());
        assertTrue(firstAssignment.getNotes().isEmpty());

        assertThat(secondAssignment.getId(), is(2));
        assertEquals("TPA2", secondAssignment.getTitle());
        assertEquals("Entrega 2 del TP Anual", secondAssignment.getDescription());
        assertTrue(secondAssignment.getNotes().isEmpty());
    }

    @Test
    public void studentDataTest() {
        Student student;
        ClientResponse response = new StudentService().getStudentData(TOKEN);
        String body = response.getEntity(String.class);
        student = new JsonUtils().getObject(body, Student.class);

        assertTrue(response.getStatus() == 200);

        student.setFirstName("first_name_test");
        student.setLastName("second_name_test");
        student.setUserGitHub("user_github_test");

        String studentJson = new JsonUtils().getJson(student);
        String result = new StudentService().updateResponse(TOKEN, studentJson);

        assertEquals("Los datos del estudiante han sido modificados.", result);
    }

}
