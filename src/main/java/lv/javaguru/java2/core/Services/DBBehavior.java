package lv.javaguru.java2.core.Services;

import lv.javaguru.java2.core.database.DBException;

//import java.lang.reflect.InvocationTargetException;

/**
 * Created by Aleksej_home on 2015.08.31..
 */
public interface DBBehavior {

    Object ignoreLazy(Object obj, String arg) throws DBException;

}