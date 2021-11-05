package br.unb.cic.eh;

public class ErrorDescription {
    private ErrorType type;
    private String location;

    public ErrorDescription(ErrorType type, String location) {
        this.type = type;
        this.location = location;
    }

    public ErrorType getType() {
        return type;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return type + " at " + location;
    }
}
