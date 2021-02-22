package xml.parsers.sax.reproduction;

import org.xml.sax.helpers.DefaultHandler;

import javax.swing.*;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class MenuParser {

    JMenuBar menuBar;

    public MenuParser(String source) {
        SAXParserFactory factory = SAXParserFactory.newDefaultInstance();
        try{
            SAXParser parser = factory.newSAXParser();

            MenuHandler menuHandler = new MenuHandler();

            parser.parse(source,menuHandler);

            menuBar = menuHandler.getMenuBar();

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public JMenuBar getMenuBar() {
        return menuBar;
    }
}
