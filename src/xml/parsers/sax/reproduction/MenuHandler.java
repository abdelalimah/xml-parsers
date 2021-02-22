package xml.parsers.sax.reproduction;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;
import xml.parsers.sax.reproduction.listeners.ReflectionActionListener;

import javax.swing.*;

public class MenuHandler extends DefaultHandler {

    private JMenuBar menuBar;
    private JMenu menu = null;
    private JMenuItem menuItem = null;
    private String iconsFolder;
    private String basePackage;
    private String actionClassName;

    public MenuHandler() {
        super();
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println(">> document start");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println(">> end of document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        switch (qName) {

            case "menu-bar" -> {
                menuBar = new JMenuBar();
                iconsFolder = attributes.getValue("icons-folder");
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

                Icon icon = new ImageIcon(iconsFolder +"/"+ iconFileName);

                menuItem = new JMenuItem(itemName,icon);

                String qualifiedClassName = basePackage + "." + actionClassName;

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
    public void endElement(String uri, String localName, String qName) throws SAXException {
            if("item".equals(qName)){
                menuItem = null;
            }
    }

    @Override
    public void error(SAXParseException e) throws SAXException {
        super.error(e);
    }

    @Override
    public void fatalError(SAXParseException e) throws SAXException {
        super.fatalError(e);
    }

    public JMenuBar getMenuBar() {
        return menuBar;
    }
}
