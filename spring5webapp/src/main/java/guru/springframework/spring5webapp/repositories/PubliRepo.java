package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

//This is the repository for the Author Entity

public interface PubliRepo extends CrudRepository <Publisher, Long> {
}
