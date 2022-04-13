package br.unb.cic.mop.eh;

import java.util.Objects;

public class ErrorSummary {
    public String spec;
    public String error;
    public String classQualifiedName;
    public String methodName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ErrorSummary summary = (ErrorSummary) o;
        return Objects.equals(spec, summary.spec) && Objects.equals(error, summary.error) && Objects.equals(classQualifiedName, summary.classQualifiedName) && Objects.equals(methodName, summary.methodName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(spec, error, classQualifiedName, methodName);
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s", spec, error, classQualifiedName, className(), methodName);
    }

    private String className() {
        if(classQualifiedName.contains("$")) {
            int idx1 = classQualifiedName.indexOf("$") + 1;
            String temp = classQualifiedName.substring(idx1);

            return temp.substring(0, temp.indexOf("."));
        }
        return classQualifiedName.substring(classQualifiedName.lastIndexOf(".")+1);
    }


}
