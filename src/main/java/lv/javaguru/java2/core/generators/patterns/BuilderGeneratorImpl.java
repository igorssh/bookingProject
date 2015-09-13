package lv.javaguru.java2.core.generators.patterns;

import com.google.common.reflect.TypeResolver;
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.writer.SingleStreamCodeWriter;
import javassist.compiler.ast.Expr;
import lv.javaguru.java2.core.generators.core.SpringLocalGenerator;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.*;
import java.lang.reflect.Field;


/*import com.sun.codemodel.JAnnotationUse;
import com.sun.codemodel.JBlock;
import com.sun.codemodel.JClass;
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JDocComment;
import com.sun.codemodel.JExpr;
import com.sun.codemodel.JMethod;
import com.sun.codemodel.JMod;
import com.sun.codemodel.JPackage;
import com.sun.codemodel.JType;
import com.sun.codemodel.JVar;*/

import com.sun.codemodel.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;

/**
 * Created by Aleksej_home on 2015.09.05..
 */
@Component
public class BuilderGeneratorImpl extends SpringLocalGenerator implements BuilderGenerator{


    public void BuilderGenerator(){}

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

    // Method to get JType based on any String Value
    public JType getTypeDetailsForCodeModel(JCodeModel jCodeModel, String type) {
        if (type.equals("Unsigned32")) {
            return jCodeModel.LONG;
        } else if (type.equals("Unsigned64")) {
            return jCodeModel.LONG;
        } else if (type.equals("Integer32")) {
            return jCodeModel.INT;
        } else if (type.equals("Integer64")) {
            return jCodeModel.LONG;
        } else if (type.equals("Enumerated")) {
            return jCodeModel.INT;
        } else if (type.equals("Float32")) {
            return jCodeModel.FLOAT;
        } else if (type.equals("Float64")) {

            return jCodeModel.DOUBLE;
        } else {
            return null;
        }
    }

    private JType getInterpreter(JCodeModel jCodeModel, String type){
        if (type.equals("long")) {
            return jCodeModel.LONG;
        } else if (type.equals("int")) {
            return jCodeModel.INT;
        } else if (type.equals("byte")) {
            return jCodeModel.BYTE;
        } else if (type.equals("boolean")) {
            return jCodeModel.BOOLEAN;
        } else if (type.equals("short")) {
            return jCodeModel.SHORT;
        } else if (type.equals("float")) {
            return jCodeModel.FLOAT;
        } else if (type.equals("double")) {
            return jCodeModel.DOUBLE;
        } else if (type.equals("char")) {
            return jCodeModel.CHAR;
        } else {
            return null;
        }

       // return null;
    }

    private Class getClassInterpreter(Type type){
       /* if (type.getTypeName().startsWith("java")) {
            return jCodeModel.LONG;
        } else if (type.equals("int")) {
            return jCodeModel.INT;
        } else if (type.equals("byte")) {
            return jCodeModel.BYTE;
        } else if (type.equals("boolean")) {
            return jCodeModel.BOOLEAN;
        } else if (type.equals("short")) {
            return jCodeModel.SHORT;
        } else if (type.equals("float")) {
            return jCodeModel.FLOAT;
        } else if (type.equals("double")) {
            return jCodeModel.DOUBLE;
        } else if (type.equals("char")) {
            return jCodeModel.CHAR;
        } else {
            return null;
        }*/
       // type
        return null;
    }

    private Class<?> getParametrizedType2(Method method) {

        Type[] genericParameterTypes = method.getGenericParameterTypes();

        for (Type genericParameterType : genericParameterTypes) {
            if (genericParameterType instanceof ParameterizedType) {
                ParameterizedType aType = (ParameterizedType) genericParameterType;
                Type[] parameterArgTypes = aType.getActualTypeArguments();
                for (Type parameterArgType : parameterArgTypes) {
                    Class parameterArgClass = (Class) parameterArgType;
                    System.out.println("parameterArgClass = " + parameterArgClass);
                }
            }

        }
        return null;
    }
  /*  private class<T> getClassOfT() {
        final ParameterizedType type = (ParameterizedType) this.getClass()
                .getGenericSuperclass();
        Class<T> clazz = (Class<T>) type.getActualTypeArguments()[0];
        return clazz;
    }*/
/*
    protected Class<T> getClazz() {

        final ParameterizedType type = (ParameterizedType) this.getClass()
                .getGenericSuperclass();
        Class<T> clazz = (Class<T>) type.getActualTypeArguments()[0];
        return clazz;
    }
*/
    private  <T> Class getReflectionType(Class<T> clazz, int arg){
        Type type = clazz.getGenericSuperclass();
        if (type instanceof ParameterizedType){
            type = ((Class<?>) ((ParameterizedType) type).getRawType()).getGenericSuperclass();
        }else{
            type = ((Class<?>) type).getGenericSuperclass();
        }
        return (Class<T>) ((ParameterizedType) type).getActualTypeArguments()[arg];
    }


