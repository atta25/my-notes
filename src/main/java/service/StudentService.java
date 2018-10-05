package service;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import exception.ClientResponseException;

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
        ClientResponse response = this.client
                                    .resource(SERVICE_NOTES)
                                    .path(path)
                                    .header("Authorization", "Bearer " + token)
                                    .get(ClientResponse.class);

        if (response.getStatus() == 200) {
            return response;
        }

        if (response.getStatus() == 401) {
            throw new ClientResponseException("Token inexistente, usted no está autorizado para ingresar en el sistema.");
        } else {
            throw new ClientResponseException("Error inexistente, pruebe con otro token o aguarde unos minutos");
        }
    }

    public String updateResponse(String token, String data) {
        ClientResponse response = this.client
                                    .resource(SERVICE_NOTES)
                                    .path(RESOURCE)
                                    .header("Authorization", "Bearer " + token)
                                    .put(ClientResponse.class, data);

        if (response.getStatus() == 201) {
            return "Los datos del estudiante han sido modificados.";
        }

        if (response.getStatus() == 202) {
            return "La modificación aún no ha sido completada, puede o no ser realizada eventualmente.";
        } else {
            throw new ClientResponseException("Los datos del estudiante no han sido modificados.");
        }
    }

}
