package xml.parsers.sax;

import java.awt.*;

public class ComponentFinder {

    private static Container container;

    public static void setContainer(Container c){
        container = c;
    }

    public static Component getComponent(String name){
        for (Component c:
             container.getComponents()) {
            System.out.println(c);
            if(name.equals(c.getName())) {
                return c;
            };
        }
        return null;
    }

}
