package useful;

import com.fasterxml.jackson.databind.ObjectMapper;
import exception.FileUploadException;
import model.Course;
import java.io.File;
import java.io.IOException;

public class JsonReaderFile {
    private ObjectMapper objectMapper;
    private static JsonReaderFile instance = new JsonReaderFile();
    public static JsonReaderFile getInstance() { return instance; }

    public JsonReaderFile() {
        objectMapper = new ObjectMapper();
    }

    public Course getCourse() {
        try {
            return objectMapper.readValue(new File("notes.json"), Course.class);
        } catch (IOException e) {
            throw new FileUploadException("Error loading file");
        }
    }
}

