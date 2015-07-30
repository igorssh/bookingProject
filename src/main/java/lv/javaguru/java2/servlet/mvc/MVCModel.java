package lv.javaguru.java2.servlet.mvc;

public class MVCModel {
    private Object data;
    private String jspName;

    public MVCModel(Object data, String jspName) {
        this.data = data;
        this.jspName = jspName;
    }

    public Object getData() {
        return data;
    }

    public String getJspName() {
        return jspName;
    }
}