    private Class<?> getParametrizedType3(Type type) {



            if (type instanceof ParameterizedType) {
                ParameterizedType aType = (ParameterizedType) type;
                Type[] parameterArgTypes = aType.getActualTypeArguments();
              /*  for (Type parameterArgType : parameterArgTypes) {
                    Class parameterArgClass = (Class) parameterArgType;
                    System.out.println("parameterArgClass = " + parameterArgClass);
                }*/
              /*  Class<T> persistentClass = (Class<T>)
                        ((ParameterizedType)getClass().getGenericSuperclass())
                                .getActualTypeArguments()[0];*/
              //  Class<T> per = (Class<T>)((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
                return type.getClass();
            }

        return type.getClass();
    }
/*
    private Class<T> getParametrizedType(Class<T> cls){
        //Class<T> tm;
        T c = ((ParameterizedType) cls.getGenericSuperclass()).getActualTypeArguments()[0];
       //  tm = (Class<T>)((ParameterizedType) cls.getGenericSuperclass()).getActualTypeArguments()[0];
          // cls =   (T)((ParameterizedType) cls.getGenericSuperclass()).getActualTypeArguments()[0];
        return (Collection<c>)((ParameterizedType) cls.getGenericSuperclass()).getActualTypeArguments()[0];
       // return cls;
    }
*/
    private Class<?> typeValidator(Field metr){
       if (metr.getType().isAssignableFrom(List.class)){
           return metr.getType();
       }else{
           return metr.getType();
       }

    }

    private String upperFirstLetter(String str){
        return Character.toUpperCase(str.charAt(0)) + str.substring(1);
    }

