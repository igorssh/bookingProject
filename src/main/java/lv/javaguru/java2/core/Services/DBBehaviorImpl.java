package lv.javaguru.java2.core.Services;

import lv.javaguru.java2.core.database.DBException;

import org.hibernate.Hibernate;
import org.hibernate.proxy.HibernateProxy;
import org.springframework.stereotype.Service;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.NoSuchMethodException;
import java.util.List;


/**
 * Created by Aleksej_home on 2015.08.31..
 */
@Service
public class DBBehaviorImpl implements DBBehavior {


    private int iterator;

    @Override
    public void ignoreLazy(Object obj, String[] args) throws DBException {

        if (args != null)
            for (String str : args){
                String[] rgs = str.split("\\.");
                iterator = 0;
                localStack(obj, rgs);
            }
    }

    private void localStack(Object obj, String[] args){
        if (iterator < args.length){
                if (!(obj instanceof List<?>)) {
                    localStack(init(obj, args[iterator++]), args);
                }else {
                    for (Object o : (List) obj) {
                        localStack(init(o, args[iterator++]), args);
                    }
                }
        }else{
            --iterator;
        }
    }

    private <T> T init(T obj, String arg){
        try {
            Object tmp = null;
            Method met;

            met = obj.getClass().getMethod(arg);
            tmp = met.invoke(obj);
            Hibernate.initialize(tmp);
          /*  if (obj instanceof HibernateProxy) {
                obj = (T) ((HibernateProxy) obj).getHibernateLazyInitializer()
                        .getImplementation();
            }*/
            return obj;
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


   /* private static <T> T initializeAndUnproxy(T entity) {
        if (entity == null) {
            throw new
                    NullPointerException("Entity passed for initialization is null");
        }

        Hibernate.initialize(entity);
        if (entity instanceof HibernateProxy) {
            entity = (T) ((HibernateProxy) entity).getHibernateLazyInitializer()
                    .getImplementation();
        }
        return entity;
    }*/


}
