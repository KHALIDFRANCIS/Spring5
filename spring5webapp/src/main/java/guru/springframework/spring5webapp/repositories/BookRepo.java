package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.domain.Book;
import org.springframework.data.repository.CrudRepository;



public interface BookRepo extends CrudRepository <Book, Long> {
    // this will take two generics, type and ID value
    //so type, in this class, will be Book and ID value is ID
}
