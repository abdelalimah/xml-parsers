package xml.parsers.sax;

import javax.swing.*;
import java.awt.*;

public class MenuParserFrame extends JFrame {

    private static final long serialVersionUID = 1L;

    public MenuParserFrame(){

        MenuParser parser = new MenuParser("resources/menu-bar.xml");
        JMenuBar menu = parser.getMenuBar();
        setJMenuBar(menu);

        JTextArea textArea  = new JTextArea();
        textArea.setBackground(Color.white);

        JTextArea textArea2  = new JTextArea();
        textArea2.setBackground(Color.blue);

        textArea.setName("editor");
        textArea2.setName("editor2");

        this.getContentPane().setLayout(new GridLayout(3,3));

        setContentPane(this.getContentPane());

        this.add(textArea);
        this.add(textArea2);

        ComponentFinder.setContainer(this.getJMenuBar());

        setSize(600,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }

    public static void main(String[] args) {
        new MenuParserFrame();
    }
}
