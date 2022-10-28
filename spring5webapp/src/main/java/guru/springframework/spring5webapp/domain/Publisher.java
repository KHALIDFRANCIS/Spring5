package guru.springframework.spring5webapp.domain;

import javax.annotation.Generated;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

//01:22:10
//In this class we will be completing an assignment, required specs at the bottom

@Entity
public class Publisher {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    //^^^^this tells Hibernate how this is being persisted and that the ID generation will come from the database
    private Long id;

    private String name;
    private String address;
    private String city;
    private String state;
    private String zip;
//@01:29:45
    //    annotate the relationship of any variable that is of another class,

//    annotating the property of the books set
    @OneToMany // //in this case it is the Books set
    @JoinColumn(name = "publisher_id") //this adds a publisher id to the book to track the publishers which creates a foreign key relationship
    private Set<Book> books = new HashSet<>();

//    this initializes the Set of Books - kinda like Scanner scan = new Scanner
//    if you dont initialize this, you get a NullPointerException

//thus will set up the mapping between the publisher and the book => one to many
//and will configure "publisher" to have a "set" of "books"

    public Publisher() {
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public Publisher(String name, String address, String city, String state, String zip) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    //Fields to included in the toString - Everything
    @Override
    public String toString() {
        return "Publisher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                '}';
    }

    //    IntelliJ default
//   Fields to be included in equals() - Long id only
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Publisher publisher = (Publisher) o;

        return id != null ? id.equals(publisher.id) : publisher.id == null;
    }

//Fields to be included in hashCode() - Long id only
    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
//    Select all non-null fields - none



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }





    //setup id property

//override
// equals,
// hashcode,
// toString

// add repository


//create publisher in bootstrap class & verify output

}



//create pojo for publisher.....line 12......check
//annotate publisher as entity.....line 11.......check
//setup id property.....line 14-16.....check
//overide
// equals, hashcode,.....line 28-41.....check
// toString....line 30-39.....check
//    (constructors & getters and setters).....line 25-74.....check
//add repository.....Publirepo.java.....check
//create publisher in bootstrap and verify
