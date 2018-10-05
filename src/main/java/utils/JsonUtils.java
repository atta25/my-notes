package utils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {
    private ObjectMapper mapper;

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
