package xml.parsers.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;
import xml.parsers.sax.listeners.ReflectionActionListener;

import javax.swing.*;

public class MenuHandler extends DefaultHandler {

    private JMenuBar menuBar;
    private String iconsFolder;
    private JMenu menu = null;
    private JMenuItem menuItem = null;
    private String basePackage;
    private String actionClassName;

    public MenuHandler(){ }

    @Override
    public void startDocument() throws SAXException {

        System.out.println(">> Start document");

    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        /*
        * the qName is the name of the element
        * */

        switch (qName) {
            case "menu-bar" -> {

                menuBar = new JMenuBar();
                iconsFolder = attributes.getValue("icons-folder");
                System.out.println(iconsFolder);
                basePackage = attributes.getValue("base-package");

            }

            case "menu" -> {

                String menuName = attributes.getValue("name");
                menu = new JMenu(menuName);
                menuBar.add(menu);
                actionClassName = attributes.getValue("action-class");

            }
            case "item" -> {

                String itemName = attributes.getValue("name");
                String iconFileName = attributes.getValue("icon");
                ImageIcon icon = new ImageIcon(iconsFolder +"/"+ iconFileName);

                menuItem = new JMenuItem(itemName, icon);

                //extracting the full class path
                String qualifiedClassName = basePackage+"."+actionClassName;

                String methodName = attributes.getValue("action");

                menuItem.addActionListener(new ReflectionActionListener(qualifiedClassName,methodName));

                menu.add(menuItem);

            }
            case "separator" -> menu.addSeparator();
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {

        String comment = new String(ch,start,length);

        if(menuItem != null){
            menuItem.setToolTipText(comment);
        }

    }

    @Override
    public void error(SAXParseException e) throws SAXException { }

    @Override
    public void fatalError(SAXParseException e) throws SAXException { }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {

        if(qName.equals("item")){
            /*
            * null here is preventing the menuItem from being set to the empty characters between item elements
            * */
            menuItem = null;
        }

    }

    @Override
    public void endDocument() throws SAXException {

        System.out.println(">> End document");

    }

    public JMenuBar getMenuBar() {

        return menuBar;

    }
}
