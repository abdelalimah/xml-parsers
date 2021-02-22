package xml.parsers.sax.reproduction.listeners;

import xml.parsers.sax.reproduction.actions.FileAction;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Method;

public class ReflectionActionListener implements ActionListener {

    private Object actionObject;
    private Method method;

    public ReflectionActionListener(String qualifiedClassName , String methodName) {

        try{
            Class<?> cls = Class.forName(qualifiedClassName);

            actionObject = cls.getConstructor().newInstance();
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
