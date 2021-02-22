package xml.parsers.sax.reproduction;

import javax.swing.*;
import java.awt.*;

public class MenuParserFrame extends JFrame {


    public MenuParserFrame() {
        super("Menu parser example");

        MenuParser menuParser = new MenuParser("resources/menu-bar.xml");

        JMenuBar menuBar = menuParser.getMenuBar();

        setJMenuBar(menuBar);

        setLocationRelativeTo(null);
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MenuParserFrame();
    }
}
