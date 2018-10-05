package enums;

public enum Status {
    APROBADO("Aprobado"),
    DESAPROBADO("Desaprobado");

    private final String description;

    Status(String description) {
        this.description = description;
    }
}
