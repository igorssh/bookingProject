package lv.javaguru.java2.core.generators.patterns;

import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.writer.SingleStreamCodeWriter;
import javassist.compiler.ast.Expr;
import lv.javaguru.java2.core.generators.core.SpringLocalGenerator;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.Set;
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

    // Function to generate CodeModel Class
    @Override
    public void writeCodeModel(String factroyPackage, Class clazz) {
        try {

            /* Creating java code model classes */
            JCodeModel jCodeModel = new JCodeModel();

            /* Adding packages here */
           // JPackage jp = jCodeModel._package(factroyPackage);

            /* Giving Class Name to Generate */
            JDefinedClass jc = jCodeModel._class(clazz.getName() + "Builder");


            jc.annotate(Component.class);

            JClass df = jc;
            JClass paramClazz = jCodeModel.ref(clazz);


            JDocComment jDocComment = jc.javadoc();
            jDocComment.add("Generated pattern class");

         /*   Field[] fields =  clazz.getFields();
            int fsize = fields.length;
            JFieldVar[] farr = new JFieldVar[fsize];

            for (Field fl : fields ){
                 farr
            }*/

            jc.field(JMod.PRIVATE, jCodeModel.LONG, "id");
            JFieldVar  vb = jc.field(JMod.PRIVATE, String.class, "label");
            jc.field(JMod.PRIVATE, String.class, "address");
            jc.field(JMod.PRIVATE, jCodeModel.BYTE, "rating");
            jc.field(JMod.PRIVATE, String.class, "description");

            //jc.method(JMod.PRIVATE, jCodeModel.VOID, clazz.getSimpleName() + "Builder").body();
            jc.method(JMod.PRIVATE, jCodeModel.VOID, df.name()).body();

            JMethod jmCreate3 = jc.method(JMod.PUBLIC | JMod.STATIC,  df, "create" + clazz.getSimpleName());
            JBlock jBlock3 = jmCreate3.body();
            jBlock3._return(JExpr._new(df));


            JMethod jmCreate4 = jc.method(JMod.PUBLIC, clazz, "build");
            JBlock jBlock4 = jmCreate4.body();

            JVar curVarImpl = jBlock4.decl(paramClazz, clazz.getSimpleName().toLowerCase());
            curVarImpl.init(JExpr._new(paramClazz));

            String sga = clazz.getMethod("setLabel",String.class).getName();
           // clazz.getDeclaredMethod("getLabel", null);


            //foo = body.decl(cm.ref(java.util.List.class).narrow(java.lang.String.class), "foo");
          //  curVarImpl.invoke("setLabel").arg(vb);
            //curVarImpl.invoke("getLabel");
            jBlock4.directStatement(curVarImpl.name() + "." + sga + "("+ vb.name() + ");");
           // curVarImpl
           // JExpr._this();

            jBlock4._return(curVarImpl);

            JMethod jmCreate5 = jc.method(JMod.PUBLIC, df, "withLabel");
            JVar jv5 = jmCreate5.param(String.class, "label");
            JBlock jBlock5 = jmCreate5.body();
            jBlock5.assign(JExpr._this().ref("label"), jv5);
           // JExpr._this().ref(vb);
            jBlock5._return(JExpr._this());


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
