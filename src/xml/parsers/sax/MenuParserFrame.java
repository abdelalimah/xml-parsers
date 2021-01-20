package xml.parsers.sax;

import javax.swing.*;

public class MenuParserFrame extends JFrame {

    private static final long serialVersionUID = 1L;

    public MenuParserFrame(){
        MenuParser parser = new MenuParser("resources/menu-bar.xml");
        JMenuBar menu = parser.getMenuBar();
        setJMenuBar(menu);

        setSize(600,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MenuParserFrame();
    }
}
