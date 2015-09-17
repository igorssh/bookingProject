package lv.javaguru.java2.core.generators.patterns;

import java.util.Set;

/**
 * Created by Aleksej_home on 2015.09.08..
 */
public interface BuilderGenerator {

     void writeCodeModel(String factroyPackage, Class clazz);

     Set<Class<? extends Object>> getDomainsObjects();

     Set<Class<? extends Object>> getCustomObjects(String path);

}