    // Function to generate CodeModel Class
    @Override
    public void writeCodeModel(String factroyPackage, Class clazz) {
        try {

            /* Creating java code model classes */
            JCodeModel jCodeModel = new JCodeModel();

            /* Adding packages here */
           // JPackage jp = jCodeModel._package(factroyPackage);

            /* Giving Class Name to Generate */
            JDefinedClass jc = jCodeModel._class(clazz.getCanonicalName() + "Builder");


            jc.annotate(Component.class);

            JClass df = jc;
            JClass paramClazz = jCodeModel.ref(clazz);


            JDocComment jDocComment = jc.javadoc();
            jDocComment.add("Generated pattern class for *"+ clazz.getSimpleName() +"*");

            Field[] fields =  clazz.getDeclaredFields();
            int fsize = fields.length;
            JFieldVar[] farr = new JFieldVar[fsize];
           // JFieldVar
            JType tp;
            byte it = 0;
          //  Type[] ints = clazz
           // Class<?> = fields[0].getGenericType()

          //  JMethod jmCreate3 = jc.method(JMod.PUBLIC | JMod.STATIC,  df, "create" + clazz.getSimpleName());
          //  JBlock jBlock3 = jmCreate3.body();
          //  jBlock3.directStatement("sasuk();");
         //   for (Field fl : fields ){
               // jBlock3.directStatement("FLGenericType." + fl.getGenericType().getTypeName());
               // jBlock3.directStatement("FLGenericType." + fl.getGenericType().getTypeName());
               // jBlock3.directStatement("FLname." + fl.getName());
               /* if (fl.getGenericType() instanceof List<?>){
                    jBlock3.directStatement("If.yes()");

                }else{
                    jBlock3.directStatement("If.no()");
                }*/
              //  fl.getGenericType().getClass();
              /* if (fl.getGenericType().equals(List.class.)){
                    jBlock3.directStatement("If.yes()");

                }else{
                    jBlock3.directStatement("If.no()");
                }*/
               // jBlock3.directStatement("Fsize." + fsize);  java.util.List
             //   it++;
          //  }
           // jBlock3.directStatement("CL." + clazz.getDeclaredFields()[0].getName());
          //  JType tv = jCodeModel;

         //   jBlock3._return(JExpr._new(df));
            for (Field fl : fields ){
              /*  if (!fl.getGenericType().getTypeName().startsWith("java") ) {
                    farr[it] = jc.field(JMod.PRIVATE,  getInterpreter(jCodeModel, fl.getGenericType().getTypeName()), fl.getName());
                }else {
                    farr[it] = jc.field(JMod.PRIVATE, fl.getType(), fl.getName());
                }*/
                farr[it] = jc.field(JMod.PRIVATE, getReflectionType(fl.getType(), 0), fl.getName());
                
               /*  tp = getTypeDetailsForCodeModel(jCodeModel, fl.getGenericType().getTypeName());
                if (tp != null)
                 farr[it] =  jc.field(JMod.PRIVATE, tp, fl.getName());  getReflectionType(Class<T> clazz, int arg)
                else
                    farr[it] =  jc.field(JMod.PRIVATE, Class.forName( fl.getGenericType().getTypeName()), fl.getName());
*/            //  jc.direct(fl.getGenericType().getTypeName());
               // System.out.println("========================================================================\n");
               // System.out.println(fl.getGenericType().getTypeName() + "\n");
               // System.out.println("========================================================================\n");
                it++;
            }

          /*  jc.field(JMod.PRIVATE, jCodeModel.LONG, "id");
            JFieldVar  vb = jc.field(JMod.PRIVATE, String.class, "label");
            jc.field(JMod.PRIVATE, String.class, "address");
            jc.field(JMod.PRIVATE, jCodeModel.BYTE, "rating");
            jc.field(JMod.PRIVATE, String.class, "description");*/

            //jc.method(JMod.PRIVATE, jCodeModel.VOID, clazz.getSimpleName() + "Builder").body();
            jc.method(JMod.PRIVATE, jCodeModel.VOID, df.name()).body();

            JMethod jmCreate3 = jc.method(JMod.PUBLIC | JMod.STATIC,  df, "create" + clazz.getSimpleName());
            JBlock jBlock3 = jmCreate3.body();
            jBlock3._return(JExpr._new(df));


            JMethod jmCreate4 = jc.method(JMod.PUBLIC, clazz, "build");
            JBlock jBlock4 = jmCreate4.body();

            JVar curVarImpl = jBlock4.decl(paramClazz, clazz.getSimpleName().toLowerCase());
            curVarImpl.init(JExpr._new(paramClazz));
            String prefix = "set";
            Method[] met = clazz.getDeclaredMethods();
           // String sga = clazz.getMethod("setLabel",String.class).getName();
          //  JMethod[] jmet = new JMethod[met.length];
          //  jBlock4.directStatement(curVarImpl.name() + "." + sga + "("+ vb.name() + ");"); farr[it].name()
            it = 0;
           // for (JFieldVar fl : farr){
            for (Method fl : met){
                if (fl.getName().startsWith(prefix)) {
                    for (JFieldVar fa : farr){
                        if (fl.getName().regionMatches(true,prefix.length(),fa.name(),0, fa.name().length() ))
                    jBlock4.directStatement(curVarImpl.name() + "." + fl.getName() + "(" + fa.name() + ");");
                }
                    it++;
                }
            }

            jBlock4._return(curVarImpl);

            it = 0;
           // char ch;

            JVar jv5;
            for (JFieldVar fl : farr){
                JMethod jmCreate5 = jc.method(JMod.PUBLIC, df, "with" +  upperFirstLetter(fields[it].getName()));
                if (!fields[it].getGenericType().getTypeName().startsWith("java") ) {
                    jv5 = jmCreate5.param(getInterpreter(jCodeModel, fields[it].getGenericType().getTypeName()),
                            fields[it].getName());
                }else {
                    jv5 = jmCreate5.param(fields[it].getType(), fields[it].getName());
                }
                JBlock jBlock5 = jmCreate5.body();
                jBlock5.assign(JExpr._this().ref(fields[it].getName()), jv5);
                // JExpr._this().ref(vb);
                jBlock5._return(JExpr._this());
                it++;
            }



           // ByteArrayOutputStream out = new ByteArrayOutputStream();
           // jCodeModel.build(new SingleStreamCodeWriter(out));

           // jCodeModel.build(new File("lv/javaguru/java2/core/domain/patterns/generated"));
            //final File file=new File("./src/test/java");
            jCodeModel.build(new File("G:\\projects\\alex_stat\\Idea_git_clone\\bookingProject\\src\\main\\java\\lv\\javaguru\\java2\\core\\domain\\patterns"));


        }  catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
