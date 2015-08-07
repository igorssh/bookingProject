package lv.javaguru.java2.domain.frontend;

import java.util.List;

public class ExtrasObject {
    private List<Extra> extras;
    private Extra extra;

    public ExtrasObject() {
    }

    public ExtrasObject(List<Extra> extras, Extra extra) {
        this.extras = extras;
        this.extra = extra;
    }

    public List<Extra> getExtras() {
        return extras;
    }

    public void setExtras(List<Extra> extras) {
        this.extras = extras;
    }

    public Extra getExtra() {
        return extra;
    }

    public void setExtra(Extra extra) {
        this.extra = extra;
    }
}
