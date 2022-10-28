package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.repositories.BookRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

                                        //the controller annotation will make this into a spring mvc controller
@Controller                             //this is a class annotation at the class level
public class BookController {
//@01:50:00

   private final BookRepo bookrepo;    //this injected instance of the book repository will use the repository to enhance the viewed model with a list of books
                                        // bookrepo is the instance variable of the book repository
   public BookController(BookRepo bookrepo) {
       this.bookrepo = bookrepo;
    }

    @RequestMapping("/books")            //this request mapping will direct requests to this url....and executes the get books method
    public String getBooks(Model model) { //the model gets returned to the view so that the view gets a copy of the model
                                            //this is the model view controller - Spring MVC

    model.addAttribute("books", bookrepo.findAll());    //(String s, object o)
//        This will use the repository to get a list of books out of the database, assign it to the attribute of books

        return "books/list";
//        this will display all the Strings with the "books" attribute
    }
}
