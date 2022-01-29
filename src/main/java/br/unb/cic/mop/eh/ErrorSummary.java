package br.unb.cic.mop.eh;

import java.util.Objects;

public class ErrorSummary {
    public String spec;
    public String error;
    public String className;
    public String methodName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ErrorSummary summary = (ErrorSummary) o;
        return Objects.equals(spec, summary.spec) && Objects.equals(error, summary.error) && Objects.equals(className, summary.className) && Objects.equals(methodName, summary.methodName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(spec, error, className, methodName);
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s", spec, error, className, methodName);
    }


}
