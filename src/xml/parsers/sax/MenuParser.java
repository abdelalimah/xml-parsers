package xml.parsers.sax;

import javax.swing.*;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class MenuParser {
    private JMenuBar menuBar;

    public MenuParser(String source){
        SAXParserFactory factory = SAXParserFactory.newDefaultInstance();
        /*
        * if our parser was following some validation rules like dtd or xsd we would have called the following method and set it to true
        * factory.setValidating();
        * */

        try{
            SAXParser parser = factory.newSAXParser();
            MenuHandler handler = new MenuHandler();
            parser.parse(source,handler);
            menuBar = handler.getMenuBar();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public JMenuBar getMenuBar() {
        return menuBar;
    }
}
