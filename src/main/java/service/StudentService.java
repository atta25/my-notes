package service;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;

public class StudentService {
    private Client client;
    private static final String SERVICE_NOTES = "http://notitas.herokuapp.com";
    private static final String RESOURCE = "student";
    private static final String PATH_ASSIGNMENTS = RESOURCE + "/assignments";

    public StudentService() {
        this.client = Client.create();
    }

    public ClientResponse getStudentData(String token) {
        return this.getData(RESOURCE, token);
    }

    public ClientResponse getAssignmentsData(String token) {
        return this.getData(PATH_ASSIGNMENTS, token);
    }

    public ClientResponse getData(String path, String token) {
        ClientResponse response = this.client.resource(SERVICE_NOTES)
                                    .path(path)
                                    .header("Authorization", "Bearer " + token)
                                    .get(ClientResponse.class);

        return response;
    }

    public ClientResponse updateResponse(String token, String data) {
        ClientResponse response = this.client.resource(SERVICE_NOTES)
                                    .path(RESOURCE)
                                    .header("Authorization", "Bearer " + token)
                                    .put(ClientResponse.class, data);

        return response;
    }

}
