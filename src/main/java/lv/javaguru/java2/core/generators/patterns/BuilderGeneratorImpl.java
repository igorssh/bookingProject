package lv.javaguru.java2.core.generators.patterns;

import com.sun.codemodel.ClassType;
import com.sun.codemodel.JBlock;
import com.sun.codemodel.JClass;
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JDocComment;
import com.sun.codemodel.JExpr;
import com.sun.codemodel.JFieldVar;
import com.sun.codemodel.JInvocation;
import com.sun.codemodel.JMethod;
import com.sun.codemodel.JMod;
import com.sun.codemodel.JTryBlock;
import com.sun.codemodel.JType;
import com.sun.codemodel.JVar;
import lv.javaguru.java2.core.database.DBException;
import lv.javaguru.java2.core.generators.core.SpringLocalGenerator;


import java.io.File;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.*;
import java.lang.reflect.Field;



import lv.javaguru.java2.core.database.hibernate.GenericDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


/**
 * Created by Aleksej_home on 2015.09.05..
 */
@Component
public class BuilderGeneratorImpl extends SpringLocalGenerator implements BuilderGenerator{

    //private final String GEN_PATH = "src/main/java/lv/javaguru/java2/core/domain/patterns/generated";
    private final String GEN_PATH = "src/main/java";
    private final String PACKAGE = "lv.javaguru.java2.core.domain.patterns.generated.";
    private final String PACKAGE_HANDLE = "lv.javaguru.java2.servlet.mvc.helpers.";
   // private final String PACKAGE_HANDLE = "lv.javaguru.java2.servlet.mvc.helpers.";
    private int iterator;


    public enum Status{
        ONE, TWO;
    }

    public void BuilderGenerator(){}

    public Set<Class<? extends Object>> getDomainsObjects(){
        return  getDomains();
    }

    public  Set<Class<? extends Object>> getCustomObjects(String path){
         return getCustomClasses(path) ;
    }

    public void build(){
        Set<Class<? extends Object>> allClasses;
      //  JCodeModel generator = new JCodeModel();

       allClasses = scannPackage();
        System.out.println("[==========================================================================]\n");
        System.out.println("[==========================================================================]\n");
        System.out.println("[==========================================================================]\n");
        System.out.println("[==========================================================================]\n");
        System.out.println("[==========================================================================]\n");
     /*   for (Class<?> cl : allClasses){
            System.out.println("[= "+ cl.getName() + "=]\n");
        }
        System.out.println("[==========================================================================]\n");
        System.out.println("[==========================================================================]\n");
        System.out.println("[==========================================================================]\n");
        System.out.println("[==========================================================================]\n");
        System.out.println("[==========================================================================]\n");*/
    }

    public void buildPattern(Class cls){
       //  __GENERATOR
    }






    private JType getFullType(JCodeModel jCodeModel, Field field) {
        Type genericParameterType = field.getGenericType();
        if (genericParameterType instanceof ParameterizedType) {
            ParameterizedType aType = (ParameterizedType) genericParameterType;
            return jCodeModel.ref(field.getType().getName()).narrow(
                    jCodeModel.ref(((Class<?>) aType.getActualTypeArguments()[0]).getName())
            );
        }else{
            return jCodeModel.ref(field.getType().getName());
        }
    }


    private String upperFirstLetter(String str){
        return Character.toUpperCase(str.charAt(0)) + str.substring(1);
    }


    private Object getInvocations(Object obj, JVar[] par){
        final String delim = "\n                         ";
        for (int i = iterator; i < par.length; i++ ){
            iterator++;
            if (obj instanceof JFieldVar) {
                obj = ((JFieldVar) obj).invoke(delim +"with" + upperFirstLetter(par[i].name())).arg(par[i]);
                getInvocations(obj, par);
            }else if (obj instanceof JInvocation){
                obj = ((JInvocation) obj).invoke(delim +"with" + upperFirstLetter(par[i].name())).arg(par[i]);
                getInvocations(obj, par);
            }
        }

        return ((JInvocation) obj).invoke("build");
    }

