package xml.parsers.sax.reproduction.actions;

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

    }

    public void save(){

        Component component = ComponentFinder.getComponent(0);

    }

    public void saveAs(){

        System.out.println("Save File as");

    }

    public void exit(){

        System.exit(0);

    }
}
