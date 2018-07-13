import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;

import model.Course;
import model.CurrentNote;
import model.Student;
import repo.RepositoryCourse;
import ui.vm.UpdateStudentViewModel;

public class ReadJsonTest {

	private ObjectMapper objectMapper;
	private File fileJson;
	private Course courseJson;
	private List<Student> studentsFromJson = new ArrayList<Student>();
	private UpdateStudentViewModel updateStudentViewModel;
	private Student studentToUpdate;
	private Course course;
	private Set<Student> students;
	
	
	@Before
	public void initialize() throws JsonParseException, JsonMappingException, IOException {
		course = new Course();
        course.setStudents(new HashSet<>());
        RepositoryCourse.getInstance().setCourse(course);
       
		objectMapper = new ObjectMapper();
		fileJson = new File("C:\\notes.json");
		courseJson = objectMapper.readValue(fileJson,Course.class);
		students = courseJson.getStudents();

	}
	
	 @Test
	 public void sizeOfStudentsInTheCourse() throws JsonParseException, JsonMappingException, IOException {
		
		 Assert.assertEquals(students.size(), 5);
	 }
	 
	 @Test
	 public void readFromJsonAndTakeDetailsToSpecificStudent() throws JsonParseException, JsonMappingException, IOException{
	    List<Student> listStudents = Lists.newArrayList(students);
	    Student anStudent = listStudents.get(4);
	    Assert.assertEquals(anStudent.getFirstName(),"alejandra");
	    Assert.assertEquals(anStudent.getLastName(), "gomez");
	    Assert.assertEquals(anStudent.getUserGitHub(), "alejandrag");
	    Assert.assertEquals(anStudent.getFile(), "150.005-5");
	    	
	 }
	 
	 @Test
	 public void whoStudentHasTheBestLastNoteInHisFirstExam() throws JsonParseException, JsonMappingException, IOException {
		 List<Student> listStudents = Lists.newArrayList(students);
		 Student anStudent = listStudents.get(0);
		 Student anotherStudent = listStudents.get(2);
		 
		 String lastNoteAnStudent = anStudent.getAssignments().get(0).getNotes().get(1);
		 int anStudentNumericNote = Integer.parseInt(lastNoteAnStudent);
		 
		 String lastNoteAnotherStudent = anotherStudent.getAssignments().get(0).getNotes().get(1);
		 int anotherStudentNumericNote = Integer.parseInt(lastNoteAnotherStudent);
		 
		 Assert.assertEquals(anStudentNumericNote, 9);
		 Assert.assertEquals(anotherStudentNumericNote, 8);
		 Assert.assertTrue(anStudentNumericNote > anotherStudentNumericNote);
     }
	 
	 
	 
	 
}
