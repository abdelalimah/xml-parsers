package xml.parsers.sax;

import java.awt.*;

public class ComponentFinder {

    private static Container container;

    public static void setContainer(Container c){
        container = c;
    }

    public static Component getComponent(int index){

        return container.getComponent(index);

    }



}
