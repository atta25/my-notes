import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import model.Course;
import model.CurrentNote;
import model.Student;
import repo.RepositoryCourse;
import ui.vm.UpdateStudentViewModel;

public class ReadJsonTest {

	private ObjectMapper objectMapper;
	private File fileJson;
	private List<Student> studentsFromJson = new ArrayList<Student>();
	private UpdateStudentViewModel updateStudentViewModel;
	private Student studentToUpdate;
	private Course course;
	
	
	@Before
	public void initialize() throws JsonParseException, JsonMappingException, IOException {
		course = new Course();
        course.setStudents(new HashSet<>());
        RepositoryCourse.getInstance().setCourse(course);
       
		objectMapper = new ObjectMapper();
		fileJson = new File("C:\\notes.json");
		studentsFromJson = objectMapper.readValue(fileJson,new TypeReference<List<Student>>(){});
		studentToUpdate = studentsFromJson.get(0);
		RepositoryCourse.getInstance().addStudent(studentToUpdate);
		updateStudentViewModel = new UpdateStudentViewModel(studentToUpdate);
	}
	
	 @Test
	 public void sizeOfStudentsInTheCourse() throws JsonParseException, JsonMappingException, IOException {
		 
		 Assert.assertEquals(studentsFromJson.size(), 5);
	 }
	 
	 @Test
	 public void readFromJsonAndTakeDetailsToSpecificStudent() throws JsonParseException, JsonMappingException, IOException{
	    
	    Student anStudent = studentsFromJson.get(0);
	    Assert.assertEquals(anStudent.getFirstName(),"juan");
	    Assert.assertEquals(anStudent.getLastName(), "perez");
	    Assert.assertEquals(anStudent.getUserGitHub(), "juanp");
	    Assert.assertEquals(anStudent.getFile(), "150.001-1");
	    	
	 }
	 
	 @Test
	 public void whoStudentHasTheBestLastNoteInHisFirstExam() throws JsonParseException, JsonMappingException, IOException {
		 
		 Student anStudent = studentsFromJson.get(0);
		 Student anotherStudent = studentsFromJson.get(2);
		 
		 String lastNoteAnStudent = anStudent.getAssignments().get(0).getNotes().get(1);
		 int anStudentNumericNote = Integer.parseInt(lastNoteAnStudent);
		 
		 String lastNoteAnotherStudent = anotherStudent.getAssignments().get(0).getNotes().get(1);
		 int anotherStudentNumericNote = Integer.parseInt(lastNoteAnotherStudent);
		 
		 Assert.assertEquals(anStudentNumericNote, 8);
		 Assert.assertEquals(anotherStudentNumericNote, 7);
		 Assert.assertTrue(anStudentNumericNote > anotherStudentNumericNote);
     }
	 
	 @Test
	 public void updateStudentFromJson() {
		 studentToUpdate.setFile("143-432.3");
		 studentToUpdate.setFirstName("jorge");
		 studentToUpdate.setLastName("martinez");
		 studentToUpdate.setUserGitHub("lta");
		 
		 updateStudentViewModel.updateData();
		 
		 Optional<Student> studentModifiend = RepositoryCourse.getInstance().getStudent(studentToUpdate.getFile());
		 
		 Assert.assertEquals(studentModifiend.get().getFirstName(), studentToUpdate.getFirstName());
		 Assert.assertEquals(studentModifiend.get().getLastName(), studentToUpdate.getLastName());
		 Assert.assertEquals(studentModifiend.get().getUserGitHub(), studentToUpdate.getUserGitHub());
		 Assert.assertEquals(studentModifiend.get().getFile(), studentToUpdate.getFile());
		 
	}
	 
}
