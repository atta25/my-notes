package enums;

public enum Status {
    APROBO("Aprobado"),
    NO_APROBO("No aprobado");

    private final String description;

    Status(String description) {
        this.description = description;
    }
}
