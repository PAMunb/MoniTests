package br.unb.cic.mop.eh;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public String getSpec() {
        return spec;
    }

    public ErrorType getType() {
        return type;
    }

    public String getLocation() {
        return location;
    }

    public ErrorSummary getErrorSummary() {
        ErrorSummary s = new ErrorSummary();
        s.spec = spec;
        s.error = type.toString();

        Pattern pattern = Pattern.compile("([\\w+\\.\\$]+)[.](\\<?\\w+\\>?)\\((.+)\\)");
        Matcher matcher = pattern.matcher(location);

        s.classQualifiedName = location;
        s.methodName = location;
        s.location = location;

        if(matcher.matches()) {
            s.classQualifiedName = matcher.group(1);
            s.methodName = matcher.group(2);
            s.location = matcher.group(3);
        }
        return s;
    }

    @Override
    public String toString() {
        return "[" + spec + "]" + " " + type + " at " + location + " expecting " + expecting;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ErrorDescription that = (ErrorDescription) o;
        return getErrorSummary().equals(that.getErrorSummary());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getErrorSummary().hashCode());
    }
}
