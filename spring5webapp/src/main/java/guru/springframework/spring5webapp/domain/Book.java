package guru.springframework.spring5webapp.domain;

import javax.persistence.* ;
import java.util.HashSet;
import java.util.Set;

//This is one of two POJO - Plain Ole Java Object
//This is one of the objects that we will be persisting into the database with JPA

@Entity
public class Book {

@Id
@GeneratedValue (strategy = GenerationType.AUTO) //this tells how the Ids will be generated which, in this case, will be automatically
    private Long Id;

    private String title;
    private String isbn;

//    annotate the relationship of any variable that is of another class,
    @ManyToOne              //in this case it is the publisher variable
    private Publisher publisher;



    @ManyToMany
    @JoinTable(name = "author_book",                        //this will join the authors and books tables
            joinColumns = @JoinColumn(name = "book_id"),
     inverseJoinColumns = @JoinColumn(name = "author_id"))

//    this is setting up the properties withing the join tables
    private Set<Author> authors = new HashSet<>();

//    public Book() {
//    }


    public Book(String title, String isbn) {
        this.title = title;
        this.isbn = isbn;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return "Book{" +
                "Id=" + Id +
                ", title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        return Id != null ? Id.equals(book.Id) : book.Id == null;
    }

    @Override
    public int hashCode() {
        return Id != null ? Id.hashCode() : 0;
    }
}