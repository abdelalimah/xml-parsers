package xml.parsers.sax.actions;

import xml.parsers.sax.ComponentFinder;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class FileAction {

    public FileAction(){ }

    public void newFile(){

        System.out.println("New File");

    }

    public void open(){

        System.out.println("Open File");
        Component component = ComponentFinder.getComponent("menuBar");
        System.out.println(component);

    }

    public void save(){

        Component component = ComponentFinder.getComponent("editor");

        String content = ((JTextArea)component).getText();
    }

    public void saveAs(){

        System.out.println("Save File as");

    }

    public void exit(){

        System.exit(0);

    }
}
