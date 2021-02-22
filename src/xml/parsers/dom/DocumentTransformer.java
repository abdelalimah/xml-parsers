package xml.parsers.dom;

import org.w3c.dom.Document;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileWriter;
import java.io.PrintWriter;

public class DocumentTransformer {

    private Transformer tansformer;

    public DocumentTransformer() {

        TransformerFactory factory = TransformerFactory.newDefaultInstance();
        try{

            tansformer = factory.newTransformer();
            tansformer.setOutputProperty(OutputKeys.INDENT, "yes");

        }catch(Exception e){
            System.out.println(e.getMessage());
        }

    }


    public void transform(Document document){
        try{

            DOMSource source = new DOMSource(document);

            FileWriter fw = new FileWriter("resources/documents.xml");

            StreamResult result = new StreamResult(fw);

            tansformer.transform(source,result);

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

}
