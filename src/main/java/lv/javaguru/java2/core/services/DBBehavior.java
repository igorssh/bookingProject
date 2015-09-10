package lv.javaguru.java2.core.services;

import lv.javaguru.java2.core.database.DBException;

//import java.lang.reflect.InvocationTargetException;

/**
 * Created by Aleksej_home on 2015.08.31..
 */
public interface DBBehavior {

    void ignoreLazy(Object obj, String[] args) throws DBException;

}
