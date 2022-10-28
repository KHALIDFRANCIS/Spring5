package guru.springframework.spring5webapp.domain;

//import javax.annotation.Generated;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

//This is one of two POJO - Plain Ole Java Object
//This is one of the objects that we will be persisting into the database with JPA

//Making a POJO into a JPA (Java Persistence API) Entity
@Entity
public class Author {
//Persistent entity "Author" needs a primary key


    @Id   //This annotates this as the ID
    @GeneratedValue (strategy = GenerationType.AUTO)  //this tells hibernate how the Id is getting generated with the underlying database  //    kinda like how Sql automatically generates the ID for each line
    private Long id;

    private String firstName;
    private String lastName;

//    This will set up the JPA relationship - Many to Many - *_*
    @ManyToMany(mappedBy = "authors")
    private Set<Book> books = new HashSet<>();

//    Because were gonna use JPA, we need to have in a zero args constructor ||
    public Author(){

    }

    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

//    @1:05:30

    @Override
    public String toString() {      //This will display the properties of the specified object in a string format
        return "Author{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", books=" + books +
                '}';
    }

    //LOOK UP A VIDEO ON EQUALS AND HASHCODE
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Author author = (Author) o;

        return id != null ? id.equals(author.id) : author.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

//    the equals and hashcode methods will, respectively, assign an ID to each of the books and place it within a database
}

