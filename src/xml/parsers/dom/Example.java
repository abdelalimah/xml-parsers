package xml.parsers.dom;

import xml.parsers.models.Author;
import xml.parsers.models.Document;

public class Example {

    public Example(){

        DocumentParser parser = new DocumentParser("resources/documents.xml");
        Document[] docs = parser.getDocuments();
        for (int i = 0; i < docs.length; i++) {
            System.out.println("------- Document "+ docs[i].getId() +" -------");
            System.out.println("Title : "+docs[i].getTitle());
            System.out.println("Price : "+docs[i].getPrice());
            System.out.println("Title : "+docs[i].getTitle());

            System.out.println("Authors/Author : ");

            for (Author author:
                docs[i].getAuthors()) {
                System.out.println("----------------------");
                System.out.println("| Id : " +author.getId());
                System.out.println("| Name : "+author.getName());
                System.out.println("| Country : "+author.getCountry());
                System.out.println("| Year of birth : "+author.getYearOfBirth());
                System.out.println("----------------------");
            }
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        }
    }


    public static void main(String[] args) {
        new Example();
    }
}
