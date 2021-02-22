package xml.parsers.dom;

import org.w3c.dom.*;
import xml.parsers.models.Author;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class DocumentHandler {

    private Document doc;

    public DocumentHandler(String source) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newDefaultInstance();

        try{
            DocumentBuilder builder = factory.newDocumentBuilder();
            doc = builder.parse(source);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public Element createDocumentElement(xml.parsers.models.Document document){

        Element newDocument = doc.createElement("document");

        Element title = doc.createElement("title");
        Element price = doc.createElement("price");
        Element authors = doc.createElement("authors");

        title.appendChild(doc.createTextNode(document.getTitle()));
        price.appendChild(doc.createTextNode(document.getPrice()+""));

        newDocument.setAttribute("id",document.getId()+"");
        newDocument.appendChild(title);
        newDocument.appendChild(price);

        for (Author auth:
             document.getAuthors()) {

            Element author = doc.createElement("author");
            author.setAttribute("id",auth.getId()+"");

            Element name = doc.createElement("name");
            Element country = doc.createElement("country");
            Element yearOfBirth = doc.createElement("year-born");

            name.appendChild(doc.createTextNode(auth.getName()));
            country.appendChild(doc.createTextNode(auth.getCountry()));
            yearOfBirth.appendChild(doc.createTextNode(auth.getYearOfBirth()));

            author.appendChild(name);
            author.appendChild(country);
            author.appendChild(yearOfBirth);

            authors.appendChild(author);
            newDocument.appendChild(authors);

        }

        return newDocument;

    }

    public Document getDoc() {
        return doc;
    }
}
