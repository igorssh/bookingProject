package lv.javaguru.java2.domain;

/**
 * Created by Aleksej_home on 2015.07.15..
 */
abstract public class Person {
    protected long id;
    protected String name;
    protected String surname;
    protected String email;
    protected String phone;

    private boolean checkEmail() {
        return true;
    }
    private boolean checkPhone() {
        return true;
    }
}
