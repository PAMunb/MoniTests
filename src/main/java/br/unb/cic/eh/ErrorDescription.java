package br.unb.cic.eh;

public class ErrorDescription {
    private ErrorType type;
    private String location;
    private String expecting;

    public ErrorDescription(ErrorType type, String location) {
        this(type, location, "unknown");
    }

    public ErrorDescription(ErrorType type, String location, String expecting) {
        this.type = type;
        this.location = location;
        this.expecting = expecting;
    }

    public ErrorType getType() {
        return type;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return type + " at " + location + " expecting " + expecting;
    }
}
