import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import model.CurrentNote;
import model.Student;

public class ReadJsonTest {

	private ObjectMapper objectMapper;
	private File fileJson;
	private List<Student> studentsFromJson = new ArrayList<Student>();
	
	
	@Before
	public void initialize() {
		objectMapper = new ObjectMapper();
		fileJson = new File("C:\\notes.json");
	}
	
	 @Test
	 public void sizeOfStudentsInTheCourse() throws JsonParseException, JsonMappingException, IOException {
		 studentsFromJson = objectMapper.readValue(fileJson,new TypeReference<List<Student>>(){});
		 Assert.assertEquals(studentsFromJson.size(), 5);
	 }
	 
	 @Test
	 public void readFromJsonAndTakeASpecificStudentName() throws JsonParseException, JsonMappingException, IOException{
	    
		studentsFromJson = objectMapper.readValue(fileJson,new TypeReference<List<Student>>(){});
	    Student anStudent = studentsFromJson.get(0);
	    Assert.assertEquals(anStudent.getFirstName(),"juan");
	    	
	 }
	 
	 @Test
	 public void whoStudentHasTheBestLastNoteInHisFirstExam() throws JsonParseException, JsonMappingException, IOException {
		 studentsFromJson = objectMapper.readValue(fileJson,new TypeReference<List<Student>>(){});
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
	 
}
