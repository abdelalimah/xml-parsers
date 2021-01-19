package xml.parsers.dom;

import org.w3c.dom.NodeList;
import xml.parsers.models.Author;
import xml.parsers.models.Document;

import java.util.Vector;

/*
* The documentParser class is responsible of handling all operations to be performed on a specific xml **document**
* */
public class DocumentParser {

    private final Vector<Document> documents;

    public DocumentParser(String source){
        documents = new Vector<>();
        XMLNode root = new XMLNode(source);
        XMLNode[] docs = root.extractChildren();
        for (XMLNode doc : docs) {

            Vector<Author> authorsGroup = new Vector<>();

            int id = doc.extractIntAttribute("id");
            String title = doc.extractChild("title").textValue();
            double price = doc.extractChild("price").doubleValue();

            XMLNode[] authors = doc.extractChild("authors").extractChildren();

            for (XMLNode author :
                    authors) {
                int AuthorId = author.extractIntAttribute("id");
                String name = author.extractChild("name").textValue();
                String country = author.extractChild("country").textValue();
                String yearOfBirth = author.extractChild("year-born").textValue();
                authorsGroup.add(new Author(AuthorId, name, country, yearOfBirth));
            }

            Author[] authorsArray = new Author[authorsGroup.size()];
            authorsGroup.toArray(authorsArray);

            documents.add(new Document(id, title, price, authorsArray));
        }
    }

    public Document[] getDocuments(){
        Document[] t = new Document[documents.size()];
        return documents.toArray(t);
    }
}
