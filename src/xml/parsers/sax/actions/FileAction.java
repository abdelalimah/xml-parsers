package xml.parsers.sax.actions;

public class FileAction {

    public FileAction(){ }

    public void newFile(){

        System.out.println("New File");

    }

    public void open(){

        System.out.println("Open File");

    }

    public void save(){

        System.out.println("Save File");

    }

    public void saveAs(){

        System.out.println("Save File as");

    }

    public void exit(){

        System.exit(0);

    }
}
