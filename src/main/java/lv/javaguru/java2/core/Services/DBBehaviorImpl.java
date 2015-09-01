package lv.javaguru.java2.core.Services;

import lv.javaguru.java2.core.database.DBException;

import org.springframework.stereotype.Service;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.NoSuchMethodException;


/**
 * Created by Aleksej_home on 2015.08.31..
 */
@Service
public class DBBehaviorImpl implements DBBehavior {

    @Override
    public Object ignoreLazy(Object obj, String arg) throws DBException {
      try {

            Object tmp = null;
            Method met;

            met = obj.getClass().getMethod(arg);
            tmp = met.invoke(obj);

            return tmp;
        }
        catch(NoSuchMethodException e) {
            System.out.println(e.toString());
        }catch(IllegalAccessException e) {
            System.out.println(e.toString());
        }catch(InvocationTargetException e) {
            System.out.println(e.toString());
        }

       return null;
    }


}