    private <T> T getCollected( T type, JVar[] par){
         for (JVar ob : par){
            if (type instanceof JMethod){
                ((JMethod) type).param(ob.type(), ob.name());
            }else if (type instanceof JInvocation){
                ((JInvocation) type).arg(ob);
            }
        }
        return type;
    }

    // Function to generate CodeModel Class
    @Override
    public void writeCodeModel(String factroyPackage, Class clazz) {
        try {
            /**
             *  Interface doomy
             */
            JCodeModel jCodeModel = new JCodeModel();

          JDefinedClass idef = jCodeModel._class(JMod.PUBLIC, PACKAGE + clazz.getSimpleName() + "Builder", ClassType.INTERFACE);

            jCodeModel.build(new File(GEN_PATH));


             jCodeModel = new JCodeModel();
            JDefinedClass jc = jCodeModel._class(JMod.PUBLIC, PACKAGE + clazz.getSimpleName() + "Builder" + "Impl", ClassType.CLASS);
            jc._implements(idef);
            JClass df = jc;
            JClass paramClazz = jCodeModel.ref(clazz);
            JDocComment jDocComment = jc.javadoc();
            jDocComment.add("Generated pattern class for *"+ clazz.getSimpleName() +"*");
            Field[] fields =  clazz.getDeclaredFields();
            int fsize = fields.length;
            JFieldVar[] farr = new JFieldVar[fsize];
            byte it = 0;


            for (Field fl : fields ){
                farr[it] = jc.field(JMod.PRIVATE, getFullType(jCodeModel, fl), fl.getName());
                it++;
            }

            jc.method(JMod.PRIVATE, jCodeModel.VOID, df.name()).body();

            JMethod jmCreate3 = jc.method(JMod.PUBLIC | JMod.STATIC, df, "create" + clazz.getSimpleName());
            JBlock jBlock3 = jmCreate3.body();
            jBlock3._return(JExpr._new(df));


            JMethod jmCreate4 = jc.method(JMod.PUBLIC, clazz, "build");
            jmCreate4.annotate(Override.class);
            JBlock jBlock4 = jmCreate4.body();

            JVar curVarImpl = jBlock4.decl(paramClazz, clazz.getSimpleName().toLowerCase());
            curVarImpl.init(JExpr._new(paramClazz));
            String prefix = "set";
            Method[] met = clazz.getDeclaredMethods();

            for (Method fl : met){
                if (fl.getName().startsWith(prefix)) {
                    for (JFieldVar fa : farr){
                        if (fl.getName().regionMatches(true,prefix.length(),fa.name(),0, fa.name().length() ))
                    jBlock4.directStatement(curVarImpl.name() + "." + fl.getName() + "(" + fa.name() + ");");
                    }
                  //  it++;
                }
            }

            jBlock4._return(curVarImpl);

            JVar jv5;
            for (Field fl : fields){
                JMethod jmCreate5 = jc.method(JMod.PUBLIC, df, "with" + upperFirstLetter(fl.getName()));
                jmCreate5.annotate(Override.class);
                jv5 = jmCreate5.param(getFullType(jCodeModel, fl), fl.getName());

                JBlock jBlock5 = jmCreate5.body();
                jBlock5.assign(JExpr._this().ref(fl.getName()), jv5);

                jBlock5._return(JExpr._this());
            }
          //  File file = new File(GEN_PATH + "/"+  PACKAGE.replace('.','/') +"/"+ clazz.getSimpleName() + "Builder" + "Impl.java");


                jCodeModel.build(new File(GEN_PATH));

            /**
             *  Init Builder interface
             */
            jCodeModel = new JCodeModel();

            JDefinedClass intr = jCodeModel._class(JMod.PUBLIC, PACKAGE + clazz.getSimpleName() + "Builder", ClassType.INTERFACE);
            Collection<JMethod> methods = jc.methods();
            for (JMethod m : methods){
                if (m.mods().getValue() == JMod.PUBLIC ){
                   // intr.method(m.mods().getValue() ,m.type(), m.name() );
                  JMethod inf =  intr.method(JMod.NONE, m.type(), m.name());
                    for (JVar vr: m.params()){
                         inf.param(vr.type(), vr.name());
                    }
                }

            }
            jCodeModel.build(new File(GEN_PATH));


            /**
             *  Interface doomy
             */
             jCodeModel = new JCodeModel();

            JDefinedClass idef2 = jCodeModel._class(JMod.PUBLIC,  PACKAGE_HANDLE + clazz.getSimpleName() + "Factory", ClassType.INTERFACE);

          //  jCodeModel.build(new File(GEN_PATH));


            /**
             *    Init new class Factory
             */

          jCodeModel = new JCodeModel();

           JDefinedClass jc2 =  jCodeModel._class(JMod.PUBLIC, PACKAGE_HANDLE + clazz.getSimpleName() + "Factory"+ "Impl", ClassType.CLASS);
            jc2._implements(idef2);
            jc2.javadoc().add("Generated Factory pattern class for *" + clazz.getSimpleName() + "*");

            jc2.annotate(Component.class);
            JType dr = jCodeModel.ref(GenericDao.class)
                    .narrow(clazz)
                    .narrow(Long.class);
            JFieldVar fld = jc2.field(JMod.PRIVATE, dr, "genericdao");
            fld.annotate(Autowired.class);
            fld.annotate(Qualifier.class).param("value", clazz.getSimpleName() + "_DAO");
            JVar[] jvm = new JVar[farr.length];
           // jc2.field(JMod.PRIVATE, df, "defBuilder", df.staticRef(Status.ONE.name()));
            JFieldVar statv = jc2.field(JMod.PRIVATE, df, "defBuilder", df.staticRef(jmCreate3.name()+"()"));
            it = 0;
            JMethod met1 = jc2.method(JMod.PUBLIC, clazz, "create");
            met1.annotate(Override.class);
            for (Field fl : fields){
                jvm[it] = met1.param(getFullType(jCodeModel, fl), fl.getName());
                //getCollected( T type, JVar[] par)
                it++;
            }
            JBlock jb1 = met1.body();
            JMethod met2 = jc2.method(JMod.PRIVATE, jCodeModel.VOID, "validate");

            JClass fclass = jCodeModel.ref(clazz);
           // jb1.invoke(met2)
            getCollected( met2, jvm);
            getCollected(jb1.invoke(met2), jvm);
            // build
            JMethod met3 = jc2.method(JMod.PRIVATE, clazz, "build");

            getCollected(met3, jvm);
            JVar st1 = jb1.decl(fclass, clazz.getSimpleName().toLowerCase())
                    .init(getCollected(JExpr.invoke(met3), jvm));

            JMethod met4 = jc2.method(JMod.PRIVATE, jCodeModel.VOID, "persist");

            met4.param(clazz, clazz.getSimpleName().toLowerCase());
           // JVar parg = fclass;
            jb1.invoke(met4).arg(st1);

            jb1._return(st1);

            JBlock perb = met4.body();
            JTryBlock tryi = perb._try();
            tryi.body().invoke(fld, "create").arg(st1);
            tryi._catch(jCodeModel.ref(DBException.class)).body().invoke(JExpr.direct("_x"),
                    "printStackTrace");

            JBlock bBlock = met3.body();

            iterator = 0;
             bBlock._return((JInvocation) getInvocations(statv, jvm));

          //  File file2 = new File(GEN_PATH + "/"+  PACKAGE_HANDLE.replace('.','/') +"/"+ clazz.getSimpleName() + "Factory"+ "Impl.java");


                jCodeModel.build(new File(GEN_PATH));


            /**
             *  Init Factory Interface
             */
            jCodeModel = new JCodeModel();

            JDefinedClass intr2 = jCodeModel._class(JMod.PUBLIC,  PACKAGE_HANDLE + clazz.getSimpleName() + "Factory", ClassType.INTERFACE);
            Collection<JMethod> methods2 = jc2.methods();
            for (JMethod m : methods2){
                if (m.mods().getValue() == JMod.PUBLIC ){
                  //  intr2.method(m.mods().getValue() ,m.type(), m.name() );
                    JMethod inf2 =  intr2.method(JMod.NONE, m.type(), m.name());
                    for (JVar vr: m.params()){
                        inf2.param(vr.type(), vr.name());
                    }
                }

            }
            jCodeModel.build(new File(GEN_PATH));

        }  catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
