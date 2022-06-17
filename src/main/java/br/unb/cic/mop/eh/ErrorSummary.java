package br.unb.cic.mop.eh;

import java.util.Objects;

//TODO private fields
public class ErrorSummary {
    public String spec;
    public String error;
    public String classQualifiedName;
    public String methodName;
    public String location;

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        ErrorSummary that = (ErrorSummary) o;
        return Objects.equals(spec, that.spec)
                && Objects.equals(error, that.error)
                && Objects.equals(classQualifiedName, that.classQualifiedName)
                && Objects.equals(methodName, that.methodName)
                && Objects.equals(location, that.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(spec, error, classQualifiedName, methodName, location);
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s,%s", spec, classQualifiedName, className(), methodName, location, error);
    }

    private String className() {
        String res = classQualifiedName;
//        if(classQualifiedName.contains("$")) {
//            int idx = classQualifiedName.indexOf("$");
//            res =  res.substring(0, idx);
//        }
        return res.substring(res.lastIndexOf(".") + 1);
    }

}
