package xml.parsers.models;

public class Author {
    private final int id;
    private final String name;
    private final String yearOfBirth;
    private final String country;


    public Author(int id,String name , String country, String yearOfBirth){
        this.country = country;
        this.yearOfBirth = yearOfBirth;
        this.name = name;
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public String getName() {
        return name;
    }

    public String getYearOfBirth() {
        return yearOfBirth;
    }

    public int getId() {
        return id;
    }
}