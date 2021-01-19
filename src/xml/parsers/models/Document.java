package xml.parsers.models;

public class Document {
    private final int id;
    private final String title;
    private final double price;
    private final Author[] authors;

    public Document(int id,String title,double price, Author[] authors){
        this.authors = authors;
        this.price = price;
        this.title = title;
        this.id = id;
    }


    public Author[] getAuthors() {
        return authors;
    }

    public double getPrice() {
        return price;
    }

    public String getTitle() {
        return title;
    }

    public int getId() {
        return id;
    }
}