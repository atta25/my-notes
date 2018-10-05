package utils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {
    private ObjectMapper mapper;

    public JsonUtils() {
        this.mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public String getJson(Object object) {
        String jsonString;

        try {
            jsonString = this.mapper.writeValueAsString(object);
            return jsonString;
        } catch (Exception e) {
            throw new RuntimeException("Error getting the json", e);
        }
    }

    public <T> T getObject(String json, Class<T> clazz) {
        try {
            return this.mapper.readValue(json, clazz);
        } catch (Exception e) {
            throw new RuntimeException("Error getting the object", e);
        }
    }

}
