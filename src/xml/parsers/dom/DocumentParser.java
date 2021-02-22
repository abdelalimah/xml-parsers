package xml.parsers.dom;

import org.w3c.dom.Element;
import xml.parsers.models.Author;
import xml.parsers.models.Document;

import java.util.Vector;

/*
 * The documentParser class is responsible of handling all operations to be performed on a specific xml **document**
 * */
public class DocumentParser {

    private final Vector<Document> documents;

    public DocumentParser(String source) {
        documents = new Vector<>();

        DocumentHandler documentHandler = new DocumentHandler(source);
        Element abdel = documentHandler.createDocumentElement(
                new Document(200, "blah", 20.10, new Author[]{new Author(1, "Abdelali", "Morocco", "2000")})
        );

        Element ihsane = documentHandler.createDocumentElement(
                new Document(129, "blah", 0.4, new Author[]{new Author(1, "Ihsane", "Brazil", "2001")})
        );

        Element featuring = documentHandler.createDocumentElement(
                new Document(129, "blah", 0.4, new Author[]{new Author(1, "Ihsane", "Brazil", "2001"), new Author(1, "Ihsane", "Brazil", "2001")})
        );

        XMLNode root = new XMLNode(documentHandler);

        root.appendChild(abdel);
        root.appendChild(ihsane);
        root.appendChild(featuring);

        DocumentTransformer documentTransformer = new DocumentTransformer();
        documentTransformer.transform(documentHandler.getDoc());

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


    public Document[] getDocuments() {
        Document[] t = new Document[documents.size()];
        return documents.toArray(t);
    }
}
