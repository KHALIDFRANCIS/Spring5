package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

//This is the repository for the Author Entity

public interface AuthorRepo extends CrudRepository <Author, Long>{
    // this will take two generics, type and ID value
    //so type, in this class, will be Author and ID value is Long
}

//look up a video on generics