package xml.parsers.sax.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Method;

public class ReflectionActionListener implements ActionListener {

    private Object actionObject;
    private Method method;

    public ReflectionActionListener(String className , String methodName){
        try{

            Class<?> cls = Class.forName(className);
            actionObject = cls.getDeclaredConstructor().newInstance();
            method = cls.getDeclaredMethod(methodName);

        }catch(Exception e){

            System.out.println(e.getMessage());

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{

            method.invoke(actionObject);

        }catch(Exception exp){

            System.out.println(exp.getMessage());

        }
    }
}
