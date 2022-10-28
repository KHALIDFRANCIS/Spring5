package guru.springframework.spring5webapp.bootstrap;


import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepo;
import guru.springframework.spring5webapp.repositories.BookRepo;
import guru.springframework.spring5webapp.repositories.PubliRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepo authorRepo;
    private final BookRepo bookRepo;
    private final PubliRepo publiRepo;


    public BootStrapData(AuthorRepo authorRepo, BookRepo bookRepo, PubliRepo publiRepo) {
        this.authorRepo = authorRepo;
        this.bookRepo = bookRepo;
        this.publiRepo = publiRepo;
    }

    @Override
    public void run(String... args) throws Exception {

        //Scanner Scan = new Scanner
        Publisher publisher = new Publisher();      //instantiates a new publisher class
        Publisher asobo = new Publisher("asobo", "9617 Avenue L", "Brooklyn", "New York", "11225");  //creates a new publisher
        Publisher asobo2 = new Publisher("asobo2", "9617 Avenue L2", "Brooklyn2", "New York2", "112252");  //cr

//    We created an author with its respective properties and we created a book with its respective properties
        Author john = new Author("John", "Steinbeck");  //creates a new Author
        Book thepearl = new Book("The Pearl", "648235");  //creates a new Book

//    Now we want to add an author to that book(Pearl) and add a book to that author (John)

        john.getBooks().add(thepearl);              //on the authors object, get the books list and add "thepearl" to it
        thepearl.getAuthors().add(john);            //on the books object, get the authors list and add "john" to it


//        thepearl.setPublisher(publisher);           //add in the publisher after creating the publisher on .....
//        publisher.getBooks().add(thepearl);         //on the publisher object, get the books and add thepearl to the books list

//  or asobo.getBooks().add(thepearl);          //on the publisher object, get the books and add thepearl to the books list

        authorRepo.save(john);                      //for this we have to use the initialized private final variable shortly above the constructor
        bookRepo.save(thepearl);                    //this will add thepearl to the book repository
        publiRepo.save(asobo);                      //this will add asobo to the publisher repository


        Author chinua = new Author("Chinua", "Achebe");
        Book thingsfallapart = new Book("Things Fall Apart", "53686234");

        chinua.getBooks().add(thingsfallapart);        //in the authors object, get the books list and add "thingsfallapart" to it
        thingsfallapart.getAuthors().add(chinua);      //in the books object, get the authors list and add "chinua" to it

//        thingsfallapart.setPublisher(publisher);
//        publisher.getBooks().add(thingsfallapart);



        authorRepo.save(chinua);
        bookRepo.save(thingsfallapart);
//    publiRepo.save(asobo2);

//  every time you implement the save method for bookRepo or authorRepo
//  this will add one element to the list

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books " + bookRepo.count());    //this will return the amount of books in the list
        System.out.println("Number of Authors " + authorRepo.count());    //this will return the amount of authors in the list
        System.out.println("Number of Publishers " + publiRepo.count());    //this will return the amount of publishers in the list

//    System.out.println("Number of publishers: " + publisher.getBooks().size());

//    @01:32:33



// FOR THE PARAMETERS OF THE PUBLISHER METHOD, YOU CAN DECLARE THEM IN THE PUBLISHER CLASS - publisher.java
// or you can declare them here like so....

//publisher.setName("asobo");
//publisher.setaddress("9617 Avenue L");
//publisher.setcity("Brooklyn");



    }
}
