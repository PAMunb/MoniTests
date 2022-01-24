package br.unb.cic.mop.eh;

public class ErrorDescription {
    private ErrorType type;
    private String spec;
    private String location;
    private String expecting;

    public ErrorDescription(ErrorType type, String spec, String location) {
        this(type, spec, location, "unknown");
    }

    public ErrorDescription(ErrorType type, String spec, String location, String expecting) {
        this.type = type;
        this.spec = spec;
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
        return "[" + spec + "]" + " " + type + " at " + location + " expecting " + expecting;
    }
}
